class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right) return head;

        // Dummy node helps when left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Move prev to node just before left
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // curr = first node to be reversed
        ListNode curr = prev.next;

        // Reverse the portion
        for (int i = 0; i < right - left; i++) {
            ListNode next = curr.next;

            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }
}