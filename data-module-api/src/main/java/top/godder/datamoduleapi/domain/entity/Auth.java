package top.godder.datamoduleapi.domain.entity;


import lombok.Getter;

import java.util.Objects;


@Getter
/**
 * 权限
 */
public class Auth {
    /**
     * 权限ID
     */
    private Integer authId;

    /**
     * 权限名称
     */
    private String authName;

    /**
     * 权限信息
     */
    private String comment;

    public Auth(String authName, String comment) {
        this.authName = authName;
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Auth auth = (Auth) o;
        return Objects.equals(authId, auth.authId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authId);
    }
}