package stack;

public class StackApply {
    void convert(Stack<Character> stack,int n,int base){
        char digit[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(n>0){
            stack.push(digit[n%base]);
            n/=base;
        }
    }

    boolean paren(char exp[]){
         Stack<Character> s = new Stack<>();
         int len = exp.length;
         for (int i =0;i<len;i++){
             if ('('==exp[i])
                 s.push(exp[i]);
             else if (')'==exp[i]){
                 if (!s.empty())
                     s.pop();
                 else
                     return false;
             }
         }
         return s.empty();
    }
   public static void main(String[] args){
           StackApply stackApply = new StackApply();
           Stack<Character> s =new Stack<>();
           stackApply.convert(s,10,16);
           while (!s.empty()){
               System.out.print(s.pop());
           }
           char digit[] = {'(','1',')','3','+','5','9','7','8','9','A','B','C','D','E','F'};
           System.out.println(stackApply.paren(digit));

           char a [] ={'1','2','3'};
           char b [] ={'1','2','3'};
           System.out.println(stackApply.isDiff(a,b));
    }

    boolean isDiff(char[] a,char[] b){
         int len = a.length;
         Stack<Character> temp=new Stack<>(),aa=new Stack<>();
         Stack<Character> bb = new Stack<>();
         for (int i=0;i<len;i++){
             aa.push(a[i]);
         }
         for (int i=0;i<len;i++){
             if(!aa.empty()&&aa.top()==b[i]) {
                 bb.push(aa.pop());
             }else if (!aa.empty()){
                 temp.push(aa.pop());
             }
         }
         if (!temp.empty())
             bb.push(temp.pop());
         for (int i=len-1;i>-1;i--){
             if (bb.pop()!=b[i])
                 return false;
         }
         return true;


    }
}
