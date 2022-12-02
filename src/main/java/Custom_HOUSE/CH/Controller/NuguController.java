package Custom_HOUSE.CH.Controller;

import Custom_HOUSE.CH.Repository.RoutineRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class NuguController {

    @Autowired
    RoutineRepository repository;

    @PostMapping("/answer.routine")
    public ResponseEntity<String> answerRoutine(@RequestBody String jsonString) throws JSONException {
        System.out.println(jsonString);
        String returnValue = null;
        JSONObject jsonObject = new JSONObject();
        JSONObject j = new JSONObject();
        ArrayList<String> name = new ArrayList<>();
        JSONObject json = new JSONObject(jsonString);
        JSONObject action = json.getJSONObject("action");
        JSONObject parameters = action.getJSONObject("parameters");
        JSONObject routine = parameters.getJSONObject("routine");
        String value = routine.getString("value");
        try {
            if (repository.findByKeyword(value) != null) {
                String appliance = (repository.findByKeyword(value).getAppliance()).toString();
                JSONArray jsonArray = new JSONArray(appliance);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonobject = jsonArray.getJSONObject(i);
                    name.add(jsonobject.getString("name"));
                }
                jsonObject.put("applianceName", name);
                String version = "2.0";
                String resultCode = "OK";
                j.put("version", version);
                System.out.println(version.getClass().getName()/*j.getClass().getName()*/);
                j.put("resultCode", resultCode);
                j.put("output", jsonObject);

                returnValue = j.toString();
                System.out.println(j);

            }
        }
        catch (Exception e) {
            System.out.println("루틴은 디비에 없습니다ㅠㅠㅠ");
        }
        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }

}
