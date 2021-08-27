/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockchain;

import java.util.ArrayList;

/**
 *
 * @author 2491
 */
public class BoothSorter {
    
    public ArrayList getSortedBooth(ArrayList boothtables)
    {
       
        
        for (int i = 0; i <boothtables.size()-1; i++) 
        {
            for (int j = i+1; j < boothtables.size(); j++)
            {
                 String bt1=(String) boothtables.get(i);
                 String x[]=bt1.split("_");
                 String num1=x[2];
                 int a=Integer.parseInt(num1);
                
                String bt2=(String) boothtables.get(j);
                 String y[]=bt2.split("_");
                 String num2=y[2];
                 int b=Integer.parseInt(num2);
              
                 if(a>b)
                 {
                     boothtables.set(i,bt2);
                     boothtables.set(j,bt1);
                 }
            }
        
         
         
         
        }
        
        
        
        
        
        
        
        return boothtables;
    }
    
}
