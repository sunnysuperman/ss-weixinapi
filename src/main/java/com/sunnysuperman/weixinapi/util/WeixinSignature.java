package com.sunnysuperman.weixinapi.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sunnysuperman.commons.util.FormatUtil;
import com.sunnysuperman.commons.util.StringUtil;

public class WeixinSignature {

    public static String getSign(Map<String, Object> kv, String secret) {
        Set<?> keySet = kv.keySet();
        List<String> keys = new ArrayList<String>(keySet.size());
        for (Object key : keySet) {
            keys.add(key.toString());
        }
        Collections.sort(keys);

        String encodeString = null;
        {
            StringBuilder buf = new StringBuilder();
            for (String key : keys) {
                String value = FormatUtil.parseString(kv.get(key));
                if (StringUtil.isEmpty(value)) {
                    continue;
                }
                buf.append(key).append('=').append(value).append('&');
            }
            buf.append("key=").append(secret);
            encodeString = buf.toString();
        }
        String realSign = WeixinHelper.md5(encodeString).toUpperCase();
        return realSign;
    }

    /**
     * 检验API返回的数据里面的签名是否合法，避免数据在传输的过程中被第三方篡改
     *
     */
    public static boolean checkSign(Map<String, Object> map, String key) {
        String sign = FormatUtil.parseString(map.remove("sign"));
        if (StringUtil.isEmpty(sign)) {
            return false;
        }
        // 将API返回的数据根据用签名算法进行计算新的签名，用来跟API返回的签名进行比较
        String realSign = getSign(map, key);
        if (!realSign.equals(sign)) {
            // 签名验不过，表示这个API返回的数据有可能已经被篡改了
            return false;
        }
        return true;
    }

}
