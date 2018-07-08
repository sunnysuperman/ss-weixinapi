package com.sunnysuperman.weixinapi.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sunnysuperman.commons.util.StringUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

public class XMLParser {

    public static Map<String, Object> getMapFromXML(String xmlString)
            throws ParserConfigurationException, IOException, SAXException {
        if (StringUtil.isEmpty(xmlString)) {
            return null;
        }

        // 这里用Dom的方式解析回包的最主要目的是防止API新增回包字段
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream in = new ByteArrayInputStream(xmlString.getBytes(StringUtil.UTF8_CHARSET));
        Document document = builder.parse(in);

        // 获取到document里面的全部结点
        NodeList allNodes = document.getFirstChild().getChildNodes();
        Node node;
        Map<String, Object> map = new HashMap<String, Object>();
        int i = 0;
        while (i < allNodes.getLength()) {
            node = allNodes.item(i);
            if (node instanceof Element) {
                map.put(node.getNodeName(), node.getTextContent());
            }
            i++;
        }
        return map;

    }

    public static String toXML(Object o) {
        XStream xStream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
        xStream.autodetectAnnotations(true);
        return xStream.toXML(o);
    }

    public static String toXML(Map<?, ?> map) {
        StringBuilder buf = new StringBuilder("<xml>");
        toXML(map, buf);
        buf.append("</xml>");
        return buf.toString();
    }

    private static void toXML(Map<?, ?> map, StringBuilder buf) {
        for (Entry<?, ?> entry : map.entrySet()) {
            String key = entry.getKey().toString();
            buf.append("<").append(key).append(">");
            Object value = entry.getValue();
            if (value != null) {
                if (value instanceof Map) {
                    toXML((Map<?, ?>) value, buf);
                } else {
                    if (value instanceof String) {
                        buf.append("<![CDATA[").append(value.toString()).append("]]>");
                    } else {
                        buf.append(value.toString());
                    }
                }
            }
            buf.append("</").append(key).append(">");
        }
    }

}