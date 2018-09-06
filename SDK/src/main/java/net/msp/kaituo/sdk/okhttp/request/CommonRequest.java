package net.msp.kaituo.sdk.okhttp.request;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;

/**
 * Business
 *
 * @author kaituo:马世鹏
 * @create 2018/9/6 11:03
 * @function 接收请求参数，为我们生成Request对象
 **/
public class CommonRequest {

    /**
     *
     * @param url
     * @param params
     * @return 返回一个创建好的Request对象
     */
    public static Request createPostRequest(String url,RequestParams params){

        FormBody.Builder mFromBodyBuild = new FormBody.Builder();
        if (params != null) {
            for (Map.Entry<String,String> entry : params.urlParams.entrySet()){
                //将请求参数遍历添加到我们的请求构件类中
                mFromBodyBuild.add(entry.getKey(),entry.getValue());
            }
        }
        //通过请求构件类的build方法获取到真正的请求体对象
        FormBody mFormBody = mFromBodyBuild.build();

        return new Request.Builder().url(url).post(mFormBody).build();
    }
}
