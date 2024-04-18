public  class Circular_LL_Implemantation {
    public static class Node{
        int val;
        Node next;
        Node(int x){
            this.val = x;
            next = null;
        }
    }

    public static void printLinkedListData(Node head){
//        Node curr = head.next;
//        System.out.print(head.val);
//        while(curr != head){
//            System.out.print("->"+curr.val );
//            curr = curr.next;
//        }

        System.out.print(head.val);
        for(Node curr = head.next; curr != head; curr = curr.next){
            System.out.print("->"+curr.val );
        }



    }


}


