package doit.study1_twopointer;

import java.util.Scanner;

public class B1806_rc {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int s = sc.nextInt();
      int[] nums = new int[100001];
      
      for(int i=0; i<n; i++) {
         nums[i] = sc.nextInt();
      }
      
      int start=0, end=0, sum=0, minlen=Integer.MAX_VALUE;
      
      
      while(start <= n && end <=n) {
         if(sum >= s && minlen > end-start) {
            minlen = end-start;
         }
         
         if(sum > s) {
            sum -= nums[start];
            start++;
         }
         else {
            sum += nums[end];
            end++;
         }
      }

      
      if(minlen == Integer.MAX_VALUE) System.out.println("0");
      else System.out.println(minlen);
   }
}