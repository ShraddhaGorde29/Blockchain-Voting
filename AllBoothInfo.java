/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boothutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author 2491
 */
public class AllBoothInfo {
    
    public boolean storeCredentials(String boothnum ,String boothofficer, String password,String tablename)
    {
//sid, sname, subj, exper, age, sr, assitime, comtime
        boolean flag=true;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainvoting","root","root");
            Statement st=conn.createStatement();

            String query="Insert into allboothinfo values('"+boothnum+"','"+boothofficer+"','"+password+"','"+tablename+"')";
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;


                conn.close();
            }
        catch(Exception ex)
        {
            System.out.println("exception in inserter "+ex);
            flag=false;
        }

        return flag;
    }
    
    
}
