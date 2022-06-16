import java.util.*;
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
//         int[][] dp = new int[n][k+1];
//         //Arrays.fill(dp,-1);
//         for(int i=0;i<n;i++)
//         {
//             for(int j=0;j<=k;j++)
//                 dp[i][j] = -1;
//         }
        //return (subset(arr.length - 1,k,arr,dp)) == 1?true:false;
        
//         boolean[][] dp = new boolean[n][k+1];
//         for(int i=0;i<n;i++)
//         {
//             for(int j=0;j<=k;j++)
//                 dp[i][j] = false;
//         }
        
//         for(int i=0;i<n;i++)
//             dp[i][0] = true;
//         if(arr[0] <= k) dp[0][arr[0]] = true;
        
//         for(int i=1;i<n;i++)
//         {
//             for(int j=1;j<=k;j++)
//             {
//                 dp[i][j] = dp[i-1][j];
//                 if(arr[i] <= j) {
//                     dp[i][j] = dp[i][j] || dp[i-1][j-arr[i]];
//                 }
//             }
//         }
        
       // System.out.println(Arrays.deepToString(dp));
        
        
        boolean[] prev = new boolean[k+1];
        
        prev[0]= true;
        if(arr[0] <= k) prev[arr[0]] = true;
        
        //System.out.println(Arrays.toString(prev));
        //System.out.println(Arrays.toString(curr));
        for(int i=1;i<n;i++)
        {   boolean[] curr = new boolean[k+1];
            curr[0] = true;
            for(int j=1;j<=k;j++)
            {
                boolean nTake = prev[j];
                boolean Take = false;
                if(arr[i]<=j) 
                    Take = prev[j-arr[i]];
                curr[j] = nTake || Take;
            }
            
            prev = curr;
        }
        
        return prev[k];
        
//        return dp[n-1][k];
    }
    
    static int subset(int ind, int target,int[] arr,int[][] dp)
    {
        if(target == 0) return 1;
        if(ind == 0) return (arr[ind] == target)?1:0;
    
        
        if(dp[ind][target]!=-1) return dp[ind][target];
        
        int a = subset(ind-1,target,arr,dp);
        int b = 0;
        if(arr[ind] <= target)
         b = subset(ind-1,target - arr[ind],arr,dp);
        
        if(a == 1 || b == 1) dp[ind][target] = 1;
        else dp[ind][target] = 0;
        
        return dp[ind][target];
        
    }
}
