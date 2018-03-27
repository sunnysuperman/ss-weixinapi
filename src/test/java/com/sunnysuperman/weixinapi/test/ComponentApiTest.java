package com.sunnysuperman.weixinapi.test;

// package com.github.sunnysuperman.weixinapi.test;
//
// import java.util.Map;
//
// import com.github.sunnysuperman.commons.utils.FileUtil;
// import com.github.sunnysuperman.weixinapi.component.AuthorizerAccessToken;
// import com.github.sunnysuperman.weixinapi.component.ComponentApi;
// import com.github.sunnysuperman.weixinapi.component.WeixinExpireAwareToken;
// import com.github.sunnysuperman.weixinapi.user.protocol.UserAccessToken;
// import com.github.sunnysuperman.weixinapi.user.protocol.GetUserInfoResponse;
// import com.wakkaa.api.commons.utils.JSONUtils;
// import com.wakkaa.api.commons.utils.URLUtils;
// import com.wakkaa.api.test.TestConfigs;
//
// public class WeixinComponentTest extends TestBase {
// private ComponentApi api;
//
// @Override
// protected void setUp() throws Exception {
// super.setUp();
// api = new ComponentApi(getString("weixin.component.appId"),
// getString("weixin.component.appSecret"),
// getString("weixin.component.appToken"),
// getString("weixin.component.encodingAesKey"));
// }
//
// public void test_getComponentAccessToken() throws Exception {
// String postData =
// FileUtil.read(TestConfigs.class.getResourceAsStream("/test-resources/weixin.xml"));
// Map<String, String> params =
// URLUtils.parseURLParams(getString("weixin.component.ticketparams"));
// String ticket = api.decryptVerifyTicket(postData, params);
// System.out.println("ticket: " + ticket);
// WeixinToken accessToken = api.getComponentAccessToken(ticket);
// System.out.println("accessToken: " + accessToken.getToken());
// System.out.println("expire at: " + accessToken.getExpire());
// }
//
// public void test_createPreAuthCode() throws Exception {
// WeixinToken preAuthCode =
// api.createPreAuthCode(getString("weixin.component.accessToken"));
// System.out.println("preAuthCode: " + preAuthCode.getToken());
// System.out.println("expire at: " + preAuthCode.getExpire());
// }
//
// public void test_getAccessToken() throws Exception {
// AuthorizerAccessToken token =
// api.getAccessToken(getString("weixin.component.accessToken"),
// getString("weixin.component.authCode"));
// System.out.println("authorizer access token: " + token.getAccessToken());
// System.out.println("expire at: " + token.getAccessTokenExpire());
// }
//
// public void test_refreshToken() throws Exception {
// AuthorizerAccessToken token =
// api.refreshToken(getString("weixin.component.accessToken"),
// getString("weixin.component.authorizerAppId"),
// getString("weixin.component.authorizerRefreshToken"));
// System.out.println("authorizer access token: " + token.getAccessToken());
// System.out.println("expire at: " + token.getAccessTokenExpire());
// }
//
// public void test_getAuthorizeRedirectUrl() throws Exception {
// String url =
// api.getAuthorizeRedirectUrl(getString("weixin.component.authorizerAppId"),
// "http://wmh5.congzhitech.com/1/");
// System.out.println(url);
// }
//
// public void test_getUserAccessToken() throws Exception {
// UserAccessToken authInfo =
// api.getUserAccessToken(getString("weixin.component.authorizerAppId"),
// getString("weixin.component.user.code"),
// getString("weixin.component.accessToken"));
// System.out.println(JSONUtils.stringify(authInfo));
// }
//
// public void test_getUserInfo() throws Exception {
// GetUserInfoResponse info = api.getUserInfo("",
// "");
// System.out.println(JSONUtils.stringify(info));
// }
//
// public void test_getOpenState() throws Exception {
// api.getOpenPlatformBindState("",
// getString("weixin.component.authorizerAccessToken"));
// }
//
// public void test_createOpen() throws Exception {
// api.createOpenPlatform("",
// getString("weixin.component.authorizerAccessToken"));
// }
//
// public void test_bindOpen() throws Exception {
// api.bindOpenPlatform("", "",
// getString("weixin.component.authorizerAccessToken"));
// }
//
// public void test_unbindOpen() throws Exception {
// api.unbindOpenPlatform("", "",
// getString("weixin.component.authorizerAccessToken"));
// }
//
// }
