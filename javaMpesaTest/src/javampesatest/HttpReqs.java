/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javampesatest;

/**
 *
 * @author DEVWK008
 */
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author DEVWK008
 */
public class HttpReqs {
    public JSONObject getResponse(String get_uri, String header1, String header2) throws IOException, JSONException{
        OkHttpClient requestClient = new OkHttpClient();
        Request gRequest = new Request.Builder()
                .url(get_uri)
                .get()
                .addHeader("authorization", header1)
                .addHeader("cache-control", header2)
                .build();
        Response g_response = requestClient.newCall(gRequest).execute();
        JSONObject responseObj = new JSONObject(g_response.body().string());
        return responseObj;
    }
    
    public JSONObject postResponse(String post_uri, String header1, String header2, String pRequest) throws IOException, JSONException{
        MediaType mtype = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(mtype, pRequest);
        OkHttpClient requestClient =  new OkHttpClient();
        Request post_request = new Request.Builder().url(post_uri).post(requestBody).addHeader("Authorization", header1).addHeader("Content-Type", header2).build();
        Response p_response = requestClient.newCall(post_request).execute();
        JSONObject responseObj = new JSONObject(p_response.body().string());
        return responseObj;
    }
    
}
