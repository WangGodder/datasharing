package top.godder.usermoduleapi.dto;

import lombok.Data;

import java.util.Objects;

/**
 * @author: godder
 * @date: 2019/4/15
 */
@Data
public class UserInfo {
    private Long userId;

    /**
     * 用户公司
     */
    private String company;

    /**
     * 所在省份
     */
    private Integer provinceId;

    /**
     * 所在城市
     */
    private Integer cityId;

    /**
     * 性别
     */
    private String gender;

    private Integer age;

    /**
     * 自我介绍
     */
    private String introduce;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(userId, userInfo.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
