package Custom_HOUSE.CH.Controller;

import Custom_HOUSE.CH.Repository.RoutineRepository;
import Custom_HOUSE.CH.Service.RoutineService;
import Custom_HOUSE.CH.model.Routine;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RoutineController {

    @Autowired
    RoutineService service;

    @Autowired
    private RoutineRepository repository;

    @PostMapping("/new-routine")
    public String saveMember(@RequestBody Routine routine) {
        repository.save(routine);
        return "Added member with Routine Name: " + routine.getRoutineName();
    }

    @GetMapping("/findRoutine")
    public List<Routine> getAllRoutine() {
        return repository.findAll();
    }

    @GetMapping("/routine/{userId}")
    public List<String> getRoutine(@PathVariable("userId") String userId) {
        List<Routine> routines = repository.findAllByUserId(userId);
        return routines.stream()
                .map(Routine::getRoutineName)
                .collect(Collectors.toList());
    }

    @GetMapping("/trending-routines")
    public List<Routine> getTrendingRoutines() {
        List<Routine> topRoutine = service.getTop().get();
        return topRoutine;
    }

    @PostMapping("/routine-incrementation/{routineName}")
    public void routineIncrementation(@PathVariable("routineName") String routineName) {
        Routine routine = new Routine();
        routine = repository.findByRoutineName(routineName);
        int downloadNumber = repository.findByRoutineName(routineName).getNumberOfDownload();
        int incremented_downloadNumber = downloadNumber + 1;
        routine.setNumberOfDownload(incremented_downloadNumber);
        repository.save(routine);






    }
    /*
    @GetMapping("/findRoutine/{routineName}")
    public Optional<Routine> getRoutine(@PathVariable String routineName) {
        return repository.findByRoutineName(routineName);
    }

     */
    /*
    private ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest) {

        String routineName = authenticationRequest.getRoutineName();
        String rt = authenticationRequest.getRoutine();

        Routine routine = new Routine();
        routine.setUsername(routineName);
        routine.setRoutine(rt);
        try {
            repository.save(routine);
        }
        catch (Exception e) {
            return ResponseEntity.ok(new AuthenticationResponse("Error during Routine Subscription " + routineName));
        }

        return ResponseEntity.ok(new AuthenticationResponse("Successful Subscription for Routine " + routineName));
    }

         */


}
