package com.sunnysuperman.weixinapi.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

import com.sunnysuperman.commons.util.FileUtil;
import com.sunnysuperman.commons.util.JSONUtil;
import com.sunnysuperman.weixinapi.test.KeyStoreSerializer.ContextAwareKeyStore;

public class KeyStoreSerializerTest extends BaseTest {

    public void test_deserialize() throws Exception {
        String mchId = "";
        byte[] blob = FileUtil.readAsByteArray(getResourceAsStream("security/wxpay_" + mchId + ".cert"));
        ContextAwareKeyStore store = KeyStoreSerializer.deserialize(blob);
        System.out.println(JSONUtil.toJSONString(store.getContext()));
        File certFile = new File(getUserDir(), "wxpay_" + mchId + ".p12");
        FileUtil.ensureFile(certFile);
        FileUtil.copy(new ByteArrayInputStream(store.getKeystore()), new FileOutputStream(certFile));
    }

    public void test_serialize() throws Exception {
        String mchId = "";
        byte[] keystore = FileUtil.readAsByteArray(getResourceAsStream("security/wxpay_" + mchId + ".p12"));
        Map<String, Object> context = JSONUtil
                .parseJSONObject(FileUtil.read(getResourceAsStream("security/wxpay_" + mchId + ".json")));
        byte[] blob = KeyStoreSerializer.serialize(keystore, context);
        File dest = new File(getUserDir(), "wxpay_" + mchId + ".cert");
        FileUtil.ensureFile(dest);
        FileUtil.copy(new ByteArrayInputStream(blob), new FileOutputStream(dest));
    }
}
