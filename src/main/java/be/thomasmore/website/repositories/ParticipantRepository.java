package be.thomasmore.website.repositories;

import be.thomasmore.website.model.Participant;

import org.springframework.data.repository.CrudRepository;

public interface ParticipantRepository extends CrudRepository<Participant, Integer> {
}