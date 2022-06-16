import java.util.ArrayList;
import java.util.*;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
        int[] temp = new int[n+1];
        int m = 0;
        int r = 0;
        Arrays.fill(temp,0);
        
        for(int i=0;i<n;i++)
        {
            temp[arr.get(i)]++;
        }
        
       
        for(int i=1;i<temp.length;i++)
        {
            if(temp[i] == 0)
                m = i;
            if(temp[i] > 1)
                r = i;
        }
        
        return new int[]{m,r};
    }
}