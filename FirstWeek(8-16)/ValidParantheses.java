class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++)
        {
            Character ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{')
                st.push(ch);
            else
            {
                if(st.isEmpty()) return false;
                else
                {
                    Character c = st.pop();
                    if(!check(c,ch))
                        return false;
                }
            }
        }
        
        if(st.isEmpty())
            return true;
        else
            return false;
        
    }
    
    boolean check(Character a , Character b)
    {
        if(a == '(' && b == ')' ||
           a == '{' && b == '}' ||
           a == '[' && b == ']')
        return true;
        else
            return false;
    }
}