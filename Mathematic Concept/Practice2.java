import java.util.Scanner;

class Practice2{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while (t>0) {
            int x= sc.nextInt();
            int y= sc.nextInt();
            int z= sc.nextInt();

            int max= Math.max(x, Math.max(y, z));
            int count=0;
            if(max==x){
              count++;
            }
            if(max==y){
                count++;
            }
            if(max==z){
                count++;
            }
            if(count<2){
                System.out.println("NO");
            }else{
                System.out.println("YES");
                int a= Math.min(x,Math.min(y,z));
                int b= x;
                int c= max;
                System.out.println(a+" "+b+" "+c);
            }
            t--;

            
        }
    }

}