package top.godder.usermoduleapi.dto;

import lombok.Data;

/**
 * @author: godder
 * @date: 2019/4/15
 */
@Data
public class LoginUser {
    private UserInfo userInfo;
    private Province province;
    private City city;
}
