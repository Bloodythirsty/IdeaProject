package com.kk.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class test {
    public static void main(String[] args) {
        TestJson testJson = new TestJson("张", "康");
        String s = JSON.toJSONString(testJson);
        System.out.println("s = " + s);

        TestJson testJson1 = JSON.parseObject(s, TestJson.class);
        System.out.println("testJson1 = " + testJson1);

        JSONObject jsonObject = (JSONObject)JSON.toJSON(testJson);
        String name = jsonObject.getString("name");
        System.out.println("name = " + name);
        System.out.println("jsonObject = " + jsonObject.getIntValue("dd"));
    }
}
