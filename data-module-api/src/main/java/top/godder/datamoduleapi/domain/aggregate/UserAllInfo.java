package top.godder.datamoduleapi.domain.aggregate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.godder.datamoduleapi.domain.entity.UserLocalInfo;
import top.godder.usermoduleapi.domain.entity.UserInfo;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/18
 * 当前系统的用户信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAllInfo {
    private UserInfo userInfo;
    private UserLocalInfo userLocalInfo;
    private List<Long> fields;

}
