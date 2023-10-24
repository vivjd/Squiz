package notion;

import org.json.JSONObject;

public class Title {
    private Text text;


    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public JSONObject toJson() {

        return text.toJson();
    }
}
