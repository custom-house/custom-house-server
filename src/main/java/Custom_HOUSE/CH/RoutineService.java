/*package Custom_HOUSE.CH;

import Custom_HOUSE.CH.Repository.MemberRepository;
import Custom_HOUSE.CH.Repository.RoutineRepository;
import Custom_HOUSE.CH.model.Member;
import Custom_HOUSE.CH.model.Routine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoutineService implements UserDetailsService {

    @Autowired
    private RoutineRepository repository;

    @Override
    public UserDetails loadUserByUsername(String routineName) throws UsernameNotFoundException {

        Routine foundedRoutine = repository.findByUsername(routineName);
        if (foundedRoutine == null)
            return null;

        String name = foundedRoutine.getRoutineName();
        List<String> routine = foundedRoutine.getRoutine();
        return new User(name, null, new ArrayList<>());
    }
}

 */