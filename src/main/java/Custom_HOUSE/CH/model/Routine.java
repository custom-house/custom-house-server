package Custom_HOUSE.CH.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection="Routine")
public class Routine {
    @Id
    private int routine_id;
    private String routine_name;
    private int routine_member_id;
    private int routine_appliance_id;
    private int routine_appliance_id_mod;
    private int routine_appliance_id_mod_detail;

}
