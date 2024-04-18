public class Main {
    public static void main(String[] args) {
        Circular_LL_Implemantation.Node head = new Circular_LL_Implemantation.Node(10);
        Circular_LL_Implemantation.Node temp1 = new Circular_LL_Implemantation.Node(11);
        Circular_LL_Implemantation.Node temp2 = new Circular_LL_Implemantation.Node(12);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = head;

        Circular_LL_Implemantation.printLinkedListData(head);


    }
}