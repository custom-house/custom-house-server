package Custom_HOUSE.CH;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;

import java.util.ArrayList;

@Getter
@Setter
@ToString
public class AuthenticationRequest {
    private String username;
    private String password;
    private String routineName;
    private String routine;
    private String gender;
    private String age;
    private String household;
    private String id;
    private String email;
    private ObjectId _id;
    public AuthenticationRequest() {

    }

}
