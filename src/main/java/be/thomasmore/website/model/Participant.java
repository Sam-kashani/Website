package be.thomasmore.website.model;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private int age;
    private String username;
    @ManyToMany
    private Set<SummerCamp> camps;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public Set<SummerCamp> getCamps() { return camps; }
    public void setCamps(Set<SummerCamp> camps) { this.camps = camps; }

}
