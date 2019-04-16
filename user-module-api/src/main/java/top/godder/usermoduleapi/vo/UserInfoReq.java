package top.godder.usermoduleapi.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: godder
 * @date: 2019/3/27
 */
@Data
public class UserInfoReq implements Serializable {
    private String company;
    private Integer provinceId;
    private Integer cityId;
    private String gender;
    private Integer beginAge;
    private Integer endAge;
    private String major;
}
