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
class Solution {
    public int pairSum(ListNode head) {
        if(head.next.next==null)return (head.val+head.next.val);
        ListNode temp=head;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count=0;
        int max=0;
        while(temp!=null)
        {
            hm.put(count,temp.val);
            temp=temp.next;
            count++;
        }    
        for(int i=0;i<hm.size();i++){
            if(hm.get(i)+hm.get(count-i-1)>max){
                max=hm.get(i)+hm.get(count-i-1);
            }
        }
        return max;
    }}