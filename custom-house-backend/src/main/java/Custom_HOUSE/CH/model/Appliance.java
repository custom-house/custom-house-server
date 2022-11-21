package Custom_HOUSE.CH.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection="Appliance")
public class Appliance {
    @Id
    private int appliance_id;
    private String appliance_name;
    private int appliance_mod;
    private int appliance_mod_detail;

}
