package Custom_HOUSE.CH.Controller;

import Custom_HOUSE.CH.Repository.MemberRepository;
import Custom_HOUSE.CH.Repository.UserRepository;
import Custom_HOUSE.CH.model.Member;
import Custom_HOUSE.CH.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class MemberController {

    @Autowired
    private MemberRepository repository;

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private UserService UserService;

    @PostMapping("/api/new-member")
    public String saveMember(@RequestBody Member member) {
        repository.save(member);
        return "Added member with id: " + member.getId();
    }

    @GetMapping("/findAllMembers")
    public List<Member> getMembers() {
        return repository.findAll();
    }

    @GetMapping("/findAllMembers/{id}")
    public Optional<Member> getMember(@PathVariable int id) {
        return repository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMember(@PathVariable int id) {
        repository.deleteById(id);
        return "Deleted member with id: " + id;
    }

    @PostMapping("api/id")
    public String findId(@RequestParam("name") String name,
                               @RequestParam("birth") String birth){
        return UserRepository.findByNameAndBirth(name, birth).getId();
    }

    @PostMapping("api/pw")
    public String findPw(@RequestParam("id") String id,
                               @RequestParam("name") String name){
        return UserRepository.findByIdAndName(id, name).getPassword();
    }

    @GetMapping("api/duplicate/{id}")
    public ResponseEntity<Boolean> checkIdDuplicate(@PathVariable String id){
        return ResponseEntity.ok(UserService.checkIdDuplicate(id));
    }
//
//    @GetMapping("/id/check")
//    public ResponseEntity<?> checkIdDuplication(@RequestParam(value = "memberId") String memberId) throws BadRequestException {
//        System.out.println(memberId);
//
//        if (UserService.existsById(id) == true) {
//            throw new BadRequestException("이미 사용중인 아이디 입니다.");
//        } else {
//            return ResponseEntity.ok("사용 가능한 아이디 입니다.");
//        }
//    }
}

