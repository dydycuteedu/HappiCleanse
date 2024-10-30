/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.VNPay;

import org.json.JSONObject;

/**
 *
 * @author LAPTOP
 */
public class Json {
    public static String getValueOfParamInJsonString(String jsonString, String param) {
        JSONObject jsonObject = new JSONObject(jsonString);
        // Extract the vnp_ResponseCode
        String value = jsonObject.getString(param);

        // Print the response code
        return value;
    }
}
