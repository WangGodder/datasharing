package top.godder.usermoduleapi.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author Godder
 */
@Getter
@NoArgsConstructor
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

    public UserInfo(Long userId, String company, Integer provinceId, Integer cityId, String gender, Integer age, String introduce) {
        this.userId = userId;
        this.company = company;
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.gender = gender;
        this.age = age;
        this.introduce = introduce;
    }

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