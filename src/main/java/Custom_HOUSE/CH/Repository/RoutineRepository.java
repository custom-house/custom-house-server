package Custom_HOUSE.CH.Repository;

import Custom_HOUSE.CH.model.Member;
import Custom_HOUSE.CH.model.Routine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoutineRepository extends MongoRepository<Routine, String> {
    List<Routine> findAllByUserId(String userId);
    List<Routine> findAll();
    Routine findByUserId(String userId);
    Routine findByRoutineName(String routineName);
    Routine findByKeyword(String keyword);

}