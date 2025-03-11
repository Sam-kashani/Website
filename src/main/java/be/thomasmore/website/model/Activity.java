package be.thomasmore.website.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Activity {
    @Id
    private Integer id;

    private String name;
    private String description;
    private Integer summerCampId;


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getSummerCampId() { return summerCampId; }
    public void setSummerCampId(Integer summerCampId) { this.summerCampId = summerCampId; }
}
