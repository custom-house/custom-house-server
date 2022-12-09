package Custom_HOUSE.CH.Controller;

import Custom_HOUSE.CH.Repository.RoutineRepository;
import Custom_HOUSE.CH.model.Routine;
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
import java.util.List;
import java.util.logging.Logger;

@RestController
public class NuguController {

    @Autowired
    RoutineRepository repository;

    @PostMapping("/answer.routine")
    public ResponseEntity<String> Routine(@RequestBody String jsonString) throws JSONException {
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
    @PostMapping("/answer.routineStart")
    public ResponseEntity<String> answerRoutine(@RequestBody String jsonString) throws JSONException {
        System.out.println(jsonString);
        String returnValue = null;
        JSONObject jsonObject = new JSONObject();
        JSONObject j = new JSONObject();
        ArrayList<String> name = new ArrayList<>();
        JSONObject json = new JSONObject(jsonString);
        JSONObject action = json.getJSONObject("action");
        JSONObject parameters = action.getJSONObject("parameters");
        JSONObject routine = parameters.getJSONObject("RoutineKeyword");
        String value = routine.getString("value");
        System.out.println(value);
        System.out.println(repository.findByKeyword(value));
        try {
            if (repository.findByKeyword(value) != null) {
                String appliance = (repository.findByKeyword(value).getAppliance()).toString();
                JSONArray jsonArray = new JSONArray(appliance);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonobject = jsonArray.getJSONObject(i);
                    name.add(jsonobject.getString("name"));
                    System.out.println("HIIIIIIIIIIIIIIIIIII");
                }
                jsonObject.put("appliance_name", name);
                String version = "2.0";
                String resultCode = "OK";
                j.put("version", version);
                System.out.println(version.getClass().getName()/*j.getClass().getName()*/);
                j.put("resultCode", resultCode);
                j.put("output", jsonObject);

                System.out.println(j);
                returnValue = j.toString();

            }
        }
        catch (Exception e) {
            System.out.println("루틴은 디비에 없습니다ㅠㅠㅠ");
        }
        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }

    @PostMapping("/stop.appliance3")
    public ResponseEntity<String> routineAppliances(@RequestBody String jsonString) throws JSONException{
        Routine nuguRoutine = new Routine();
        List<Object> appliances = new ArrayList<>();
        System.out.println(jsonString);
        String returnValue = null;
        JSONObject jsonObject = new JSONObject();
        JSONObject j = new JSONObject();
        ArrayList<String> name = new ArrayList<>();
        JSONObject json = new JSONObject(jsonString);
        JSONObject action = json.getJSONObject("action");
        JSONObject parameters = action.getJSONObject("parameters");
        JSONObject routine_keyword = parameters.getJSONObject("routine_keyword");
        String routine_keywordString_value = routine_keyword.getString("value");
        nuguRoutine.setKeyword(routine_keywordString_value);
        name.add(routine_keywordString_value);
        JSONObject user_Name = parameters.getJSONObject("user_Name");
        String user_name_value = user_Name.getString("value");
        nuguRoutine.setUserName(user_name_value);
        name.add(user_name_value);
        JSONObject routine_name = parameters.getJSONObject("routine_name");
        String routine_name_value = routine_name.getString("value");
        nuguRoutine.setRoutineName(routine_name_value);
        name.add(routine_name_value);
        JSONObject user_appliances = parameters.getJSONObject("user_appliances");
        String user_appliances_value = user_appliances.getString("value");
        JSONObject user_appliances_two = (JSONObject) parameters.get("user_appliances_two");
        String user_appliances_two_value = user_appliances_two.getString("value");
        appliances.add(user_appliances_value);
        appliances.add(user_appliances_two_value);
        nuguRoutine.setAppliance(user_appliances_value);
        nuguRoutine.setAppliance(appliances);
        name.add(user_appliances_value);
        repository.save(nuguRoutine);
        System.out.println(name);

        jsonObject.put("user_Name", user_name_value);
        jsonObject.put("routine_name", routine_name_value);
        jsonObject.put("routine_keyword", routine_keywordString_value);
        jsonObject.put("user_appliances", user_appliances_value);
        String version = "2.0";
        String resultCode = "OK";
        j.put("version", version);
        System.out.println(version.getClass().getName()/*j.getClass().getName()*/);
        j.put("resultCode", resultCode);
        j.put("output", jsonObject);

        returnValue = j.toString();

       return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }

}
