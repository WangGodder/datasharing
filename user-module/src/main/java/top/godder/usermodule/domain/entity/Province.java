package top.godder.usermodule.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@NoArgsConstructor
@Table(name = "province")
public class Province {
    @Id
    @Column(name = "province_id")
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Province province = (Province) o;
        return Objects.equals(provinceId, province.provinceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(provinceId);
    }
}