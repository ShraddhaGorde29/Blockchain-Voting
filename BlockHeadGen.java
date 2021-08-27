/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockchain;

import boothutility.*;
import java.util.ArrayList;

public class BlockHeadGen
{


    String key = "";

    public String getKey(String textLine)
    {

       
       
        
        textLine = textLine.replaceAll(" ", "");
        //textLine = textLine.replaceAll(" ", ".");



        // System.out.println(textLine);
        char charRandom[] = textLine.toCharArray();
        int ranchar = (textLine.length()) % 8;
        if (ranchar == 0)
        {
            for (int i = 0; key.length() < 8; i++) {
                i = i + 1;
                if (i < textLine.length())
                {
                    key = key + charRandom[i];
                    charRandom=rotate(charRandom);

                }
                else
                {
                    i = 0;
                }

            }
        }
         if (ranchar == 1)
         {
            for (int i = 0; key.length() < 8; i++) {
                i = i + 2;
                if (i < textLine.length())
                	{
                    key = key + charRandom[i];
                     charRandom=rotate(charRandom);
                }
                 else
                	{
                    i = 0;
                }

            }
        }
         if (ranchar == 2) {
            for (int i = 0; key.length() < 8; i++) {
                i = i + 3;
                if (i < textLine.length()) {
                    key = key + charRandom[i];
                     charRandom=rotate(charRandom);
                } else {
                    i = 0;
                }

            }
        }
         if (ranchar == 3) {
            for (int i = 0; key.length() < 8; i++) {
                i = i + 4;
                if (i < textLine.length()) {

                    key = key + charRandom[i];
                     charRandom=rotate(charRandom);
                } else {
                    i = 0;
                }

            }
        }
         if (ranchar == 4) {
            for (int i = 0; key.length() < 8; i++) {
                i = i + 5;
                if (i < textLine.length()) {
                    key = key + charRandom[i];
                     charRandom=rotate(charRandom);
                } else {
                    i = 0;
                }

            }
        }
         if (ranchar == 5) {
            for (int i = 0; key.length() < 8; i++) {
                i = i + 6;
                if (i < textLine.length()) {
                    key = key + charRandom[i];
                     charRandom=rotate(charRandom);
                } else {
                    i = 0;
                }

            }
        }
         if (ranchar == 6) {
            for (int i = 0; key.length() < 8; i++) {
                i = i +7;
                if (i < textLine.length()) {
                    key = key + charRandom[i];
                     charRandom=rotate(charRandom);
                } else {
                    i = 0;
                }

            }
        }
         
          if (ranchar == 7) {
            for (int i = 0; key.length() < 8; i++) {
                i = i +7;
                if (i < textLine.length()) {
                    key = key + charRandom[i];
                     charRandom=rotate(charRandom);
                } else {
                    i = 0;
                }

            }
        }

          key=key.toUpperCase();
        return (key);

    }
 /*    public static void main(String[] args)

     {
        // TODO code application logic here
      RandomChar rc= new RandomChar();
        System.out.println(rc.key);
    }*/

public char[] rotate(char Array[])
{
       char temp;

            temp=Array[Array.length-1];
            Array[Array.length-1]=Array[0];
                for(int i=0;i<Array.length-1;i++)
                {
                 Array[i]=Array[i+1];


             }
           Array[Array.length-2]=temp;
    return Array;
}

}
