package LinkedList.Searching;

class Searching {


    public static class Node {
        int data;
        Node next;


        public Node(int data) {
            this.data = data;
        }
    }


    public static Node head;
    public static Node tail;


    // 1. Display Linked List
    public static void display() {
        Node temp = head;


        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }


        System.out.println("null");
    }
    public static void insertAtEnd(int value) {
        Node temp = new Node(value);


        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }


    // 3. Insert at Start
    public static void insertAtStart(int value) {
        Node temp = new Node(value);


        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.next = head;
            head = temp;
        }
    }


    // 4. Count Nodes
    public static int countNodes() {
        Node temp = head;
        int count = 0;


        while (temp != null) {
            count++;
            temp = temp.next;
        }


        return count;
    }
    // 5. Search Element
    public static int search(int value) {
        Node temp = head;
        int index = 0;


        while (temp != null) {


            if (temp.data == value) {
                return index;
            }


            temp = temp.next;
            index++;
        }


        return -1;
    }
    public static void main(String[] args) {


        insertAtEnd(10);
        insertAtEnd(20);


        insertAtStart(5);
        insertAtStart(8);


        System.out.println("Linked List:");
        display();


        System.out.println("Number of Nodes: " + countNodes());


        System.out.println("Index of Element 5: " + search(5));

    }
}