package net.msp.kaituo.sdk.okhttp;

import net.msp.kaituo.sdk.okhttp.https.HttpsUtils;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Business
 *
 * @author kaituo:马世鹏
 * @create 2018/9/6 11:03
 * @function 请求的发送，请求参数的配置，https支持。
 **/
public class CommonOkhttpClient {

    private static final int TIME_OUT = 30;
    private static OkHttpClient mOkhttpClient;

    //为我们的client配置参数

    static {

        //创建我们client对象的构建者
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        //是为构建者填充超时时间
        okHttpBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);

        okHttpBuilder.followRedirects(true);

        //http支持
        okHttpBuilder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
        okHttpBuilder.sslSocketFactory(HttpsUtils.initSSLSocketFactory(),
                HttpsUtils.initTrustManager());

        //生成我们的client对象
        mOkhttpClient = okHttpBuilder.build();
    }

    /**
     * 发送具体的Http/https请求
     * @param request
     * @param commCallback
     * @return Call
     */
    public static Call sendRequest (Request request, Callback commCallback){
        Call call = mOkhttpClient.newCall(request);
        call.enqueue(commCallback);

        return call;
    }
}
