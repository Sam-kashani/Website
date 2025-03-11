package be.thomasmore.website.model;

public class RegistrationForm {
    private String participantName;
    private String participantEmail;
    private Integer participantAge;
    private Integer summerCampId;

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getParticipantEmail() {
        return participantEmail;
    }

    public void setParticipantEmail(String participantEmail) {
        this.participantEmail = participantEmail;
    }

    public Integer getParticipantAge() {
        return participantAge;
    }

    public void setParticipantAge(Integer participantAge) {
        this.participantAge = participantAge;
    }

    public Integer getSummerCampId() {
        return summerCampId;
    }

    public void setSummerCampId(Integer summerCampId) {
        this.summerCampId = summerCampId;
    }
}
