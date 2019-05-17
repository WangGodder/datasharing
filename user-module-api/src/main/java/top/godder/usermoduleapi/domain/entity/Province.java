package top.godder.usermoduleapi.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author Godder
 */
@Getter
@NoArgsConstructor
public class Province {
    private Integer provinceId;

    /**
     * 省份名称
     */
    private String name;

    /**
     * 省份信息
     */
    private String comment;

    public Province(Integer provinceId, String name, String comment) {
        this.provinceId = provinceId;
        this.name = name;
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
        Province province = (Province) o;
        return Objects.equals(provinceId, province.provinceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(provinceId);
    }
}