package Custom_HOUSE.CH.Repository;

import Custom_HOUSE.CH.model.RecomRoutine;
import Custom_HOUSE.CH.model.Routine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoutineRecomRepository extends MongoRepository<RecomRoutine, String> {
}
