package top.godder.datamoduleapi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/**
 * 当前系统用户信息
 */
public class UserLocalInfo {

    private Long userId;

    /**
     * 用户名字
     */
    private String name;

    /**
     * 用户积分
     */
    private Integer credit;

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名字
     *
     * @return name - 用户名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名字
     *
     * @param name 用户名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取用户积分
     *
     * @return credit - 用户积分
     */
    public Integer getCredit() {
        return credit;
    }

    /**
     * 设置用户积分
     *
     * @param credit 用户积分
     */
    public void setCredit(Integer credit) {
        this.credit = credit;
    }
}