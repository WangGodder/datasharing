package top.godder.datamodule.domain.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Role {
    @Id
    private String title;

    @Id
    @Column(name = "production_year")
    private Short productionYear;

    @Id
    private String description;

    private String id;

    private String credits;

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * @return production_year
     */
    public Short getProductionYear() {
        return productionYear;
    }

    /**
     * @param productionYear
     */
    public void setProductionYear(Short productionYear) {
        this.productionYear = productionYear;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return credits
     */
    public String getCredits() {
        return credits;
    }

    /**
     * @param credits
     */
    public void setCredits(String credits) {
        this.credits = credits == null ? null : credits.trim();
    }
}