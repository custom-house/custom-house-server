package Custom_HOUSE.CH.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection="Member")
public class Member {
    @Id
    private ObjectId _id;
    private String userId;
    private String username;
    private String password;
    private String gender;
    private String age;
    private String household;


}
