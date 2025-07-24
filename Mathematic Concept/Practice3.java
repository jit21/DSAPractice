import java.util.Scanner;

public class Practice3 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while (t-->0) {
            int n= sc.nextInt();
            int m= sc.nextInt();
            
            int totalBlocks= n*m;
            if(totalBlocks % 2 == 1){
                totalBlocks++;
            }

            System.out.println(totalBlocks / 2);
        }
    }
}
