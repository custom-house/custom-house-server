package Custom_HOUSE.CH.Repository;

import Custom_HOUSE.CH.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Member, Long> {
    Member findByNameAndBirth(String name, String birth);
    Member findByIdAndName(String id, String name);
    boolean existsById(String id);
}
