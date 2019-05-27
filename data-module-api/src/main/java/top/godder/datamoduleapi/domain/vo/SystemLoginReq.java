package top.godder.datamoduleapi.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: godder
 * @date: 2019/5/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SystemLoginReq implements Serializable {
    private String userName;
    private String password;
}
