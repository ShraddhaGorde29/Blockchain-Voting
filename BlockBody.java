
package blockchain;

import boothutility.MD5;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author 2491
 */
public class BlockBody {
    
    
    public String   getbodyHaskey(String btname,String prevkey,String pass)
    {
         String blockedkey="";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainvoting","root","root");
            Statement st=conn.createStatement();

            String query="Select * from "+btname;
            ResultSet rs=st.executeQuery(query);
                String data="";
           while(rs.next())
            {
                
                //boothnumber, serial_no, symbol_name, vote
                String boothnum=rs.getString(1);
                 String serial_no=rs.getString(2);
                  String symbol_name=rs.getString(3); 
                  String vote=rs.getString(4);
                  
                  String row=boothnum+serial_no+symbol_name+vote;
                   data=data+row;   
        
               
            }
           data=data+prevkey+pass;
           String datahashkey=new MD5().MDfive(data);
           blockedkey=new BlockHeadGen().getKey(datahashkey);
           
           
    conn.close();
        }
           
            
        catch(Exception e)
        {
            System.out.println("Exception at ClientDataFetcher"+e);
            
        }
       
      return blockedkey;
    }
        
        
        
        
        
        
        
        
    }
