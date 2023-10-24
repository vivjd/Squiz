package notion;

import org.json.JSONObject;

public class Text {
    private String content;

    public Text(String content) {
        this.content = content;
    }
    public Text() {
        this.content = "";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public JSONObject toJson() {
        JSONObject textObject = new JSONObject();
        textObject.put("content", content);
        return textObject;
    }
}