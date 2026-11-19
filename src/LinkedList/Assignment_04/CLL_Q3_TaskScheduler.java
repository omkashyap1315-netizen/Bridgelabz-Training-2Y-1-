package LinkedList.Assignment_04;

public class CLL_Q3_TaskScheduler {

    static class Task {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Task next;

        Task(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
        }

        @Override
        public String toString() {
            return "Task ID: " + taskId + " | " + taskName + " | Priority: " + priority + " | Due: " + dueDate;
        }
    }

    static class TaskScheduler {
        private Task head, tail;
        private Task current;
        private int size = 0;

        void addAtBeginning(Task t) {
            if (head == null) {
                head = tail = t;
                t.next = t;
                current = t;
            } else {
                t.next = head;
                tail.next = t;
                head = t;
            }
            size++;
        }

        void addAtEnd(Task t) {
            if (head == null) {
                head = tail = t;
                t.next = t;
                current = t;
            } else {
                tail.next = t;
                t.next = head;
                tail = t;
            }
            size++;
        }

        void addAtPosition(int pos, Task t) {
            if (pos <= 1) {
                addAtBeginning(t);
            } else if (pos == size + 1) {
                addAtEnd(t);
            } else if (pos > size + 1) {
                System.out.println("Invalid position " + pos);
            } else {
                Task temp = head;
                for (int i = 1; i < pos - 1; i++) temp = temp.next;
                t.next = temp.next;
                temp.next = t;
                size++;
            }
        }

        boolean removeById(int id) {
            if (head == null) return false;

            Task prev = tail;
            Task curr = head;
            do {
                if (curr.taskId == id) {
                    if (curr == head && curr == tail) {
                        head = tail = null;
                        current = null;
                    } else {
                        prev.next = curr.next;
                        if (curr == head) head = curr.next;
                        if (curr == tail) tail = prev;
                        if (current == curr) current = curr.next;
                    }
                    size--;
                    return true;
                }
                prev = curr;
                curr = curr.next;
            } while (curr != head);
            return false;
        }

        void viewCurrentAndMoveNext() {
            if (current == null) {
                System.out.println("No tasks.");
                return;
            }
            System.out.println("Current task: " + current);
            current = current.next;
            System.out.println("Moved to next task: " + current.taskName);
        }

        void displayAll() {
            if (head == null) {
                System.out.println("No tasks.");
                return;
            }
            Task temp = head;
            do {
                System.out.println(temp);
                temp = temp.next;
            } while (temp != head);
        }

        void searchByPriority(int priority) {
            if (head == null) {
                System.out.println("No tasks.");
                return;
            }
            boolean found = false;
            Task temp = head;
            do {
                if (temp.priority == priority) {
                    System.out.println(temp);
                    found = true;
                }
                temp = temp.next;
            } while (temp != head);
            if (!found) System.out.println("No task with priority " + priority);
        }
    }

    public static void main(String[] args) {
        TaskScheduler s = new TaskScheduler();

        s.addAtEnd(new Task(1, "Write report", 2, "25-11-2026"));
        s.addAtEnd(new Task(2, "Study DSA", 1, "22-11-2026"));
        s.addAtBeginning(new Task(3, "Submit assignment", 1, "21-11-2026"));
        s.addAtPosition(2, new Task(4, "Practice Java", 3, "30-11-2026"));

        System.out.println("--- All tasks ---");
        s.displayAll();

        System.out.println("\n--- Viewing tasks in circular order (6 times) ---");
        for (int i = 0; i < 6; i++) s.viewCurrentAndMoveNext();

        System.out.println("\n--- Search priority 1 ---");
        s.searchByPriority(1);

        System.out.println("\n--- Remove task ID 3 (head) ---");
        System.out.println(s.removeById(3) ? "Removed" : "Not found");
        s.displayAll();

        System.out.println("\n--- Remove task ID 1 (tail) ---");
        System.out.println(s.removeById(1) ? "Removed" : "Not found");
        s.displayAll();
    }
}
