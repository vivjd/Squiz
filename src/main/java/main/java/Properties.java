package main.java;

import org.json.JSONArray;
import org.json.JSONObject;

public class Properties {
    private Title[] title;

    public Title[] getTitle() {
        return title;
    }

    public void setTitle(Title[] title) {
        this.title = title;
    }

    public JSONObject toJson() {
        JSONObject propertiesObject = new JSONObject();
        JSONArray titleArray = new JSONArray();

        for (Title titleItem : title) {
            JSONObject titleObject = new JSONObject();
            titleObject.put("text", titleItem.toJson());
            titleArray.put(titleObject);
        }

        propertiesObject.put("title", titleArray);
        return propertiesObject;
    }
}