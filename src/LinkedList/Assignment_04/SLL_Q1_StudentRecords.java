package LinkedList.Assignment_04;

public class SLL_Q1_StudentRecords {

    static class Student {
        int rollNo;
        String name;
        int age;
        String grade;
        Student next;

        Student(int rollNo, String name, int age, String grade) {
            this.rollNo = rollNo;
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Roll No: " + rollNo + " | Name: " + name + " | Age: " + age + " | Grade: " + grade;
        }
    }

    static class StudentList {
        private Student head;

        void addAtBeginning(Student s) {
            if (search(s.rollNo) != null) {
                System.out.println("Roll number " + s.rollNo + " already exists!");
                return;
            }
            s.next = head;
            head = s;
        }

        void addAtEnd(Student s) {
            if (search(s.rollNo) != null) {
                System.out.println("Roll number " + s.rollNo + " already exists!");
                return;
            }
            if (head == null) {
                head = s;
                return;
            }
            Student temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = s;
        }

        void addAtPosition(int pos, Student s) {
            if (search(s.rollNo) != null) {
                System.out.println("Roll number " + s.rollNo + " already exists!");
                return;
            }
            if (pos <= 1) {
                addAtBeginning(s);
                return;
            }
            Student temp = head;
            for (int i = 1; i < pos - 1 && temp != null; i++) temp = temp.next;
            if (temp == null) {
                System.out.println("Invalid position " + pos);
                return;
            }
            s.next = temp.next;
            temp.next = s;
        }

        boolean deleteByRollNo(int rollNo) {
            if (head == null) return false;
            if (head.rollNo == rollNo) {
                head = head.next;
                return true;
            }
            Student prev = head;
            while (prev.next != null && prev.next.rollNo != rollNo) prev = prev.next;
            if (prev.next == null) return false;
            prev.next = prev.next.next;
            return true;
        }

        Student search(int rollNo) {
            Student temp = head;
            while (temp != null) {
                if (temp.rollNo == rollNo) return temp;
                temp = temp.next;
            }
            return null;
        }

        void display() {
            if (head == null) {
                System.out.println("No student records.");
                return;
            }
            Student temp = head;
            while (temp != null) {
                System.out.println(temp);
                temp = temp.next;
            }
        }

        boolean updateGrade(int rollNo, String newGrade) {
            Student s = search(rollNo);
            if (s == null) return false;
            s.grade = newGrade;
            return true;
        }
    }

    public static void main(String[] args) {
        StudentList list = new StudentList();

        System.out.println("--- Adding students ---");
        list.addAtEnd(new Student(2, "Rahul", 19, "B"));
        list.addAtBeginning(new Student(1, "Shivi", 20, "A"));
        list.addAtEnd(new Student(4, "Neha", 19, "A"));
        list.addAtPosition(3, new Student(3, "Aman", 21, "C"));
        list.display();

        System.out.println("\n--- Search roll no 3 ---");
        Student found = list.search(3);
        System.out.println(found != null ? found : "Student not found");

        System.out.println("\n--- Update grade of roll no 2 to A+ ---");
        System.out.println(list.updateGrade(2, "A+") ? "Grade updated" : "Student not found");
        list.display();

        System.out.println("\n--- Delete roll no 1 ---");
        System.out.println(list.deleteByRollNo(1) ? "Deleted" : "Student not found");
        list.display();

        System.out.println("\n--- Delete roll no 99 (does not exist) ---");
        System.out.println(list.deleteByRollNo(99) ? "Deleted" : "Student not found");
    }
}

