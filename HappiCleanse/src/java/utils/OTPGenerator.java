/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Random;


public class OTPGenerator {

    public static String generateNumericOTP(int length) {
        // Create a random number generator
        Random random = new Random();

        // Create a StringBuilder to store the OTP
        StringBuilder otp = new StringBuilder();

        // Generate the OTP
        for (int i = 0; i < length; i++) {
            // Generate a random digit between 0 and 9
            otp.append(random.nextInt(10));
        }

        return otp.toString();
    }
}
