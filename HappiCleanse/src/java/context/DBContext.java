/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package context;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBContext {
    
     private static String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String username = "sa";
    private static String password = "thienbao";
    private static String jdbcURL = "jdbc:sqlserver://DESKTOP-V2LFEJ4;databaseName=HappiCleanse;encrypt=true;trustServerCertificate=true;loginTimeout=30";
    
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName(driverClass);
            con = (Connection) DriverManager.getConnection(jdbcURL, username, password);
        } catch (Exception e){
            System.out.println("Error: " + e);
        }
        return con;
    }
}
