/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boothutility;

import blockchainvoting.Datakeeper;
import java.util.ArrayList;
import utility.RandomNumGenerator;

/**
 *
 * @author 2491
 */
public class BoothCreater {
    public boolean initBoothCreater(int n)
    {
        boolean flag =false; 
        try
        {
           ArrayList<Integer> randomlist=new ArrayList<Integer>();
            int count=0;
            RandomNumGenerator r=new RandomNumGenerator();
            while(count!=n)
            {
              int x=  r.getRandomNumber(1, Datakeeper.boothofficername.size());
                if(!randomlist.contains(x))
                {
                    randomlist.add(x);
                  
                    count++;
                }
                
            }
              System.out.println(randomlist);
              System.out.println("size is "+randomlist.size());
              String tablename="booth_info";
              AllBoothInfo ai=new AllBoothInfo();
              for (int i = 0; i < randomlist.size(); i++) 
              {
                  int rn=randomlist.get(i);
                  
                  
                  String name=(String) Datakeeper.boothofficername.get(rn);
//                  System.out.println("vbvbvbvbv");
                  String hashkey=new MD5().MDfive(name);
                  String password=new BoothOfficerPasswordGen().getKey(hashkey);
                  int bn=i+1;
                  String boothnum=Integer.toString(bn);
                  
                 
                  String tn=tablename+"_"+boothnum;
                   new BoothTableCreater().createTable(tn);
                  ai.storeCredentials(boothnum, name, password, tn);
                  
                  
                  
                  
             }
              
              
       
        }
        catch(Exception ex)
                {
                    System.out.println("Exception booth creater "+ex);
                }
        return flag;
    }
    
}
