public class Practice1 {
    // creating segment tree
    static class ST{
        int seg[];
        public ST(int n){
            seg=new int[4*n];
        }
        public void build(int ind,int arr[],int low,int high){
            if(low==high){
                seg[ind]=arr[low];
                return;
            }
            int mid=(low+high)>>1;
            build(2*ind+1,arr,low,mid);
            build(2*ind+2,arr,mid+1,high);
            seg[ind]=seg[2*ind+1]+seg[2*ind+2];

        }
        public int queries(int ind,int low,int high,int l,int r){
            //no overlap
            if(high<l || r<low) return 0;
            // complete overlap
            if(low>=l && high<=r) return seg[ind];

            //partial overlap
            int mid=(low+high)>>1;
            int left=queries(ind*2+1, low, mid, l, r);
            int right=queries(ind*2+2, mid+1, high, l, r);
            return left+right;

        }
    }
    public static void solve(int arr[],int q[][]){
        int n=arr.length;
        ST s1=new ST(n);
        s1.build(0, arr, 0, n-1);
        int m=q.length;
        for(int i=0;i<m;i++){

            System.out.println("Ans of "+(i+1)+"Query is ->"
            +s1.queries(0, 0, n-1, q[i][0], q[i][1]));
        }


    }
    public static void main(String[] args) {
        
        int arr[]={1,2,3,4,5,6,7};
        int q[][]={
        {2,5},
        {1,4},
        {3,6}
        };
        solve(arr,q);

    }
    
}
