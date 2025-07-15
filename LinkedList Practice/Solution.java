/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.*;
public class Solution {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val= val;
            this.next=null;
        }
    }
    // solving this problem by brute force approch takes O(nk) times 
    public boolean fun(ListNode[] arr){
        int k= arr.length;
         for(int i=0;i<k;i++){
            if(arr[i]!=null) return true;
         }
         return false;

    }
    public ListNode mergeKLists(ListNode[] lists) {
        // merging k sorted list into one sorted list 
        ListNode ans= new ListNode(0);
        ListNode temp1= ans;
        int k= lists.length;
        ListNode arr[]=new ListNode[k];
        for(int i=0;i<k;i++){
            arr[i]= lists[i];
            
        }
        while(fun(arr)){
            ListNode temp=new ListNode(Integer.MAX_VALUE);
            int index=-1;
            for(int i=0;i<k;i++){
                if(arr[i]!=null){
                if(arr[i].val< temp.val){
                    temp= arr[i];
                    index=i;

                }
                }
            }
        if(index!=-1){    
        temp1.next= new ListNode(temp.val);
        temp1= temp1.next;
        arr[index]= arr[index].next;
        }
        }

        return ans.next;
        
    }

    // now we are using minHeap to optimized the solution with O(nlogk)
     public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans= new ListNode(0);
        ListNode curr= ans;
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        int k= lists.length;
        for(int i=0;i<k;i++){
            if(lists[i]!=null){
            pq.add(lists[i]);
            }
        }

        while(!pq.isEmpty()){
            ListNode minNode= pq.remove();
            curr.next=minNode;
            curr= curr.next;
            if(minNode.next!=null){
                pq.add(minNode.next);
            }
        }

        return ans.next;
        
    }

}
