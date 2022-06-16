import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) 
	{
		// Write your code here.
//         int[] arr = new int[permutation.size()];
//         for(int i=0;i<permutation.size();i++)
//         {
//             arr[i] = permutation.get(i);
//         }
        
        int i = permutation.size() - 2;
        
        while(i>=0 && permutation.get(i) > permutation.get(i+1)) i--;
        
        if(i>=0)
        {
            int j = permutation.size() - 1;
            while(permutation.get(j) < permutation.get(i)) j--;
            
            swap(permutation,i,j);
            
        }
        
        reverse(permutation,i+1,permutation.size() - 1);
        
        return permutation;
	}
    
    static void swap(ArrayList<Integer> arr,int i , int j)
    {
        int temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }
    
    static void reverse(ArrayList<Integer> arr, int i, int j)
    {
        while(i<j) swap(arr,i++,j--);
    }
}
