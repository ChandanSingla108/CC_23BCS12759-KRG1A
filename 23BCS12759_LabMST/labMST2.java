import java.util.*;
public class labMST2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] words = new String[n];
        for(int i=0; i<n; i++){
            words[i] = scn.next();
        }
        int ans = 0;
        int[] bits = new int[26];
        for(int i=0; i<n; i++){
            for(char c : words[i].toCharArray()){
                bits[c-'a'] = 1;
            }
            for(int j = i+1; j<n ; j++){
                boolean can = true;
                for(char c : words[j].toCharArray()){
                    if(bits[c-'a'] == 1){
                        can = false;
                        break;
                    }
                }
                if(can){
                    ans = Math.max(ans,words[i].length()*words[j].length());
                }
            }
        }
        System.out.println(ans);
    }
}
