package Custom_HOUSE.CH.Repository;

import Custom_HOUSE.CH.model.Member;
import Custom_HOUSE.CH.model.Routine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoutineRepository extends MongoRepository<Routine, String> {
    Routine findByRoutineName(String routineName);
}
