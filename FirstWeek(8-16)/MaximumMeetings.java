import java.util.*;
class meeting{
    int start;
    int end;
    int pos;
    meeting(int start,int end,int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class mc implements Comparator<meeting>
{
 public int compare(meeting m1,meeting m2)
 {
   if(m1.end < m2.end)
    return -1;
   else if(m1.end > m2.end)
    return 1;
   else if(m1.pos < m2.pos)
    return -1;
   else
    return 1;
 }
}

public class Solution {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {        
        ArrayList<meeting> m = new ArrayList<>();
        for(int i=0;i<start.length;i++)
          m.add(new meeting(start[i],end[i],i+1));
          
        Collections.sort(m,new mc());
        
        ArrayList<Integer> res = new ArrayList<>();
        
        res.add(m.get(0).pos);
        int limit = m.get(0).end;
        
        for(int i=1;i<start.length;i++)
        {
         if(m.get(i).start > limit)
         {
          limit = m.get(i).end;
          res.add(m.get(i).pos);
         }
        }
        
        return res;
    }
}