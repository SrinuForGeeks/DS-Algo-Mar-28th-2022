class MinRemoveToMakeValid {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        int openBraceCount = 0;
        int openBraceSeenCount = 0;
        
        // Eliminate Invalid Closed Braces
        for(int index = 0 ; index < s.length() ; index++)
        {
            char ch = s.charAt(index);
            
            if(ch == '(')
            {
                openBraceCount++;
                openBraceSeenCount++;
                sb.append(ch);
            }
           else  if(ch == ')')
            {
                if(openBraceCount > 0)
                {
                    openBraceCount --;
                    sb.append(ch);   
                }
                
            }else 
            {
                sb.append(ch);
            }
        }
        
        
        //  Eliminate Invalid Open Braces
        
        int validOpenBraces = openBraceSeenCount - openBraceCount;
        
        if(validOpenBraces == openBraceSeenCount)
        {
            return sb.toString();
        }
        
        StringBuffer sbRes = new StringBuffer();
        
         for(int index = 0 ; index < sb.length() ; index++)
        {
              char ch = sb.charAt(index);
             
             if(ch == '('  )
             {
                 if(validOpenBraces > 0)
                 {
                    validOpenBraces--;
                    sbRes.append(ch); 
                 }
                 
             }else
             {
                 sbRes.append(ch); 
             }
            
        }
        
        return sbRes.toString();
    }

    public static void main(String[] args) {
        MinRemoveToMakeValid s = new MinRemoveToMakeValid();
        String result = s.solution("lee(t(c)o)de)");

        System.out.println("lee(t(c)o)de) ----> "+result);

    }
}