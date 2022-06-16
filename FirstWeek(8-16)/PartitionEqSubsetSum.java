class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        
        int k = sum/2;
        
//         int[][] dp = new int[nums.length][k+1];
        
//         for(int i=0;i<nums.length;i++)
//         {
//             for(int j=0;j<=k;j++)
//                 dp[i][j] = -1;
//         }
        
//        if(sum%2 == 0)
//        {
//         boolean[][] dp = new boolean[nums.length][k+1];
        
//         for(int i=0;i<nums.length;i++)
//             dp[i][0] = true;
        
//         if(nums[0] <= k) dp[0][nums[0]] = true;
        
//         for(int i=1;i<nums.length;i++)
//         {
//             for(int j=1;j<=k;j++)
//             {
//                 dp[i][j] = dp[i-1][j];
//                 if(nums[i] <= k)
//                     dp[i][j] = dp[i][j] || dp[i-1][k-nums[i]];
//             }
//         }
        
//         return dp[nums.length-1][k];
//        }
        
        if(sum%2 == 0)
        {
        boolean[] prev = new boolean[k+1];
        
        if(nums[0] <= k) prev[nums[0]] = true;
        prev[0] = true;
        
        for(int i=1;i<nums.length;i++)
        {
            boolean[] curr = new boolean[k+1];
            curr[0] = true;
            for(int j=1;j<=k;j++)
            {
                curr[j] = prev[j];
                if(nums[i] <= j)
                    curr[j] = curr[j] || prev[j-nums[i]];
                
//                 boolean nTake = prev[j];
//                 boolean take = false;
                
//                 if(nums[i] <= j)
//                     take = prev[j-nums[i]];
//                 curr[j] = nTake || take;
            }
            
            prev = curr;
        }
        
        return prev[k];
            
        }
//         if(sum%2 == 0)
//             return (subset(nums,nums.length - 1,k,dp)) == 1 ?true:false ;
        
        return false;
    }
    
    int subset(int[] arr,int ind, int target,int[][] dp)
    {
        if(target == 0) return 1;
        if(ind == 0) return (arr[ind] == target)?1:0;
        
        if(dp[ind][target] !=-1) return dp[ind][target];
        
        int nTake = subset(arr,ind-1,target,dp);
        int take = 0;
        if(arr[ind] <= target)
            take = subset(arr,ind-1,target - arr[ind],dp);
        
        if(nTake == 1 || take == 1)
            return dp[ind][target] = 1;
        else
            return dp[ind][target] = 0;
      
    }
}