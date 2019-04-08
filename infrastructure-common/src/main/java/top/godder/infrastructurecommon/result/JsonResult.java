package top.godder.infrastructurecommon.result;

/**
 * Json格式返回结果的格式
 */
public class JsonResult extends ResultBase {

    public static JsonResult success() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatus(SUCCESS);
        return jsonResult;
    }

    public static JsonResult success(String msg) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatus(SUCCESS);
        jsonResult.setMessage(msg);
        return jsonResult;
    }

    public static JsonResult success(Object data) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatus(SUCCESS);
        jsonResult.setData(data);
        return jsonResult;
    }

    public static JsonResult fail(String msg) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setMessage(msg);
        return jsonResult;
    }

    public static JsonResult fail(int status, String msg) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatus(status);
        jsonResult.setMessage(msg);
        return jsonResult;
    }

    public static JsonResult fail(int status, String msg, Object data) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatus(status);
        jsonResult.setMessage(msg);
        jsonResult.setData(data);
        return jsonResult;
    }

    public static JsonResult fail(ErrorResult errorResult) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatus(errorResult.getCode());
        jsonResult.setMessage(errorResult.getMessage());
        return jsonResult;
    }

    public static JsonResult fail(ErrorResult errorResult, Object data) {
        JsonResult jsonResult = fail(errorResult);
        jsonResult.setData(data);
        return jsonResult;
    }

}
