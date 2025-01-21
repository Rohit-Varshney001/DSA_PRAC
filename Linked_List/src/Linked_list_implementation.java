
public class Linked_list_implementation {
    public static class Node{
        int val;
        Node next;
        Node(int x){
            val = x;
            next = null;
        }
    }
    public static class retVal{
        int x = -1;
        boolean found;
    }

    public static void printLinkedListData(Node head){
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }
    public static void printLinkedListRec(Node head){
        if(head == null){
            System.out.println("null");
            return;
        }
        System.out.print(head.val + "->");
        printLinkedListRec(head.next);
    }

    public static retVal searchInLinkedListIterative(int num, Node head){
        retVal retVal = new retVal();

        int ind = 1;
        while(head != null){
            if(num == head.val){
                retVal.x = ind;
                retVal.found = true;
                return retVal;
            }else{
                ind++;
            }
            head = head.next;
        }
        return retVal;
    }


    public static int searchLinkedListRec(int num, Node head){
        if(head == null){
            return -1;
        }else if(head.val == num){
            return 1;
        }else{
           int res = searchLinkedListRec(num, head.next) ;
           if(res == -1){
               return -1;
           }else {
               return res+1;
           }

        }

    }

    public static Node addToStart(int num, Node head){
        Node temp = new Node(num);
        temp.next = head;
        return temp;
    }
    public static Node addToEnd(int num, Node curr){
        Node temp = new Node(num);
        if (curr == null){
            return temp;
        }
        Node head = curr;
        while (head.next != null){
            head = head.next;
        }
        head.next = temp;
        temp.next = null;
        return curr;
    }

    public static Node deleteFirst(Node head){
        if(head == null){
            return head;
        }
        Node temp = head.next;
        head.next = null;
        head = temp;

        return head;
    }

    public static Node deleteFromLast(Node curr){

        Node head = curr;

        if (head.next == null){
            return head;
        }
        while (head.next.next != null){
            head = head.next;
        }
        head.next = null;


        return curr;
    }

    public static Node insertAtIndex(Node head, int index, int data){
        Node temp = new Node(data);

        if(index == 1){
            temp.next = head;
            return temp;
        }

        Node curr = head;


        for(int i = 1; i<= index-2 && curr != null; i++){
            curr = curr.next;
        }
        if(curr == null){
            return head;
        }
        temp.next = curr.next;
        curr.next = temp;
        return head;


    }
    public static Node insertAtIndexDoublePointer(Node head, int index, int data){
        Node temp = new Node(data);

        if (index == 1) {
            temp.next = head;
            return temp;
        }

        Node prev = null;
        Node curr = head;
        int count = 1;

        while (curr != null && count < index) {
            prev = curr;
            curr = curr.next;
            count++;
        }

        if (count != index) {
            // Index out of bounds, return the original head
            return head;
        }

        // Insert at the specified index
        temp.next = curr;
        prev.next = temp;

        return head;
    }

    public static int middleOfLinkedList(Node head){
        Node slowPtr = head;
        Node fastPtr = head.next;

        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        return slowPtr.val;
    }

    public static void nFromEnd(Node head, int n){
        int len = 0;
        for(Node curr = head; curr != null; curr = curr.next){
            len++;
        }
        if(len < n){
            return;
        }

        Node curr = head;
        for(int i =1 ; i < len -n +1; i++){
            curr = curr.next;
        }
        System.out.println(curr.val);


    }

    public static void nFromEndUsingTwoPointer(Node head, int n){
        if(head == null){
            return;
        }
        Node fast = head, slow = head;

        for(int i = 0; i<n; i++){
            if(fast == null){
                return;
            }
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println(slow.val);
    }
    public static Node reverseLinkedList(Node head){
        Node curr = head;
        Node prev = null;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static Node recRevL(Node curr,Node prev){
        if(curr==null)return prev;
        Node next=curr.next;
        curr.next=prev;
        return recRevL(next,curr);
    }


    public static void removeDuplicate(Node head){
        Node curr = head;

        while(curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }


    }

    public static Node rotateList(Node head, int k){
        if(k == 0 || head == null){
            return head;
        }
        int len = 1;
        Node curr = head;
        while(curr.next != null){
            curr=curr.next;
            len++;
        }
        k %= len;

        if(k == 0) return head;
//        make list circular;
        curr.next = head;

        for (int i = 0; i<k; i++){
            curr = curr.next;
//            Break loop at k.
        }
        head = curr.next;
        curr.next = null;

        return head;

    }







}
