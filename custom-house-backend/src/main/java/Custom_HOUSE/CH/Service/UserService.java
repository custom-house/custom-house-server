package Custom_HOUSE.CH.Service;
import Custom_HOUSE.CH.Repository.MemberRepository;
import Custom_HOUSE.CH.Repository.UserRepository;
import Custom_HOUSE.CH.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
public class UserService {
    @Autowired
    private UserRepository UserRepository;

    public boolean checkIdDuplicate(String id) {
        return UserRepository.existsById(id);
    }
    }
