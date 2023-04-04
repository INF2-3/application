package com.example.quintor.getdata;

import com.example.quintor.dataobjects.Category;
import org.json.JSONObject;
import org.w3c.dom.Element;

public class GetCategory {
    /**
     * This method makes a Category object from a JSONObject
     *
     * @param jsonObject a JSON object with a categoryId and name
     * @return a Category object with an id and name.
     */
    public static Category makeCategoryJSON(JSONObject jsonObject) {
        int categoryId = (int) jsonObject.get("categoryId");
        String name = (String) jsonObject.get("name");
        return new Category(categoryId, name);
    }

    /**
     * This method makes a Category object from an Element.
     *
     * @param element An Element with a categoryId and name
     * @return a category object with an id and name
     */
    public static Category makeCategoryXML(Element element) {
        int id = Integer.parseInt(element.getElementsByTagName("categoryId").item(0).getTextContent());
        String name = element.getElementsByTagName("name").item(0).getTextContent();
        return new Category(id, name);
    }
}
