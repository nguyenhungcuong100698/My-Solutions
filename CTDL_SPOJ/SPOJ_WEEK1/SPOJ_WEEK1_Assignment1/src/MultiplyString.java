/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TOSHIBA
 */
public class MultiplyString {
    private int numOfTime;
    private String str;
    public MultiplyString(){        //set starting values
        numOfTime=0;
        str=" ";
    }
    public MultiplyString(int time,String str){     //set defined values
    numOfTime = time;
    this.str = str;
}
    public StringBuilder appendString(){                //this method takes in a string
        StringBuilder myStr = new StringBuilder();      //and multiplies every char of it
       for (int i=0;i<str.length();i++)                 // and returns a multiplied string
           for (int j=0;j<numOfTime;j++){               // which is StringBuilder type
                myStr.append(str.charAt(i));
           }
       return myStr;
    }
}
