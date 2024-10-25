package neetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedList {

    public class ListNode{
        int val;
        ListNode next;

        ListNode(int val){ this.val = val;}
        ListNode(int val, ListNode next){ this.val = val; this.next = next;}

    }

    public boolean hasCycle(ListNode head){
        Set<ListNode> setNode = new HashSet<>();

        ListNode cur = head;

        while(cur != null){
            if(!setNode.contains(cur.next)){
                setNode.add(cur.next);
            }
            else{
                return true;
            }
            cur = cur.next;
        }

        return false;
    }



    public static ListNode reverseList(ListNode head){

        ListNode prev = null;
        ListNode curr = head;

        while( curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void reoderList(ListNode head){

        ListNode slow = head;
        ListNode fast = head.next;

        // find middle
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;

        // reverse second half
        while (second != null){
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        ListNode first = head;
        second = prev;

        while(second != null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }


    }

    public static ListNode removeNthFromEnd(ListNode head, int n){


        //certo
        //ListNode dummy = new ListNode(0, head);
        ListNode dummy = head;
        ListNode l = dummy;

        ListNode r = head;


        while(n > 0 && r != null){
            r = r.next;
            n--;
        }

        while(r != null){
            l = l.next;
            r = r.next;
        }

        l.next = l.next.next;

        return dummy.next;
    }
}
