package be.thomasmore.website.repositories;

import be.thomasmore.website.model.Participant;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ParticipantRepository extends CrudRepository<Participant, Integer> {
    Optional<Participant> findByUsername(String username);
    List<Participant> findAllByOrderByNameAsc();


}