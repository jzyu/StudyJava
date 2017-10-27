package jzyu.com.github.http;

import okhttp3.*;

import java.io.IOException;

/**
 * Author: jzyu
 * Date  : 2017/9/13
 */
public class DemoHttp {

    public static final class Get1 {
        public static void main(String[] args) throws IOException {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://www.baidu.com")
                    .build();
            Response response = client.newCall(request).execute();

            if (! response.isSuccessful()) {
                throw new IOException("server error: " + response);
            }

            Headers headers = response.headers();
            for (int i=0; i < headers.size(); i++) {
                System.out.println(headers.name(i) + ":" + headers.value(i));
            }
            System.out.println(response.body().string());
        }
    }


    public static class Get2 {
        public static void main(String[] args) throws IOException {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://www.baidu.com")
                    .header("User-Agent", "My super agent")
                    .addHeader("Accept", "text/html")
                    .build();

            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("服务器端错误: " + response);
            }

            System.out.println(response.header("Server"));
            System.out.println(response.headers("Set-Cookie"));
        }
    }

    public static class Post1 {
        public static void main(String[] args) throws IOException {
            OkHttpClient client = new OkHttpClient();
            MediaType MEDIA_TYPE_TEXT = MediaType.parse("text/plain");
            String postBody = "Hello World";

            Request request = new Request.Builder()
                    .url("http://www.baidu.com")
                    .post(RequestBody.create(MEDIA_TYPE_TEXT, postBody))
                    .build();

            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("服务器端错误: " + response);
            }

            System.out.println(response.body().string());
        }
    }
}
