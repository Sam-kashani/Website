package be.thomasmore.website.repository;

import be.thomasmore.website.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    List<Activity> findBySummerCampId(Integer summerCampId);
}
