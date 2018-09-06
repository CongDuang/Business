package net.msp.kaituo.sdk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Business
 *
 * @author kaituo:马世鹏
 * @create 2018/9/6 10:28
 * @since
 **/
public class BaseOkhttpTest extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void sendRequest (){
        OkHttpClient mOkHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url("http://www.baidu.com/")
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            //请求失败
            @Override
            public void onFailure(Call call, IOException e) {

            }
            //请求成功
            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });

    }


}
