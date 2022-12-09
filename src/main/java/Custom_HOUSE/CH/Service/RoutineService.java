package Custom_HOUSE.CH.Service;

import Custom_HOUSE.CH.Repository.RoutineRepository;
import Custom_HOUSE.CH.model.Routine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RoutineService {

    @Autowired
    RoutineRepository repository;

    private final static int TOP = 5;

    public Optional<List<Routine>> getTop() {
        Page<Routine> topRoutine = repository.findAll(PageRequest.of(0, TOP, Sort.by(Sort.Order.desc("numberOfDownload"))));
        return Optional.of(topRoutine.getContent());
    }
}
