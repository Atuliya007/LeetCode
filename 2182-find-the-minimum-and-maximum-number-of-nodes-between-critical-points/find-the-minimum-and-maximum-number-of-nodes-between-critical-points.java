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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res=new int[2];
        if(head.next==null){
            res[0]=-1;
            res[1]=-1;
            return res;
        }
        ListNode prev=head;
        ListNode temp=head.next;
        int first = -1;
        int prevcritical = -1;
        int currcritical = -1;
        int count=1;
        int firstcritical = -1;
        int maxdist = -1;
        int mindist = Integer.MAX_VALUE;
        while(temp.next!=null){
            boolean ismax = prev.val<temp.val && temp.val>temp.next.val;
            boolean ismin = prev.val>temp.val && temp.val<temp.next.val;
            if(ismax || ismin){
                if(firstcritical == -1){
                    firstcritical = count;
                    prevcritical = count;
                }else{
                    currcritical = count;
                    int distance = currcritical-prevcritical;
                    mindist = Math.min(mindist, distance);
                    prevcritical= currcritical;

                }
            }
            count++;
            prev=temp;
            temp=temp.next;
        }
        maxdist = prevcritical - firstcritical;
        if(mindist == Integer.MAX_VALUE){
            return new int[]{-1, -1};
        }
        return new int[]{mindist, maxdist};
    }
}