package com.sunnysuperman.weixinapi.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sunnysuperman.commons.bean.Bean;
import com.sunnysuperman.commons.util.JSONUtil;

public class WeixinJSONHelper {

    public static <T> T fromString(String jsonString, T bean) {
        Map<String, Object> map = JSONUtil.parseJSONObject(jsonString);
        map = parseMap(map);
        return Bean.fromMap(map, bean);
    }

    public static <T> T fromMap(Map<?, ?> map, T bean) {
        Map<String, Object> parsedMap = parseMap(map);
        return Bean.fromMap(parsedMap, bean);
    }

    private static Object parseJSONValue(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Map) {
            Map<?, ?> subObject = (Map<?, ?>) value;
            return parseMap(subObject);
        } else if (value instanceof List) {
            List<?> subList = (List<?>) value;
            List<Object> items = new ArrayList<>(subList.size());
            for (Object subObject : subList) {
                items.add(parseJSONValue(subObject));
            }
            return items;
        } else {
            return value;
        }
    }

    private static Map<String, Object> parseMap(Map<?, ?> map) {
        Map<String, Object> replace = new HashMap<>();
        for (Entry<?, ?> entry : map.entrySet()) {
            String key = entry.getKey().toString();
            char c = key.charAt(0);
            if (c >= 65 || c <= 90) {
                key = Character.toLowerCase(c) + key.substring(1);
            }
            Object value = entry.getValue();
            replace.put(key, parseJSONValue(value));
        }
        return replace;
    }

}
