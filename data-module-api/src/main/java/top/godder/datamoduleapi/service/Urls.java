package top.godder.datamoduleapi.service;

/**
 * @author: godder
 * @date: 2019/5/19
 */
public class Urls {
    public static class LoginApi {
        public static final String LOGIN = "/login";
        public static final String REGISTER = "/register";
    }

    public static class UserInfoApi {
        public static final String GET_BASE_INFO = "/userInfo/getBaseInfo";
        public static final String CHANGE_NAME = "/userInfo/changeName";
        public static final String CHANGE_CREDIT = "/userInfo/changeCredit";
        public static final String ADD_FIELD = "/userInfo/addField";
        public static final String DELETE_FIELD = "/userInfo/deleteField";
    }

    public static class FieldApi {
        public static final String GET_ALL_FIELD = "/field/getAllField";
        public static final String GET_SUB_FIELD = "/field/getSubField";
        public static final String GET_FIELD_BY_FILE = "/field/getFieldByFile";
        public static final String ADD_FIELD = "/field/addField";
        public static final String UPDATE_FIELD = "/field/updateField";
    }

    public static class FileApi {
        public static final String GET_ALL_DATA_FILE = "/datafile/getAllFile";
        public static final String GET_DATA_FILE_SUB_FIELD = "/datafile/getDataFileByField";
        public static final String GET_DATA_FILE_BY_USER = "/datafile/getDataFileByUser";
        public static final String GET_DATA_FILE = "/datafile/getDataFile";
        public static final String GET_DATA_FILE_BY_REQ = "/datafile/getDataFileByReq";
        public static final String USER_HAS_BUY = "/datafile/userHasBuy";
        public static final String USER_BUY_LIST = "/datafile/userBuyList";
        public static final String INSERT_DATA_FILE = "/datafile/insertDataFile";
        public static final String DELETE_DATA_FILE = "/datafile/deleteDataFile";
        public static final String GET_DATA_FILE_NAME_LIST = "/datafile/getDataFileNameList";
        public static final String DOWNLOAD_DATA_FILE = "/datafile/downloadDataFile";
        public static final String UPLOAD_DATA_FILE = "/datafile/uploadDataFile";
    }

    public static class FileCommentApi {
        public static final String GET_COMMENT_BY_FILE = "/datafile/getFileComments";
        public static final String GET_COMMENT_BY_USER = "/datafile/getFileCommentsByUser";
        public static final String GET_COMMENT_BY_LEVEL = "/datafile/getFileCommentByLevel";
        public static final String GET_AVG_LEVEL = "/datafile/getAvgLevel";
        public static final String ADD_COMMENT = "/datafile/addFileComment";
    }
}
