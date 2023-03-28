package com.example.quintor.getdata;

import com.example.quintor.dataobjects.Category;
import org.json.JSONObject;

public class GetCategory {
    public static Category makeCategoryJSON(JSONObject jsonObject) {
        int categoryId = (int) jsonObject.get("categoryId");
        String name = (String) jsonObject.get("name");

        return new Category(categoryId, name);
    }
}
