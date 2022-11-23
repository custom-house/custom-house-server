package Custom_HOUSE.CH.Controller;
import Custom_HOUSE.CH.Service.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class OAuthController {

    @Autowired
    private OAuthService oAuthService;

    @RequestMapping(value="/oauth/kakao")
    public void login(@RequestParam("code") String code) {
        String access_Token = oAuthService.getAccessToken(code);
        System.out.println("controller access_token : " + access_Token);
    }
}

