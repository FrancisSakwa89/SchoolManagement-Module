package com.systechInterns.config;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("ALL")
public class Util {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public String findStudentByRegNo(String regNo){
        Map<String, String > map = new HashMap();
        map.put("registrationNo", regNo);
        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = RequestBody.create(JSON,new Gson().toJson(map));
        Request request = new Request.Builder()
                    .url("http://localhost/8888/sm/api/students/find-by-reg-no")
                    .post(requestBody).build();

        try{
            Response response = client.newCall(request).execute();
            return  response.body().string();
        }catch (IOException e) {
            e.printStackTrace();
        return null;
    }

    }

    public String getStudentById(String postData, String url){

        try {
            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody = RequestBody.create(JSON, postData);
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody).build();

            Response response = client.newCall(request).execute();
            return  response.body().toString();
        }catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
