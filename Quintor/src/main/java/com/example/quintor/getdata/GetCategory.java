package com.example.quintor.getdata;

import com.example.quintor.dataobjects.Category;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetCategory {
    /**
     * This method makes a Category object from a JSONObject
     *
     * @param jsonObject a JSON object with a categoryId and name
     * @return a Category object with an id and name.
     */
    public static Category makeCategoryJSON(JSONObject jsonObject) {
        int categoryId = (int) jsonObject.get("categoryId");
        String name = GetTransactions.checkJsonObject("name", jsonObject);
        if (name != null) {
            return new Category(categoryId, name);
        }
        return null;
    }

    /**
     * This method makes a Category object from an Element.
     *
     * @param element An Element with a categoryId and name
     * @return a category object with an id and name
     */
    public static Category makeCategoryXML(Element element) {
        if (!isNodeEmpty(element.getElementsByTagName("name").item(0))) {
            int id = Integer.parseInt(element.getElementsByTagName("categoryId").item(0).getTextContent());
            String name = element.getElementsByTagName("name").item(0).getTextContent();
            return new Category(id, name);
        }
        return null;
    }

    private static boolean isNodeEmpty(Node node) {
        if (node == null) {
            return true;
        }
        return node.getTextContent() == null;
    }
}
