// Array with odd sum codeforce question 
import java.util.Scanner;

public class Practice1{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while(t-->0){
            int n= sc.nextInt();
            int arr[]=new int[n];
            int no=0;
            for(int i=0;i<n;i++){
                arr[i]= sc.nextInt();
                if(arr[i]%2==1){
                    no++;
                }

            }
            if(no>0 &&(no%2==1 || n-no>0)){
                System.out.println("YES" );
            }else{
                System.out.println("NO" );
            }
        }
    }
}