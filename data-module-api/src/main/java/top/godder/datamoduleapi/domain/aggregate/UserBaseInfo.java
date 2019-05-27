package top.godder.datamoduleapi.domain.aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.godder.datamoduleapi.domain.entity.Field;
import top.godder.datamoduleapi.domain.entity.Role;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/19
 * 记录用户基本信息(姓名、积分、所在领域、角色)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserBaseInfo {
    private Long userId;
    private String localName;
    private int credit;
    private List<Field> fieldList;
    private List<Role> roleList;
}
