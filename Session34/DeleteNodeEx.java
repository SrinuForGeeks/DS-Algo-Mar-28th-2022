public class DeleteNodeEx {
     public void deleteNode(ListNode node) {
        
        node.val = node.next.val;
        node.next = node.next.next;
        
    }

    public static void main(String[] args) {
        
        DeleteNodeEx s = new DeleteNodeEx();
        LinkedList l = new LinkedList();

        ListNode head = l.construct(new int[]{4,5,1,9});
        ListNode dnode = l.get(1);

        System.out.print("\nBefore Deleting Node["+ dnode.val +"] --> ");
        l.print(head);
    

        s.deleteNode(dnode);

        System.out.print("\nAfter Deleting Node  --> ");
        l.print(head);
    }
}