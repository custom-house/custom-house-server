package Custom_HOUSE.CH.Controller;

import Custom_HOUSE.CH.AuthenticationRequest;
import Custom_HOUSE.CH.AuthenticationResponse;
//import Custom_HOUSE.CH.Jwt.JwtUtils;
import Custom_HOUSE.CH.Repository.MemberRepository;
//import Custom_HOUSE.CH.Service.KakaoService;
import Custom_HOUSE.CH.Service.MemberService;
import Custom_HOUSE.CH.model.Member;
import lombok.extern.java.Log;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Logger;

@RestController
public class MemberController {

    @Autowired
    private MemberRepository repository;

    @Autowired
    MemberService memberService;

   // @Autowired
    //KakaoService kakaoService;

    @Autowired
    AuthenticationManager authenticationManager;

    //@Autowired
    //private JwtUtils jwtUtils;
    @PostMapping("/new-member")
    public String saveMember(@RequestBody Member member) {
        Logger logger = Logger.getLogger(MemberController.class.getName());
        logger.info(member.getPassword());
        repository.save(member);
        return "Added member with username: " + member.getUsername() + "and password is " + member.getPassword();
    }
    /*private ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest) {
        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();
        String id = authenticationRequest.getId();
        String gender = authenticationRequest.getGender();
        String dateTime = authenticationRequest.getAge();
        String household = authenticationRequest.getHousehold();

        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        member.setId(id);
        member.setGender(gender);
        member.setAge(dateTime);
        member.setHousehold(household);
        try {
            repository.save(member);
        }
        catch (Exception e) {
            return ResponseEntity.ok(new AuthenticationResponse("Error during client Subscription " + username));
        }

        return ResponseEntity.ok(new AuthenticationResponse("Successful Subscription for client " + username));
    }

     */

    @PostMapping("/login")
    private List<String> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest) {
        List<String> list = new ArrayList<>();
        String password = authenticationRequest.getPassword();
        String userId = authenticationRequest.getUserId();
        Logger logger = Logger.getLogger(MemberController.class.getName());
        logger.info("FINDBYUSERNAMEGETID");
        Object _id = repository.findByUserId(userId).get_id();
        String name = repository.findByUserId(userId).getUsername();
        logger.info("NAME");
        logger.info(name);
        logger.info("IDTOSTRING");
        String string_id = _id.toString();
        logger.info(string_id);
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, password));
        }
        catch (Exception e) {
            list.add("ID or password is incorrect!");
            return list;
        }
        list.add(string_id);
        list.add(name);
        return list;
    }

    /*@GetMapping("/findMember/{username}")
    public Member getMember(@PathVariable("username") String username) {
        return repository.findByUsername(username);
    }

     */
    @GetMapping("/member-info/{userId}")
    public Member getMember(@PathVariable("userId") String userId) {
        return repository.findByUserId(userId);
    }

    @GetMapping("/users")
    public List<Member> getMembers() {
        return repository.findAll();
    }

   /* @RequestMapping(value="/kakaoLogin", method=RequestMethod.GET)
    public String kakaoLogin(@RequestParam(value = "code", required = false) String code) throws Exception {
        System.out.println("#########" + code);
        String access_Token = kakaoService.getAccessToken(code);
        Map<String, Object> userInfo = kakaoService.getUserInfo(access_Token);
        System.out.println("###access_Token#### : " + access_Token);
        System.out.println("###nickname#### : " + userInfo.get("nickname"));
        System.out.println("###email#### : " + userInfo.get("email"));
        return "/testPage";
    }

    */
/*
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
    }a

    @DeleteMapping("/delete/{id}")
    public String deleteMember(@PathVariable int id) {
        repository.deleteById(id);
        return "Deleted member with id: " + id;
    }

 */
}
