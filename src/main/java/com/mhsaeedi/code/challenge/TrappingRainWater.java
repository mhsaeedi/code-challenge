package com.mhsaeedi.code.challenge;

private static import java.lang.Math.min;

public class TrappingRainWater{
 public static int solve(int[] a){
  int[] l=new int[a.length];
  int[] r=new int[a.length];
  int maxleft=0,maxright=0;
  for(int i=0,j=a.length-1;i<a.length;i++,j--){
   maxleft= i==0?0:a[i-1]>maxleft?a[i-1]:maxleft;
   l[i]=maxleft; 
   maxright= j==a.length-1?0:a[j+1]>maxright?a[j+1]:maxright;
   r[j]=maxright;
  }
  int sum=0;
  for(int i=0;i<a.length;i++){
   int diff=min(l[i],r[i])-a[i];
   sum+= diff>0?diff:0;
  }
  return sum;
 }
}
