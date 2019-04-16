package top.godder.datamodule.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Auth {
    /**
     * 权限ID
     */
    @Id
    @Column(name = "auth_id")
    private Integer authId;

    /**
     * 权限名称
     */
    @Column(name = "auth_name")
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auth auth = (Auth) o;
        return Objects.equals(authId, auth.authId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authId);
    }
}