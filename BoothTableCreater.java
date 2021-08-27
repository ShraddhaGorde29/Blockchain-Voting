/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boothutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author 2491
 */
public class BoothTableCreater {

    public void createTable(String tablename)
    {
     try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainvoting","root","root");
            Statement st=conn.createStatement();

            String query = "CREATE TABLE `blockchainvoting`.`"+tablename+"` (\n"
                    + "  `boothnumber` VARCHAR(100) NOT NULL DEFAULT '',\n"
                    + "  `serial_no` VARCHAR(100) NOT NULL DEFAULT '',\n"
                    + "  `symbol_name` VARCHAR(100) NOT NULL DEFAULT '',\n"
                    + "  `vote` VARCHAR(100) NOT NULL DEFAULT '',\n"
                    + "  PRIMARY KEY(`serial_no`)\n"
                    + ")\n"
                    + "ENGINE = InnoDB;";
                    
           
            st.executeUpdate(query);

              System.out.println("Table created");
              
                conn.close();
    
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
       
 
    }
    
}
