public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
           int[] prev = new int[maxWeight+1];
       
           for(int i=weight[0];i<=maxWeight;i++) prev[i] = value[0];
        
           for(int i=1;i<n;i++)
           {
              // int[] curr = new int[maxWeight+1];
               for(int j=maxWeight;j>=0;j--)
               {
                   //int nt = prev[j];
                   int t = Integer.MIN_VALUE;
                   
                   if(weight[i]<=j)
                   {
                       t = prev[j-weight[i]] + value[i];
                   }
                   
                   prev[j] = Math.max(prev[j],t);
               }
               
              // prev = curr;
           }
           //return check(weight,value,n-1,maxWeight,dp);
        
           return prev[maxWeight];
    }
}
    
//     static int check(int[] weight,int[] value,int ind,int W,int[][] dp)
//     {
//         if(ind==0)
//         {
//             if(weight[ind] <= W) return value[ind];
//             else return 0;
//         }
  
//         if(dp[ind][W]!=-1) return dp[ind][W];
        
//         int nTake = check(weight,value,ind-1,W,dp);
//         int Take = Integer.MIN_VALUE;
        
//         if(weight[ind]<=W)
//             Take = check(weight,value,ind-1,W-weight[ind],dp) + value[ind];
        
//         return dp[ind][W] = Math.max(nTake,Take);
//     }
// }