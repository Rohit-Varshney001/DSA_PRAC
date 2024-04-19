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

    public static Node insertAtBegining(Node head, int data){
        Node temp = new Node(data);
        if(head == null){
            temp.next = temp;
            return temp;
        }
        Node curr = head;
        while (curr.next != head){
            curr = curr.next;
        }
        curr.next = temp;
        temp.next = head;

        return temp;

    }
    public static Node insertAtEnd(Node head, int data){
        Node temp = new Node(data);
        if(head == null){
            temp.next = temp;
            return temp;
        }
        Node curr = head;
        while (curr.next != head){
            curr = curr.next;
        }
        curr.next = temp;
        temp.next = head;

        return head;

    }

    public static Node deleteHead(Node head){
        if (head == null){
            return null;
        }
        Node curr = head;
        while (curr.next != head){
            curr = curr.next;
        }
        curr.next = head.next;
        return curr.next;
    }


}


