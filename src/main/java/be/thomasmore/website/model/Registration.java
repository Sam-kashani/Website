package be.thomasmore.website.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer participantId;
    private Integer summerCampId;
    private LocalDate registrationDate;
    private LocalTime registrationTime;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getParticipantId() { return participantId; }
    public void setParticipantId(Integer participantId) { this.participantId = participantId; }

    public Integer getSummerCampId() { return summerCampId; }
    public void setSummerCampId(Integer summerCampId) { this.summerCampId = summerCampId; }

    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }

    public LocalTime getRegistrationTime() { return registrationTime; }
    public void setRegistrationTime(LocalTime registrationTime) { this.registrationTime = registrationTime; }
}


