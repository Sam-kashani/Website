package be.thomasmore.website.repositories;

import be.thomasmore.website.model.Participant;
import be.thomasmore.website.model.Registration;
import be.thomasmore.website.model.SummerCamp;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegistrationRepository extends CrudRepository<Registration, Integer> {

    boolean existsByParticipantAndCamp(Participant participant, SummerCamp camp);

    Registration findByParticipantAndCamp(Participant participant, SummerCamp camp);

    List<Registration> findByParticipant(Participant participant);
}

