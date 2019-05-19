package top.godder.datamodule.infrastructure.util;


import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import top.godder.datamodule.domain.factory.UserBaseInfoFactory;
import top.godder.datamoduleapi.domain.aggregate.UserBaseInfo;
import top.godder.usermoduleapi.domain.entity.UserTk;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author: godder
 * @date: 2019/5/19
 */
@Component
public class JwtUtil {
    /**
     * JWT有效期   （7 days)
     */
    private long expirationTime = 604800000;
    /**
     * JWT 密码
     */
    @Value(value = "${jwt.secret}")
    private String secret;
    /**
     * Token 前缀
     */
    @Value(value = "${jwt.token_prefix}")
    private String tokenPrefix;
    /**
     * 存放Token的http Header Key
     */
    private static final String HEADER_STRING = "Authorization";

    @Autowired
    private UserBaseInfoFactory userBaseInfoFactory;

    /**
     * 根据用户及其权限创建JWT
     * @param userTk
     * @return
     */
    public String createJWT(UserTk userTk) {
        String JWT = Jwts.builder()
                .claim("user", JSON.toJSONString(userTk))
                .setSubject(userTk.getUserName())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        return JWT;
    }

    /**
     * 验证JWT并返回用户相关信息(基本信息、权限)
     * @param JWT
     * @return
     */
    public UserBaseInfo verifyJWT(String JWT) {
        if (JWT == null || JWT.isEmpty()) {
            return null;
        }
        Claims claims = Jwts.parser()
                // 验签(检验密码)
                .setSigningKey(secret)
                // 删除前缀
                .parseClaimsJws(JWT.replace(tokenPrefix, ""))
                .getBody();

        String userName = claims.getSubject();
        if (userName == null || userName.isEmpty()) {
            return null;
        }
        UserTk userTk = JSON.parseObject((String) claims.get("user"), UserTk.class);
        Long userId = userTk.getId();
        return userBaseInfoFactory.createUserBaseInfo(userId);
    }

    /**
     * 从http request中获取http header中 Authorization 部分的jwt
     * @param request
     * @return
     */
    public static String getJWTFromRequest(HttpServletRequest request) {
        return request.getHeader(HEADER_STRING);
    }
}
