package com.sunnysuperman.weixinapi.test;

import java.util.Arrays;
import java.util.Map;

import com.sunnysuperman.commons.util.ByteUtil;
import com.sunnysuperman.commons.util.JSONUtil;
import com.sunnysuperman.commons.util.StringUtil;

public class KeyStoreSerializer {
    public static class ContextAwareKeyStore {
        private byte[] keystore;
        private Map<String, Object> context;

        public ContextAwareKeyStore(byte[] keystore, Map<String, Object> context) {
            super();
            this.keystore = keystore;
            this.context = context;
        }

        public byte[] getKeystore() {
            return keystore;
        }

        public Map<String, Object> getContext() {
            return context;
        }

    }

    public static byte[] serialize(byte[] keystore, Map<String, Object> context) {
        byte[] contextBytes = JSONUtil.toJSONString(context).getBytes(StringUtil.UTF8_CHARSET);
        int len = 4 + keystore.length + contextBytes.length;
        byte[] blob = new byte[len];
        int offset = 0;

        System.arraycopy(ByteUtil.fromInt(keystore.length), 0, blob, offset, 4);
        offset += 4;

        System.arraycopy(keystore, 0, blob, offset, keystore.length);
        offset += keystore.length;

        System.arraycopy(contextBytes, 0, blob, offset, contextBytes.length);
        return blob;
    }

    public static ContextAwareKeyStore deserialize(byte[] blob) {
        int offset = 0;
        int keystoreLength = ByteUtil.toInt(blob, offset);
        offset += 4;
        byte[] keystore = Arrays.copyOfRange(blob, offset, offset + keystoreLength);
        offset += keystoreLength;
        String contextAsString = ByteUtil.toString(Arrays.copyOfRange(blob, offset, blob.length));
        Map<String, Object> context = JSONUtil.parseJSONObject(contextAsString);
        return new ContextAwareKeyStore(keystore, context);
    }

}
