import java.util.*;
public class exp4 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int ans = 0, i=0;
        while(i<32){
            int s = 0, us = 0;
            for(int k: arr){
                if((k&(1<<i))>0) s++;
                else us++;
            }
            ans +=s*us;
            i++;
        }
        System.out.println(ans*2);

    }
}
