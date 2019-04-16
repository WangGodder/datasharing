package top.godder.usermoduleapi.service;

/**
 * @author: godder
 * @date: 2019/3/17
 */

/**
 * 用于存放User Api的url地址
 */
public class Urls {
    public static class UserTkApiUrl {
        public static final String LOGIN = "/login";
        public static final String REGISTER = "/register";
        public static final String UPDATE_USER_TK = "/changeps";
        public static final String DELETE_USER_TK = "/logout";
    }

    public static class UserInfoApiUrl {
        public static final String GET_USER_INFO = "/user/userInfo";
        public static final String GET_ALL_USER_INFO = "/user/allUserInfo";
        public static final String REQ_USER_INFO = "/user/userInfoReq";
        public static final String UPDATE_USER_INFO = "/user/updateUserInfo";
        public static final String ADD_USER_INFO = "/user/addUserInfo";
        public static final String DELETE_USER_INFO = "/user/deleteUserInfo";
    }

    public static class ProvinceApiUrl {
        public static final String GET_PROVINCE = "/region/province";
        public static final String GET_ALL_PROVINCE = "/region/allProvince";
        public static final String ADD_PROVINCE = "/region/addProvince";
        public static final String UPDATE_PROVINCE = "/region/updateProvince";
        public static final String DELETE_PROVINCE = "/region/deleteProvince";
    }

    public static class CityApiUrl {
        public static final String GET_CITY = "/region/city";
        public static final String GET_ALL_CITY = "/region/allCity";
        public static final String GET_CITY_BY_PROVINCE = "/region/cityByProvince";
        public static final String ADD_CITY = "/region/addCity";
        public static final String UPDATE_CITY = "/region/updateCity";
        public static final String DELETE_CITY = "/region/deleteCity";
    }

    public static class LoginUserApiUrl {
        public static final String GET_LOGIN_USER = "/user/loginUser";
    }
}
