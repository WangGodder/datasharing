package top.godder.usermoduleapi.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author Godder
 */
@Getter
@NoArgsConstructor
public class City {
    private Integer cityId;

    /**
     * 城市名称
     */
    private String name;

    /**
     * 上级省份id
     */
    private Integer provinceId;

    /**
     * 城市信息
     */
    private String comment;

    public City(Integer cityId, String name, Integer provinceId, String comment) {
        this.cityId = cityId;
        this.name = name;
        this.provinceId = provinceId;
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
        City city = (City) o;
        return Objects.equals(cityId, city.cityId) &&
                Objects.equals(provinceId, city.provinceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, provinceId);
    }
}