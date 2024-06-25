
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author entac
 */
public class dbconnector {
    
    public Connection connect;
    
    public dbconnector(){
        
            try{
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/RFID", "root", "");
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

        //Function to save data
        public boolean insertData(String sql){
            try{
                PreparedStatement pst = connect.prepareStatement(sql);
                pst.executeUpdate();
                System.out.println("Inserted Successfully!");
                pst.close();
               return true;
            }catch(SQLException ex){
                System.out.println("Connection Error: "+ex);
               return false;
            }
        }
        
        public void update(String sql, boolean showMessageDialog){
            try{
                PreparedStatement pst = connect.prepareStatement(sql);
                int row = pst.executeUpdate();
                if(row > 0 ){
                    if (showMessageDialog) {
                        System.out.println("Updated");
                        JOptionPane.showMessageDialog(null,"Updated");
                    }
                    else {
                        System.out.println("Updated");
                    }
                }else{
                    System.out.println("Failed");
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
            }
            
        }
        
        //update
        public void update(String sql){
            this.update(sql, true);
        }
        
        //delete
        public void delete(int id, String table, String tblid){
            try{
                PreparedStatement pst = connect.prepareStatement("DELETE FROM "+table+" WHERE "+tblid+" = ? ");
                pst.setInt(1, id);
                int row = pst.executeUpdate();
                if(row > 0 ){
                    JOptionPane.showMessageDialog(null,"Deleted");
                }else{
                    JOptionPane.showMessageDialog(null,"Cant Delete Data");
                }
                
            }catch(SQLException ex){
                
                JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
            }
        }
    
    }


   
    

