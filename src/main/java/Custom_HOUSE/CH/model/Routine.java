package Custom_HOUSE.CH.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Document(collection="Routine")
public class Routine {

    @Id
    private String routine_Id;
    private String userId;
    private String userName;
    private String routineName;
    private String keyword;
    private String time_Set;
    private Object appliance;
    private int numberOfDownload;


}

