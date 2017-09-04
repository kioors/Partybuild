package com.kingyon.partybuild.support.util;

import com.kingyon.partybuild.config.Props;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * describe: 云之讯工具类
 *
 * @author <a href="sam@kingyon.com">Yang Xiang</a>
 * 2017/8/25 上午 11:12:23
 * @since 0.1.0
 */
public class SmsUtils {

    private static final String API_HOST = "api.ucpaas.com";

    private static final String API_SCHEMA = "https";

    private static final int API_PORT = 443;

    private static final String ACCOUNT_ID;

    private static final String APP_ID;

    /**
     * 重置密码验证码
     */
    public static final String FORGET_PASSWORD_TEPLATE_ID = "66766";

    private static final String ACCOUNT_TOKEN;

    private static final Log log = LogFactory.getLog(SmsUtils.class);

    static {
        ACCOUNT_ID = Props.getString("application.yunzhixun.sms.account.id",
                "e2a75d05a3e4e66e55a4afe74ae49db9");
        ACCOUNT_TOKEN = Props.getString(
                "application.yunzhixun.sms.account.token",
                "3103f31af35b18134263fd38e2ce2c26");
        APP_ID = Props.getString("application.yunzhixun.sms.account.appid",
                "02ea67ab7ed04179a4d260caba5e23bd");
    }

    private static String getSign(long time) {

        String timestamp = DateFormatUtils.format(time, "yyyyMMddHHmmss");

        String md5Sign = DigestUtils.md5Hex(
                ACCOUNT_ID + ACCOUNT_TOKEN + timestamp).toUpperCase();

        return md5Sign;
    }

    private static String getAuthorization(long time) {
        String timestamp = DateFormatUtils.format(time, "yyyyMMddHHmmss");
        String str = ACCOUNT_ID + ":" + timestamp;
        return Base64
                .encodeBase64String(str.getBytes(Charset.forName("UTF-8")));
    }

    public static CloseableHttpClient createHttpClient() {
        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder
                .<ConnectionSocketFactory>create();
        ConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();
        registryBuilder.register("http", plainSF);
        // 指定信任密钥存储对象和连接套接字工厂
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore
                    .getDefaultType());
            // 信任任何链接
            TrustStrategy anyTrustStrategy = new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates,
                                         String s) throws CertificateException {
                    return true;
                }
            };
            SSLContext sslContext = SSLContexts.custom()
                    .loadTrustMaterial(trustStore, anyTrustStrategy).build();
            LayeredConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(
                    sslContext,
                    SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            registryBuilder.register("https", sslSF);
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        Registry<ConnectionSocketFactory> registry = registryBuilder.build();
        // 设置连接管理器
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(
                registry);
        // connManager.setDefaultConnectionConfig(connConfig);
        // connManager.setDefaultSocketConfig(socketConfig);
        // 构建客户端
        return HttpClientBuilder.create().setConnectionManager(connManager)
                .build();
    }

    public static void sendMessage(String template, String mobile, String... parames) {

        send(template, mobile, Arrays.asList(parames));
    }

    public static void send(String templateId, String mobile,
                            List<String> params) {

        CloseableHttpClient httpClient = createHttpClient();

        HttpHost target = new HttpHost(API_HOST, API_PORT, API_SCHEMA);

        long now = System.currentTimeMillis();
        StringBuilder urlBuilder = new StringBuilder("/2014-06-30/Accounts/");
        urlBuilder.append(ACCOUNT_ID).append("/Messages/templateSMS");
        urlBuilder.append("?sig=").append(getSign(now));
        HttpPost post = new HttpPost(urlBuilder.toString());

        post.addHeader("Authorization", getAuthorization(now));
        post.addHeader("Content-Type", "application/json;charset=utf-8");
        post.addHeader("Accept", "application/json");
        BasicHttpEntity requestBody = new BasicHttpEntity();
        Request request = new Request();
        request.setAppId(APP_ID);
        request.setTemplateId(templateId);
        request.setTo(mobile);
        StringBuilder paramString = new StringBuilder();

        if (params != null) {

            for (int i = 0; i < params.size(); i++) {

                paramString.append(params.get(i));
                if (i < params.size() - 1) {
                    paramString.append(",");
                }
            }
        }
        request.setParam(paramString.toString());
        String requestString = request.toRequestString();
        byte[] buf = requestString.getBytes(Charset.forName("UTF-8"));
        ByteArrayInputStream instream = new ByteArrayInputStream(buf);
        requestBody.setContent(instream);
        requestBody.setContentLength(buf.length);
        post.setEntity(requestBody);
        try {
            CloseableHttpResponse response = httpClient.execute(target, post);

            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                HttpEntity responseEntity = response.getEntity();
                String str = EntityUtils.toString(responseEntity, "UTF-8");
                Response resp = Response.parse(str);
                EntityUtils.consume(responseEntity);
                if (!"000000".equals(resp.getRespCode())) {
                    log.error("短信发送失败，短信返回碼：" + resp.getRespCode());
                }
            } else {
                log.error("请求失败，响应吗："
                        + response.getStatusLine().getStatusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static class Request {

        private String appId;

        private String param;

        private String templateId;

        private String to;

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public String getTemplateId() {
            return templateId;
        }

        public void setTemplateId(String templateId) {
            this.templateId = templateId;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String toRequestString() {

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("templateSMS", this);
            return JSONUtil.getJSON(map);
        }

    }

    private static class ResponseWrappr {
        private Response resp;

        public Response getResp() {
            return resp;
        }

        public void setResp(Response resp) {
            this.resp = resp;
        }

    }

    private static class Response {

        private String respCode;

        private Integer failure;

        private TemplateSMS templateSMS;

        public String getRespCode() {
            return respCode;
        }

        public void setRespCode(String respCode) {
            this.respCode = respCode;
        }

        public Integer getFailure() {
            return failure;
        }

        public void setFailure(Integer failure) {
            this.failure = failure;
        }

        public TemplateSMS getTemplateSMS() {
            return templateSMS;
        }

        public void setTemplateSMS(TemplateSMS templateSMS) {
            this.templateSMS = templateSMS;
        }

        public static Response parse(String str) throws Exception {

            ResponseWrappr wrapper = JSONUtil.parseJson(str,
                    ResponseWrappr.class);
            return wrapper.getResp();

        }

    }

    private static class TemplateSMS {
        private long createDate;
        private String smsId;

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public String getSmsId() {
            return smsId;
        }

        public void setSmsId(String smsId) {
            this.smsId = smsId;
        }

    }

    public static void main(String[] args) {

        send(FORGET_PASSWORD_TEPLATE_ID, "13981927244", Arrays.asList("512345"));
    }
}
