package com.mhsaeedi.code.challenge;

import static java.lang.Math.abs;

public class NumberReversion{
  public static int reverse(int num){
    if(num<10 && num>-10) return num;
    int n = abs(num);
    int res=0;
    //10
    while(n>0){
      int r = n%10;
      n = n/10;
      res = (res + r) * (n==0?1:10);//0,1
    }
    return res;
  }
}

