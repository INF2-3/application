package com.example.quintor.getdata;

import com.example.quintor.dataobjects.Category;
import org.json.JSONObject;
import org.w3c.dom.Element;

public class GetCategory {
    public static Category makeCategoryJSON(JSONObject jsonObject) {
        int categoryId = (int) jsonObject.get("categoryId");
        String name = (String) jsonObject.get("name");

        return new Category(categoryId, name);
    }

    public static Category makeCategoryXML(Element element) {
        int id = Integer.parseInt(element.getElementsByTagName("categoryId").item(0).getTextContent());
        String name = element.getElementsByTagName("name").item(0).getTextContent();
        return new Category(id, name);
    }
}
