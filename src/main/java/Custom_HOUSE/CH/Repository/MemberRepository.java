package Custom_HOUSE.CH.Repository;

import Custom_HOUSE.CH.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends MongoRepository<Member, String> {
    Member findByUsername(String username);
}
