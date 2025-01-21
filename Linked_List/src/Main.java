public class Main {
    public static void main(String[] args) {
        Linked_list_implementation.Node head = new Linked_list_implementation.Node(10);
        Linked_list_implementation.Node temp1 = new Linked_list_implementation.Node(11);
        Linked_list_implementation.Node temp2 = new Linked_list_implementation.Node(12);

        head.next = temp1;
        temp1.next = temp2;

        Linked_list_implementation.printLinkedListData(head);

        Linked_list_implementation.printLinkedListRec(head);

        Linked_list_implementation.retVal result = Linked_list_implementation.searchInLinkedListIterative(10, head);
        System.out.println("Number found : "+ result.found +" at "+ result.x );

        System.out.println(Linked_list_implementation.searchLinkedListRec(11, head));

        System.out.println("\nHello world!");

        head = Linked_list_implementation.addToStart(5, head);
        Linked_list_implementation.printLinkedListData(head);

        Linked_list_implementation.addToEnd(55, head);
        Linked_list_implementation.printLinkedListData(head);

        head = Linked_list_implementation.deleteFirst(head);
        Linked_list_implementation.printLinkedListData(head);

        head = Linked_list_implementation.deleteFromLast(head);
        Linked_list_implementation.printLinkedListData(head);

        head = Linked_list_implementation.insertAtIndex(head, 1, 88);
        Linked_list_implementation.printLinkedListData(head);

        head = Linked_list_implementation.addToStart(55, head);
        Linked_list_implementation.printLinkedListData(head);

        System.out.println(Linked_list_implementation.middleOfLinkedList(head));

        Linked_list_implementation.nFromEnd(head, 2);
        Linked_list_implementation.nFromEndUsingTwoPointer(head,3);

        head = Linked_list_implementation.reverseLinkedList(head);
        Linked_list_implementation.printLinkedListData(head);

        head = Linked_list_implementation.recRevL(head,null);
        Linked_list_implementation.printLinkedListData(head);

        Linked_list_implementation.removeDuplicate(head);
        System.out.println("======================");
        Linked_list_implementation.printLinkedListData(head);

        head = Linked_list_implementation.rotateList(head,2);
        System.out.println("Rotated ======================");
        Linked_list_implementation.printLinkedListData(head);









    }
}