package Custom_HOUSE.CH;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthenticationResponse {
    private String response;

    public AuthenticationResponse() {}
    public AuthenticationResponse(String response) {
        this.response = response;
    }

}
