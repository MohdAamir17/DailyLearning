package May_18;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}


public class LinkedList {

    Node head;

    public LinkedList() {
        this.head = null;
    }

    // Append operation: insert a new node at the end of the list
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    // find the length of linked List

    public static int length(Node head){
        if (head == null){
            return 0;
        }
        int count = 1;
        while (head.next != null){
            count++;
            head = head.next;
        }
        return count;
    }
    // Display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.display();
        int length = length(list.head);
        System.out.printf("Length of Linked List : " + length);


    }
}
