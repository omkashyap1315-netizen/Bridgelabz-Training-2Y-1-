package LinkedList.Basic;

public class BasicLinkedList {
    static void main(String[] args) {
        Node a = new Node( 5);
        Node b = new Node( 6);
        Node c = new Node( 8);
        Node d = new Node( 9);
        Node e = new Node( 10);
        System.out.println("Trick 1");
        System.out.print(a.data+" --> ");
        System.out.print(b.data+" --> ");
        System.out.print(c.data+" --> ");
        System.out.print(d.data+" --> ");
        System.out.print(e.data+" --> ");
        System.out.println(e.next);

        System.out.println("Trick 2");
        a.next = b;
        a.next = c;
        a.next = d;
        a.next = e;
        System.out.println(a.data+" --> ");
        System.out.println(a.next.data+" --> ");
        System.out.println(a.next.next.data+" --> ");
        System.out.println(a.next.next.next.data+" --> ");
        System.out.println(a.next.next.next.next.data+" --> ");
        System.out.println(e.next);
    }
}
