package LinkedList.Assignment_04;

import java.util.Comparator;

public class SLL_Q4_InventoryManagement {

    static class Item {
        String name;
        int id;
        int quantity;
        double price;
        Item next;

        Item(String name, int id, int quantity, double price) {
            this.name = name;
            this.id = id;
            this.quantity = quantity;
            this.price = price;
        }

        @Override
        public String toString() {
            return "ID: " + id + " | " + name + " | Qty: " + quantity + " | Price: " + price;
        }
    }

    static class Inventory {
        private Item head;

        // 1a. Add at beginning
        void addAtBeginning(Item item) {
            item.next = head;
            head = item;
        }

        // 1b. Add at end
        void addAtEnd(Item item) {
            if (head == null) {
                head = item;
                return;
            }
            Item temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = item;
        }

        // 1c. Add at position (1-based)
        void addAtPosition(int pos, Item item) {
            if (pos <= 1) {
                addAtBeginning(item);
                return;
            }
            Item temp = head;
            for (int i = 1; i < pos - 1 && temp != null; i++) temp = temp.next;
            if (temp == null) {
                System.out.println("Invalid position " + pos);
                return;
            }
            item.next = temp.next;
            temp.next = item;
        }

        // 2. Remove by Item ID
        boolean removeById(int id) {
            if (head == null) return false;
            if (head.id == id) {
                head = head.next;
                return true;
            }
            Item prev = head;
            while (prev.next != null && prev.next.id != id) prev = prev.next;
            if (prev.next == null) return false;
            prev.next = prev.next.next;
            return true;
        }

        // 3. Update quantity by Item ID
        boolean updateQuantity(int id, int newQty) {
            Item item = searchById(id);
            if (item == null) return false;
            item.quantity = newQty;
            return true;
        }

        // 4a. Search by Item ID
        Item searchById(int id) {
            for (Item n = head; n != null; n = n.next) {
                if (n.id == id) return n;
            }
            return null;
        }

        // 4b. Search by Item Name
        Item searchByName(String name) {
            for (Item n = head; n != null; n = n.next) {
                if (n.name.equalsIgnoreCase(name)) return n;
            }
            return null;
        }

        // 5. Total inventory value
        double totalValue() {
            double total = 0;
            for (Item n = head; n != null; n = n.next) total += n.price * n.quantity;
            return total;
        }

        // 6. Sort using merge sort
        void sort(boolean byName, boolean ascending) {
            Comparator<Item> base;
            if (byName) {
                base = (a, b) -> a.name.compareToIgnoreCase(b.name);
            } else {
                base = (a, b) -> Double.compare(a.price, b.price);
            }
            final Comparator<Item> baseFinal = base;
            Comparator<Item> cmp;
            if (ascending) {
                cmp = baseFinal;
            } else {
                cmp = (a, b) -> baseFinal.compare(b, a);
            }
            head = mergeSort(head, cmp);
        }

        private Item mergeSort(Item h, Comparator<Item> cmp) {
            if (h == null || h.next == null) return h;

            Item mid = getMiddle(h);
            Item secondHalf = mid.next;
            mid.next = null;

            Item left = mergeSort(h, cmp);
            Item right = mergeSort(secondHalf, cmp);
            return merge(left, right, cmp);
        }

        private Item getMiddle(Item h) {
            Item slow = h, fast = h.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private Item merge(Item a, Item b, Comparator<Item> cmp) {
            Item dummy = new Item("", 0, 0, 0);
            Item tail = dummy;
            while (a != null && b != null) {
                if (cmp.compare(a, b) <= 0) {
                    tail.next = a;
                    a = a.next;
                } else {
                    tail.next = b;
                    b = b.next;
                }
                tail = tail.next;
            }
            tail.next = (a != null) ? a : b;
            return dummy.next;
        }

        void display() {
            if (head == null) {
                System.out.println("Inventory is empty.");
                return;
            }
            for (Item n = head; n != null; n = n.next) System.out.println(n);
        }
    }

    public static void main(String[] args) {
        Inventory inv = new Inventory();

        inv.addAtEnd(new Item("Keyboard", 101, 10, 1500.0));
        inv.addAtEnd(new Item("Mouse", 102, 25, 500.0));
        inv.addAtBeginning(new Item("Monitor", 103, 5, 9000.0));
        inv.addAtPosition(2, new Item("Cable", 104, 50, 150.0));

        System.out.println("--- Inventory ---");
        inv.display();

        System.out.println("\n--- Search by ID 102 ---");
        Item i1 = inv.searchById(102);
        System.out.println(i1 != null ? i1 : "Item not found");

        System.out.println("\n--- Search by name 'monitor' ---");
        Item i2 = inv.searchByName("monitor");
        System.out.println(i2 != null ? i2 : "Item not found");

        System.out.println("\n--- Update quantity of ID 101 to 20 ---");
        System.out.println(inv.updateQuantity(101, 20) ? "Updated" : "Item not found");

        System.out.println("\n--- Total inventory value ---");
        System.out.println(inv.totalValue());

        System.out.println("\n--- Sort by name (ascending) ---");
        inv.sort(true, true);
        inv.display();

        System.out.println("\n--- Sort by price (descending) ---");
        inv.sort(false, false);
        inv.display();

        System.out.println("\n--- Remove item ID 104 ---");
        System.out.println(inv.removeById(104) ? "Removed" : "Item not found");
        inv.display();
    }
}
