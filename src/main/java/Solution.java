public class Solution {
    int mod = (int) 1e9 + 7;
    public static int solve(int A) {
        if (A <= 2) {
            return 1;
        }
        int height = (int) (Math.log(A) / Math.log(2));
        int L = 0;
        int nodesExcludingLastLevel = (int)Math.pow(2, height) - 1;
        L = (L + (nodesExcludingLastLevel - 1) / 2);
        int lastLevelNodes = A - nodesExcludingLastLevel;
        int prevLevelNodes = (int)(Math.pow(2, height - 1));
        if (lastLevelNodes >= prevLevelNodes) {
            L = L + prevLevelNodes;
        } else {
            L = L + lastLevelNodes;
        }
        int R = A - 1 - L;
//        int ans = (solve(L) * solve(R) * (comb(A - 1, L) % mod)) % mod;
//        return ans;
        return 1;
    }

    private static int comb(int n, int r) {
        if (n == 0 || r == 0 || n == r) {
            return 1;
        }
        return comb(n - 1, r) + comb(n - 1, r - 1);
    }

    public static void main(String[] args) {
        String s1 = "10";
        String s2 = s1.replace('0', '1');
        System.out.println(s2);
        String str = "abcdefgh";
        String str2 = str.replace('a', '#');
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int idx = sb.indexOf("a");
        sb.replace(1,3, "111111");
        System.out.println(sb);
    }
}
