package medium;

import java.util.ArrayList;
import java.util.Collections;
class ListNode {
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
    
    public String toString() {
        return ""+val;
    }
}

public class problem143 {
    public static void main(String[] args) {
        reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
    }

    public static void reorderList(ListNode head) {
        ArrayList<ListNode> fwd = new ArrayList<>();
        ArrayList<ListNode> rev;
        ListNode at = head;

        // O(n)
        while (at != null) {
            fwd.add(at);
            at = at.next;
        }

        rev = new ArrayList<>(fwd);
        Collections.reverse(rev);

        // O(n)
        ArrayList<ListNode> tmp = new ArrayList<>();
        for (int j = 0; j < fwd.size()/2; j++) {
            tmp.add(fwd.get(j));
        }
        if (fwd.size() % 2 == 1) {
            tmp.add(fwd.get(fwd.size()/2));
        }

        // O(n)
        ArrayList<ListNode> tmp1 = new ArrayList<>();
        for (int j = 0; j < rev.size()/2; j++) {
            tmp1.add(rev.get(j));
        }
        fwd = new ArrayList<>(tmp);
        rev = new ArrayList<>(tmp1);

        // Reconstruir
        // O(n)
        for (int i = 0; i< rev.size(); i++){
            fwd.get(i).next = rev.get(i);
            if (i+1 < fwd.size()) {
                rev.get(i).next = fwd.get(i+1);
            } else {
                rev.get(i).next = null;
            }
        }
        if (fwd.size() > rev.size()) {
            fwd.get(fwd.size()-1).next = null;
        }

        ArrayList<ListNode> end = new ArrayList<>();
        at = head;
        while (at != null) {
            end.add(at);
            at = at.next;
        }
        System.out.println(end.toString());
    }
}
