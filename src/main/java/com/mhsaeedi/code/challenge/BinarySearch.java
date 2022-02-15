package com.mhsaeedi.code.challenge;

public class BinarySearch{
    public static int search(long[] arr, long n){
        int l = 0;
        int r = arr.length - 1;       
        while(l<=r){
          int m = (l + r) / 2;
          if(arr[m]==n) return m;
          else if(arr[m]<n) l = m + 1;
          else r = m - 1;
        }
        return -1;
    }

}
