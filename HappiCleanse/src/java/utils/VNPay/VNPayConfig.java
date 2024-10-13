/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package utils.VNPay;


import java.io.IOException;
import java.util.Map;

/**
 *
 * @author CTT VNPAY
 */
import java.net.URLEncoder;
import java.util.Set;
import java.util.TreeMap;


public class VNPayConfig {
    public static String generatePaymentUrl(Map<String, String> vnp_Params, String vnp_HashSecret) throws IOException {
        // Sort parameters by key
        Map<String, String> sortedParams = new TreeMap<>(vnp_Params);
        Set<String> keys = sortedParams.keySet();
        
        // Create the query string and append the signature
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        for (String key : keys) {
            String value = sortedParams.get(key);
            if (query.length() > 0) {
                query.append('&');
                hashData.append('&');
            }
            query.append(URLEncoder.encode(key, "UTF-8")).append('=').append(URLEncoder.encode(value, "UTF-8"));
            hashData.append(key).append('=').append(value);
        }

        // Generate secure hash
        String secureHash = VNPayService.hmacSHA512(vnp_HashSecret, hashData.toString());
        query.append("&vnp_SecureHash=").append(secureHash);
        
        // Payment URL
        return "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html?" + query.toString();
    }

    public static boolean verifyResponse(Map<String, String> vnp_Params, String vnp_SecureHash, String vnp_HashSecret) {
        Map<String, String> sortedParams = new TreeMap<>(vnp_Params);
        StringBuilder hashData = new StringBuilder();
        for (Map.Entry<String, String> entry : sortedParams.entrySet()) {
            if (hashData.length() > 0) {
                hashData.append('&');
            }
            hashData.append(entry.getKey()).append('=').append(entry.getValue());
        }

        String computedHash = VNPayService.hmacSHA512(vnp_HashSecret, hashData.toString());
        return computedHash.equals(vnp_SecureHash);
    }
}