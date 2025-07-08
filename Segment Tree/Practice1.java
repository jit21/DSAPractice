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
        // updating a index in arry so it also effect on our segment tree but we are using O(logn) to update our segment tree

        public void update(int ind,int low,int high,int i,int val){
            if(low==high) {
                seg[ind]=val;
                return;
            }
            int mid=(low+high)>>1;
            if(i> mid){
                update(2*ind+2,mid+1,high,i,val);
            }else{
                update(2*ind+1, low, mid, i, val);
            }
            seg[ind]=seg[ind*2+1]+seg[2*ind+2];

        }
    }
    public static void solve(int arr[],int q[][]){
        int n=arr.length;
        ST s1=new ST(n);
        s1.build(0, arr, 0, n-1);
        int m=q.length;
        System.out.println("Before updating");
        for(int i=0;i<m;i++){

            System.out.println("Ans of "+(i+1)+"Query is ->"
            +s1.queries(0, 0, n-1, q[i][0], q[i][1]));
        }
        System.out.println("After updating ");
        s1.update(0, 0, n-1, 3, 10);
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
