package stacks;

import java.util.Stack;

public class BalancedParenthesis {
    static boolean isBalanced(String s)
    {
        Stack<Character> st = new Stack<Character>();
        for (char c : s.toCharArray())
        {
            if (c == '(' || c == '[' || c == '{')
            {
                st.push(c);
            }
            else
            {
                if (st.empty())
                {
                    return false;
                }
                else if (c == ')' && st.peek() != '(')
                {
                    return false;
                }
                else if (c == ']' && st.peek() != '[')
                {
                    return false;
                }
                else if (c == '}' && st.peek() != '{')
                {
                    return false;
                }
                else
                {
                    st.pop();
                }
            }
        }
        return st.empty();
    }
}
