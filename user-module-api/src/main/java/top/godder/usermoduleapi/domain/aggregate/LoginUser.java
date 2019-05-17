package top.godder.usermoduleapi.domain.aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.godder.usermoduleapi.domain.entity.City;
import top.godder.usermoduleapi.domain.entity.Province;
import top.godder.usermoduleapi.domain.entity.UserInfo;

/**
 * @author: godder
 * @date: 2019/4/8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 用于存放从用户系统获取的所有信息
 */
public class LoginUser {
    private UserInfo userInfo;
    private Province province;
    private City city;
}
