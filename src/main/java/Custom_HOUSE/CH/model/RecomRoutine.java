package Custom_HOUSE.CH.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection="RecomRoutine")
public class RecomRoutine {
    @Id
    private String recomId;
    private String userId;
    private String userName;
    private String keyWord;
    private String time_Set;
    private String routineName;
    private String routineDesc;
    private Object appliance;
}
