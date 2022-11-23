package Custom_HOUSE.CH.Controller;

import Custom_HOUSE.CH.AuthenticationRequest;
import Custom_HOUSE.CH.AuthenticationResponse;
import Custom_HOUSE.CH.Repository.RoutineRepository;
import Custom_HOUSE.CH.model.Member;
import Custom_HOUSE.CH.model.Routine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class RoutineController {

    @Autowired
    private RoutineRepository repository;

    @PostMapping("/new-routine")
    public String saveMember(@RequestBody Routine routine) {
        Logger logger = Logger.getLogger(RoutineController.class.getName());
        logger.info(routine.getAppliance());
        repository.save(routine);
        return "Added member with Routine Name: " + routine.getRoutineName();
    }

    @GetMapping("/findRoutine")
    public List<Routine> getAllRoutine() {
        return repository.findAll();
    }

    @GetMapping("/findRoutine/{routineName}")
    public Routine getRoutine(@PathVariable("routineName") String routineName) {
        return repository.findByRoutineName(routineName);
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
