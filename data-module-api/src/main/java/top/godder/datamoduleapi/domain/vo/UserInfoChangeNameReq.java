package top.godder.datamoduleapi.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: godder
 * @date: 2019/5/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoChangeNameReq {
    private Long userId;
    private String newName;
}
