package top.godder.datamodule.infrastructure.util;


import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import top.godder.datamodule.domain.factory.UserBaseInfoFactory;
import top.godder.datamoduleapi.domain.aggregate.UserBaseInfo;
import top.godder.datamoduleapi.domain.entity.Auth;
import top.godder.datamoduleapi.domain.entity.Role;
import top.godder.usermoduleapi.domain.entity.UserTk;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/19
 */
public class JwtUtil {
    /**
     * JWT有效期   （7 days)
     */
    @Value(value = "${jwt.expiration_time}")
    static long EXPIRATIONTIME;
    /**
     * JWT 密码
     */
    @Value(value = "${jwt.secret}")
    static String SECRET;
    /**
     * Token 前缀
     */
    @Value(value = "${jwt.token_prefix}")
    static String TOKEN_PREFIX;
    /**
     * 存放Token的http Header Key
     */
    static final String HEADER_STRING = "Authorization";

    /**
     * 根据用户及其权限创建JWT
     * @param userTk
     * @param role
     * @param auths
     * @return
     */
    static String createJWT(UserTk userTk, Role role, List<Auth> auths) {
        String JWT = Jwts.builder()
                .claim("user", JSON.toJSONString(userTk))
                .setSubject(userTk.getUserName())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return JWT;
    }

    /**
     * 验证JWT并返回用户相关信息(基本信息、权限)
     * @param JWT
     * @return
     */
    static UserBaseInfo verifyJWT(String JWT) {
        if (JWT == null || JWT.isEmpty()) {
            return null;
        }
        Claims claims = Jwts.parser()
                // 验签(检验密码)
                .setSigningKey(SECRET)
                // 删除前缀
                .parseClaimsJws(JWT.replace(TOKEN_PREFIX, ""))
                .getBody();

        String userName = claims.getSubject();
        if (userName == null || userName.isEmpty()) {
            return null;
        }
        UserTk userTk = JSON.parseObject((String) claims.get("user"), UserTk.class);
        Long userId = userTk.getId();
        return UserBaseInfoFactory.createUserBaseInfo(userId);
    }

    /**
     * 从http request中获取http header中 Authorization 部分的jwt
     * @param request
     * @return
     */
    static String getJWTFromRequest(HttpServletRequest request) {
        return request.getHeader(HEADER_STRING);
    }
}
