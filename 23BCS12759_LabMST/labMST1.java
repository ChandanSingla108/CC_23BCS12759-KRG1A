import java.util.*;
class labMST1{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] tasks = new int[n][2];
        for(int i=0; i<n; i++){
            tasks[i][0] = scn.nextInt();
            tasks[i][1] = scn.nextInt();
        }
        Arrays.sort(tasks,(a,b)->Integer.compare(b[1],a[1]));
        int lo = tasks[0][1];
        int hi = 0;
        for(int i=0; i<n; i++){
            hi+=tasks[i][1];
        }
        int ans = 0;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(isPossible(tasks,mid)){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        System.out.println(ans);
    }
    static boolean isPossible(int[][] tasks, int energy){
        for(int i=0; i<tasks.length; i++){
           if(energy >= tasks[i][1]){
               energy-=tasks[i][0];
           } else{
               return false;
           }
        }
        return true;
    }
}