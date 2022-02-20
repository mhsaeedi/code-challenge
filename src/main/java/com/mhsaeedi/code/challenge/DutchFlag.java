package com.mhsaeedi.code.challenge;

public class DutchFlag{

  public static void main(String[] args){
    int[] arr = new int[]{0,2,1,1,2,0,
    0,1,2,1,0,2};
    solve(arr);
    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i]);
    }
  }

  public static void solve(int[] a){
    int i=0,j=0,k=a.length-1;
    while(j<=k)
      if(a[j]==0)swap(a,i++,j++);
      else if(a[j]==2)swap(a,j,k--);
      elss j++;
  }

  private static void swap(int[] a, int i, int j){
    int t=a[i];
    a[i]=a[j];
    a[j]=t;
  }
}
