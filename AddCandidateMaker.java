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
public class AddCandidateMaker {
    
     public boolean registerCandidate(String candidatename,String age,String sex,String educationqualification,String worth,String profession,String symbolname,String partyname)
    {

        boolean flag=true;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainvoting","root","root");
            Statement st=conn.createStatement();
// candidatename, age, sex, educationqualification, worth, profession, symbolname, partyname
            String query="Insert into candidateinfo values('"+candidatename+"','"+age+"','"+sex+"','"+educationqualification+"','"+worth+"','"+profession+"','"+symbolname+"','"+partyname+"')";
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
