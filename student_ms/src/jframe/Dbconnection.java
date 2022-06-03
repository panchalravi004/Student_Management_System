/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jframe;
import java.sql.*;
/**
 *
 * @author RAVI PANCHAL
 */
public class Dbconnection {
    static Connection con = null;
    public static Connection getConnection()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver"); 			//call oracle driver before that add it into enviro. --> classpath add new
            con = DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
}
