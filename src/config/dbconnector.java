
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author entac
 */
public class dbconnector {
    
    public Connection connect;
    
    public dbconnector(){
        
        
        
        
            try{
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/rfid", "root", "");
            }catch(SQLException ex){
                    System.out.println("Can't connect to database: "+ex.getMessage());
            }
    }
        
       // retrieve data
        public ResultSet getData(String sql) throws SQLException{
            Statement stmt = connect.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            return rst;
        }

    
    }
    
   
    

