package top.godder.usermoduleapi.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import top.godder.infrastructurecommon.util.MD5;

import java.util.Objects;

/**
 * @author Godder
 */
@Getter
@Data
@NoArgsConstructor
public class UserTk {
    private Long id;

    private String userName;

    private String userPs;

    public boolean encryptionPs() {
        if (this.userPs == null || this.userPs.isEmpty()) {
            return false;
        }
        this.userPs = MD5.md5(this.userPs);
        return true;
    }

    public boolean verify(UserTk encryptionUserTk) {
        return MD5.md5Verify(this.getUserPs(), encryptionUserTk.getUserPs()) && this.userName.equalsIgnoreCase(encryptionUserTk.userName);
    }

    public UserTk(Long id, String userName, String userPs) {
        this.id = id;
        this.userName = userName == null ? null : userName.trim();
        this.userPs = userPs == null ? null : userPs.trim();
    }

    public UserTk(Long id, String userName) {
        this.id = id;
        this.userName = userName == null ? null : userName.trim();
    }

    public UserTk(String userName, String userPs) {
        this.userName = userName;
        this.userPs = userPs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserTk userTk = (UserTk) o;
        return Objects.equals(id, userTk.id) &&
                Objects.equals(userName, userTk.userName) &&
                Objects.equals(userPs, userTk.userPs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userPs);
    }
}