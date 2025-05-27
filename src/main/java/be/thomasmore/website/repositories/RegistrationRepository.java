package be.thomasmore.website.repositories;

import be.thomasmore.website.model.Registration;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegistrationRepository extends CrudRepository<Registration, Integer> {
    List<Registration> findBySummerCampId(Integer summerCampId);
    List<Registration> findByParticipantId(Integer participantId);
}

