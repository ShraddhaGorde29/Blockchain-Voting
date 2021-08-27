/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boothutility;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class ViewMaker {
    
    
    public void getAll()
    {

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/blockchainvoting","root","root");
            Statement st1=(Statement) conn.createStatement();
            Statement st2=(Statement) conn.createStatement();

            String query="Select * from allboothinfo";

            ResultSet rs1=st1.executeQuery(query);
            ResultSet rs2=st2.executeQuery(query);
            int row=0;
            while(rs1.next())
            {
                row++;
            }

            int i=0;

            String[][] data=new String [row][4];
//disease, suggestingmedicine, notsuggestingmedicine, numberrecalls, recallsinbetween, refdoc, refdocspec, servicecost, suggestingprocesdures, notsuggestingprocedure, suggestingdietry, notsuggestingdeitry
            while(rs2.next())
            {
                String boothnum=rs2.getString(1);
                String boothoffnum=rs2.getString(2);
                String offpassword=rs2.getString(3);
                String tablename=rs2.getString(4);
//         
                data[i][0]=boothnum;
                data[i][1]=boothoffnum;
                data[i][2]=offpassword;
                data[i][3]=tablename;
                

                i++;
            }
            ViewBoothFrame.data=data;
            conn.close();
        }
           // int x=st.executeUpdate(query);

        catch(Exception e)
        {
            System.out.println("Exception at DataFetcher"+e);

        }

      //return data;
    }
    
}
