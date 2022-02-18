package com.mhsaeedi.code.challenge;

public class DutchFlag{
  public static solve(int[] arr){
    int i0=-1;
    int i1=-1;
    int i2=-1.
    for(int i=0;i<arr.length;i++){
      if(arr[i]==0){
        if(i1!=-1 && i1<i) {
          swap(arr,i,i1);
          int temp=i1;
          i1 = i;
          i0 = temp;
        }else if(i2!=-1 && i2<i){
          swap(arr,i,i2);
          int temp=i2;
          i2=i;
          i0=temp;
        }
      }
      else if(arr[i]==1){
        if(i2!=-1 && i2<i){
          swap(arr,i,i2);
          int temp = i2;
          i2 =i1;
          i1 = temp
        }
      }
      
    }
  }

  private static void swap(int[] arr, int i, int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
  }
}
