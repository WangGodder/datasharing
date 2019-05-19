package top.godder.datamodule.infrastructure.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.godder.datamodule.domain.factory.UserBaseInfoFactory;
import top.godder.datamoduleapi.domain.aggregate.UserBaseInfo;
import top.godder.usermoduleapi.domain.entity.UserTk;

import static org.junit.Assert.*;

/**
 * @author: godder
 * @date: 2019/5/19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Import({JwtUtil.class, UserBaseInfoFactory.class})
@SpringBootTest
public class JwtUtilTest {
    @Autowired
    private JwtUtil jwtUtil;

    @Test
    public void createJWT() {
        UserTk userTk = new UserTk(1L, "godder");
        String jwt = jwtUtil.createJWT(userTk);
        System.out.println(jwt);
    }

    @Test
    public void verifyJWT() {
        UserTk userTk = new UserTk(1L, "godder");
        String jwt = jwtUtil.createJWT(userTk);
        UserBaseInfo baseInfo = jwtUtil.verifyJWT(jwt);
        assertNull(baseInfo);
    }
}