package be.thomasmore.website.repositories;

import be.thomasmore.website.model.Participant;
import be.thomasmore.website.model.Registration;
import be.thomasmore.website.model.SummerCamp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistrationRepository extends CrudRepository<Registration, Integer> {
    @Query("select r from Registration r where"
            + " :textFilter is null"
            + " or r.participant.name ilike concat('%',:textFilter,'%')"
            + " or r.camp.name ilike concat('%',:textFilter,'%')")

    List<Registration> findByFilter(@Param("textFilter") String textFilter );

    boolean existsByParticipantAndCamp(Participant participant, SummerCamp camp);

    Registration findByParticipantAndCamp(Participant participant, SummerCamp camp);

    List<Registration> findByParticipant(Participant participant);
}

