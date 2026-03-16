import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] v = new String[n];

        for (int i = 0; i < n; i++) {
            v[i] = sc.next();
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indeg = new int[26];

        for (int i = 0; i < n - 1; i++) {
            String a = v[i];
            String b = v[i + 1];

            int len = Math.min(a.length(), b.length());
            boolean found = false;

            for (int j = 0; j < len; j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    int u = a.charAt(j) - 'a';
                    int v2 = b.charAt(j) - 'a';

                    adj.get(u).add(v2);
                    indeg[v2]++;
                    found = true;
                    break;
                }
            }

            if (!found && a.length() > b.length()) {
                System.out.println("Impossible");
                return;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 26; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.append((char) ('a' + node));

            for (int it : adj.get(node)) {
                indeg[it]--;
                if (indeg[it] == 0) {
                    q.add(it);
                }
            }
        }

        if (ans.length() != 26) {
            System.out.println("Impossible");
            return;
        }

        System.out.println(ans.toString());
    }
}
