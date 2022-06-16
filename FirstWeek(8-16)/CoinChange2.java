class Solution {
    public int change(int amount, int[] coins) {
    
        int n = coins.length;
        int[] prev = new int[amount+1];
        
        for(int i=0;i<=amount;i++) prev[i] = (i%coins[0]==0?1:0);
        
        for(int i=1;i<n;i++)
        {
            int[] curr = new int[amount+1];
            for(int j=0;j<=amount;j++)
            {
                int nt = prev[j];
                int t = 0;
                if(coins[i] <= j)
                    t = curr[j-coins[i]];
                
                curr[j] = nt + t;
            }
            
            prev = curr;
        }
        //return coinsC(amount,n-1,coins,dp);
        return prev[amount];
        
    }
    
//     public int coinsC(int amount, int ind, int[] coins,int[][] dp)
//     {
       
//         if(ind == 0)
//         {
//             return ((amount%coins[0]) == 0? 1 : 0);
//         }
        
//         if(dp[ind][amount] !=-1) return dp[ind][amount];
        
//         int nTake = coinsC(amount,ind -1,coins,dp);
//         int take = 0;
        
//         if(coins[ind] <= amount)
//             take = coinsC(amount-coins[ind],ind,coins,dp);
            
//         return dp[ind][amount] = take + nTake;
       
//     }
    
}