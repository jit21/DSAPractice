public class Practice2 {
    // lazy propagation update value by some integer in the range
    static class ST{
        int seg[];
        int lazy[];
        public ST(int n){
            seg=new int[4*n];
            lazy=new int[4*n];

        }
        // build function
        public void build(int ind,int low,int high,int arr[]){
            if(low==high){
                seg[ind]=arr[low];
                return;
            }
            int mid=(low+high)>>1;
            build(2*ind+1,low,mid,arr);
            build(2*ind+2, mid+1, high, arr);
            seg[ind]=seg[2*ind+1]+seg[2*ind+2];
        }
        //update function for updatig the all the value by some integer in the given range
        public void update(int ind,int low,int high,int l,int r,int val){
            // if any previous update is pending first do it and propagte to downword
            if(lazy[ind]!=0){
                seg[ind] += (high-low+1)*lazy[ind];
                if(low!=high){
                    lazy[2*ind+1]+=lazy[ind];
                    lazy[2*ind+2]+= lazy[ind];
                }
                lazy[ind]=0;

            }
            // no overlap int this range
            if(r<low || high<l) return ;
            // complete overlap
            if(low >= l && high<= r) {
                seg[ind] +=(high-low+1)*val;
                if(low!=high){
                    lazy[2*ind+1]+= val;
                    lazy[2*ind+2] += val;

                }
                return ;
            }
            // partial overlap in this range
            int mid= (low+high)>>1;
            update(2*ind+1,low,mid,l,r,val);
            update(2*ind+2, mid+1, high, l, r, val);
            seg[ind]=seg[2*ind+1]+seg[2*ind+2];
        
        }
        public int queries(int ind,int low,int high,int l,int r){
            // if any previous update is pending in this index then first do it 
            if(lazy[ind]!=0){
                seg[ind]+=(high-low+1)*lazy[ind];
                if(low!=high){
                    lazy[2*ind+1] += lazy[ind];
                    lazy[2*ind+2] += lazy[ind];
                }
                lazy[ind]=0;
            }
            // no overlap in this range
            if(low> r || high<l) return 0;

            // complete overlap
            if(low >= l &&high <= r){
                return seg[ind];
            }
            // partial overlap
            int mid=(low+high)>>1;
            int left= queries(2*ind+1, low, mid, l, r);
            int right=queries(2*ind+2, mid+1, high, l, r);
            return left+right;
        }
    }
    public static void solve(int arr[],int q[][]){
        int n= arr.length;
        int m=q.length;
        ST s=new ST(n);
        s.build(0, 0, n-1, arr);
        for(int i=0;i<m;i++){
            if(q[i][0]==0){
                System.out.println("sum of the given range is "+q[i][1]+"to "+q[i][2]+ " "+ s.queries(0,0,n-1,q[i][1],q[1][2]));
            }else{
                s.update(0,0,n-1,q[i][1],q[i][2],q[i][3]);

            }
        }
    }
    public static void main(String[] args) {

        int arr[]={1,2,3,4,5,6,7,8};

        int q[][]={{0,2,4},
    {1,2,4,10},
    {0,2,4}
    };
    solve(arr,q);
        

    }
    
}
