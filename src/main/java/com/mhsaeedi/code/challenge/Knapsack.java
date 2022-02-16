package com.mhsaeedi.code.challenge;

public class Knapsack {
  public static int solve(int[] w, int[] v, int max) {
    return solve(w,v,max,w.length);
  }
  private static int solve(int[] w, int[] v, int max, int i) {
    if(0==i || 0==max) return 0;
    return max<w[i-1] ? solve(w,v,max,i-1) :
      Math.max(solve(w,v,max,i-1), v[i-1]+solve(w,v,max-w[i-1],i-1));
  }'
}
