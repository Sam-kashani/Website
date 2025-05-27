package be.thomasmore.website.repositories;

import be.thomasmore.website.model.Activity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ActivityRepository extends CrudRepository<Activity, Integer> {
    List<Activity> findBySummerCampId(Integer summerCampId);
}
