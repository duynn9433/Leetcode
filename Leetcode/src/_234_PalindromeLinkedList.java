import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class _234_PalindromeLinkedList {
    private ListNode frontNode; //node dau tien cua danh sach
    public boolean isPalindrome(ListNode head) {
        frontNode = head;
        return Try(head);
    }

    private boolean Try(ListNode node) {
        if(node != null){
            //chay den cuoi danh sach
            if(!Try(node.next)){
                return false;
            }
            //so sanh gia tri cua node dau tien voi node cuoi cung
            if(frontNode.val != node.val){
                return false;
            }
            //xet node tiep theo
            frontNode = frontNode.next;
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
