class Solution {
    public int coinChange(int[] arr, int amount) {
        
        int n = arr.length;
        int[] prev = new int[amount+1];
        
        for(int i=0;i<=amount;i++) 
        {
            if(i%arr[0] == 0)
                prev[i] = i/arr[0];
            else
                prev[i] = (int)Math.pow(10,9);
        }
    
        for(int i=1;i<n;i++)
        {
            int[] curr = new int[amount+1];
            for(int j=0;j<=amount;j++)
            {
                 int nTake = prev[j];
                
                 int take = (int)Math.pow(10,9);
        
         if(arr[i] <= j)
            take = curr[j-arr[i]] + 1;
        
          curr[j] = Math.min(take,nTake);
            }
            prev = curr;
        }
        
       // int ans = change(n - 1,amount,coins,dp) ;
        int ans = prev[amount];
        if(ans < (int)Math.pow(10,9))
           return ans;
        else 
           return -1;
    }
    
//     int change(int ind, int target,int[] arr,int[][] dp)
//     {
//         if(ind == 0)
//         {
//             if(target%arr[0] == 0) return target/arr[0];
//             else return (int)Math.pow(10,9);
//         }
        
//         if(dp[ind][target] != -1) return dp[ind][target];
        
//         int nTake = change(ind -1,target,arr,dp);
//         int take = (int)Math.pow(10,9);
        
//         if(arr[ind] <= target)
//             take = change(ind,target-arr[ind],arr,dp) + 1;
        
//         return dp[ind][target] = Math.min(take,nTake);
//     }
}