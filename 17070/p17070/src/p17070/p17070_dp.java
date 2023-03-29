package p17070;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class p17070_dp {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[][] grid;
    static int[][][] dp;
    static int n;

    public static void main(String[] args) throws NumberFormatException, IOException {
        n = Integer.parseInt(br.readLine());

        grid = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][2][0] = 1;
        // 0:=가로 1:=대각 2:=세로
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                    dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][1];
                    dp[i][j][1] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                    dp[i][j][2] += dp[i - 1][j][1] + dp[i - 1][j][2];
        
            }
        }

        int ans = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
        System.out.println(ans);
    }

}