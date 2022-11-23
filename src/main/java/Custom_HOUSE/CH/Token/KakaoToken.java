/*package Custom_HOUSE.CH.Token;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class KakaoToken {
    public String getAccessTokenByCode(String code) {

        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", "<REST API>");
        params.add("redirect_uri", "<Redirect_URI>" + "/oauth2/code/kakao");
        params.add("code", code);
        params.add("client_secret", "");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        String url = "https://kauth.kakao.com/oauth/token";

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        try {
            return objectMapper.readValue(response.getBody(), KakaoAccessTokenDto.class).getAccess_token();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getUserInfoByAccessToken(String accessToken) {

        org.springframework.http.HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        String url = "https://kapi.kakao.com/v2/user/me";

        return restTemplate.postForObject(url, request, String.class);
    }
}

 */