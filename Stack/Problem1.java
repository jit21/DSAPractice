import java.util.Scanner;
import java.util.Stack;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String input= sc.nextLine();
        int n= input.length();
        Stack<Character> st= new Stack<>();
        for(int i=0;i<n;i++){
            char ch= input.charAt(i);
            if(!st.isEmpty()){
                if(st.peek()==ch){
                    st.pop();
                }else{
                    st.push(ch);
                }
                }else{
                st.push(ch);
            }
            }
            if(st.isEmpty()){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }

    }
    

