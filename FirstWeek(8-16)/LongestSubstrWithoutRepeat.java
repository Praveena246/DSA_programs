class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        int i=0;
        int len = 0;
        
        for(int j=0;j<s.length();j++)
        {
            if(hm.containsKey(s.charAt(j)))
            {
                i = Math.max(i,hm.get(s.charAt(j)) + 1);
            }
            hm.put(s.charAt(j),j);
            len = Math.max(len,j-i+1);
        }
        
        return len;
        
    }
}