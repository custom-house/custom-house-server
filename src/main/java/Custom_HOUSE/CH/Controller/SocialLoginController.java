/*package Custom_HOUSE.CH.Controller;

import Custom_HOUSE.CH.model.SocialUserInfoDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class SocialLoginController {
    private final KakaoUserService kakaoUserService;

    // 카카오 로그인
    @GetMapping("/user/kakao/callback")
    public SocialUserInfoDto kakaoLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {
        return kakaoUserService.kakaoLogin(code, response);
}
*/

