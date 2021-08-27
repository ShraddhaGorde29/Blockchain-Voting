/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managecandidate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class EditCandidateMaker {
    public  boolean updateCandidate(String candidatename,String age,String sex,String educationqualification,String worth,String profession,String symbolname,String partyname)
    {
     boolean flag=false;
     
     //candidatename, age, sex, educationqualification, worth, profession, symbolname, partyname
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainvoting","root","root");
            Statement st=conn.createStatement();
           //name, Dob, address, emailid, mobile, subject, class, staffid, password
            String query=" update candidateinfo set age='"+age+"',sex='"+sex+"',educationqualification='"+educationqualification+"',worth='"+worth+"',profession='"+profession+"',symbolname='"+symbolname+"' ,partyname='"+partyname+"' where candidatename='"+candidatename+"'";
           int x=st.executeUpdate(query);
           if(x>0)
               flag=true;
           else
               flag=false;
           
           
           
           
           conn.close();
           
           
        }
        catch(Exception e)
        {
            System.out.println("Exception in Updater"+e);
        flag=false;
        }
       return flag;
    }
    
}
