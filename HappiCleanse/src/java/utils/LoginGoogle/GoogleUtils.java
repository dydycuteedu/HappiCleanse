/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.LoginGoogle;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class GoogleUtils {

    public static String getToken(String code) throws ClientProtocolException, IOException {

        String response = Request.Post(ConstantGoogleLogin.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(
                        Form.form()
                                .add("client_id", ConstantGoogleLogin.GOOGLE_CLIENT_ID)
                                .add("client_secret", ConstantGoogleLogin.GOOGLE_CLIENT_SECRET)
                                .add("redirect_uri", ConstantGoogleLogin.GOOGLE_REDIRECT_URI)
                                .add("code", code)
                                .add("grant_type", ConstantGoogleLogin.GOOGLE_GRANT_TYPE)
                                .build()
                )
                .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);

        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");

        return accessToken;

    }

    public static GooglePojo getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = ConstantGoogleLogin.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();
        GooglePojo googlePojo = new Gson().fromJson(response, GooglePojo.class);
        System.out.println(googlePojo);
        return googlePojo;
    }
}
