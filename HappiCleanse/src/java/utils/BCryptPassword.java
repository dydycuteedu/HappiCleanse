/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package utils;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptPassword {
    
    public static String hash(String password) {
        String hashPass = BCrypt.hashpw(password, BCrypt.gensalt(12));
        return hashPass;
    }
    
    public static boolean checkP(String password, String hashPass) {
        return BCrypt.checkpw(password, hashPass);
    }
    
}
