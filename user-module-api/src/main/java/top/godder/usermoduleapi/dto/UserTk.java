package top.godder.usermoduleapi.dto;

import lombok.Data;

import java.util.Objects;

/**
 * @author Godder
 */
@Data
public class UserTk {
    private Long id;

    private String userName;

    private String userPs;

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