package com.sunnysuperman.weixinapi.test;

import java.util.HashMap;
import java.util.Map;

import com.sunnysuperman.weixinapi.util.XMLParser;

public class XMLParserTest extends BaseTest {

    public void test_toXML() throws Exception {
        Map<String, Object> data = new HashMap<>();
        data.put("ToUserName", "1");
        data.put("FromUserName", "2");
        data.put("CreateTime", 3);
        data.put("MsgType", "text");
        data.put("Content", "xx");
        String xml = XMLParser.toXML(data);
        System.out.println(xml);
    }

}
