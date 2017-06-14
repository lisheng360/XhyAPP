package xhy.cbd.com.xhyapp.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 作者: lisheng on 2017/6/6.
 * 邮箱:1021337635@qq.com
 */

public class HttpUtil {
    /**
     * 调用不带参数请求
     * @param address
     * @param callback
     */
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }


}
