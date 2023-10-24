package notion;

import org.json.JSONObject;

public class Parent {
    private String pageId;

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public JSONObject toJson() {
        JSONObject parentObject = new JSONObject();
        parentObject.put("page_id", pageId);
        return parentObject;
    }
}
