package top.godder.infrastructurecommon.result;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 数据返回结果的基础格式
 */
public abstract class ResultBase {

    public static int SUCCESS = 0; //成功
    public static int FAILURE = 1; //失败

    public ResultBase() {
        this.status = FAILURE;
    }

    private int status;
    private String message;
    private Object data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
