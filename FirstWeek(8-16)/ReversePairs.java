class Solution {
    public int reversePairs(int[] nums) {
        
        return divide(nums,0,nums.length-1);
    }
    
    int divide(int[] nums,int si,int ei)
    {
        int count = 0;
        if(si<ei)
        {
            int mid = (si + ei)/2;
            count = divide(nums,si,mid);
            count += divide(nums,mid+1,ei);
            count +=conquer(nums,si,mid,ei);
        }
        
        return count;
    }
    
    int conquer(int[] arr,int si, int mid, int ei)
    {
        int i;
        int j = mid+1;
        
        int count  =0;
        
        for(i=si;i<=mid;i++)
        {
            while(j<=ei && arr[i] > (2*(long)arr[j]))
                j++;
                
            count = count+j-(mid+1); 
        }
        
        i=si;
        j=mid+1;
        
        int[] temp = new int[ei-si+1];
        
        int k = 0;
        
        while(i<=mid && j<=ei)
        {
            if(arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }
        
        while(i<=mid)
        {
          temp[k++] = arr[i++];
        }
        
        while(j<=ei)
        {
          temp[k++] = arr[j++];
        }
        
        i=si;
        
        for(k=0;k<temp.length;k++)
            arr[i++] = temp[k];
        
        return count;
    }
}