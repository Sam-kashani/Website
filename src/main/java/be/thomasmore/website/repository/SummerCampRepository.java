package be.thomasmore.website.repository;

import be.thomasmore.website.model.SummerCamp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SummerCampRepository extends CrudRepository<SummerCamp, Integer> {
    @Query("""

            SELECT c FROM SummerCamp c
WHERE (:name IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%')))
  AND (:location IS NULL OR LOWER(c.location) LIKE LOWER(CONCAT('%', :location, '%')))
  AND (:minParticipants IS NULL OR c.maxParticipants >= :minParticipants)
  AND (:maxPrice IS NULL OR c.price <= :maxPrice)
  AND (:campType IS NULL OR :campType = '' OR c.type = :campType)
""")
    List<SummerCamp> findByFilters(@Param("name") String name,
                                   @Param("location") String location,
                                   @Param("minParticipants") Integer minParticipants,
                                   @Param("maxPrice") Double maxPrice,
                                   @Param("campType") String campType);
    }
