package top.godder.infrastructurecommon.result;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: godder
 * @date: 2019/4/3
 */
@Setter
@Getter
public class ErrorResult implements Serializable {
    private Integer code;
    private String message;

    public ErrorResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
