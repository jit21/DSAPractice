import java.util.Scanner;

public class Practice4 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while(t-->0){
            int x= sc.nextInt();
            int y= sc.nextInt();
            int n= sc.nextInt();

            int temp = n/x;
            int rem= n % x;
            int ans=0;
            if(rem>=y ){
                ans= temp*x+ y;
            }else {
                ans= (temp-1)*x+y;
            }
            System.out.println(ans);
        }
    }
}
