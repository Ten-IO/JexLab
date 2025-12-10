package week04;

public class e06_StudentListNoArray {
    static class Student {
        String id, name, gender;
        int age;
        double grade;
    }
    static class StudentList {
        private Student student;
        private StudentList next;
        public void add(String name) {
            if (student == null) {
                student = new Student();
                student.name = name;
            } else {
                StudentList last = this;
                while (last.next != null) last = last.next;
                last.next = new StudentList();
                last.next.student = new Student();
                last.next.student.name = name;
            }
        }
        public void remove(int index) {
            if (index == 0 && student != null) {
                student = next != null ? next.student : null;
                next = next != null ? next.next : null;
                return;
            }
            StudentList prev = null, curr = this;
            for (int i = 0; i < index && curr != null; i++) {
                prev = curr;
                curr = curr.next;
            }
            if (curr == null) {
                System.out.println("Index out of range.");
                return;
            }
            prev.next = curr.next;
        }
        public void removeLast() {
            if (student == null) return;
            if (next == null) {
                student = null;
                return;
            }
            StudentList prev = null, curr = this;
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
        }
        public void clear() {
            student = null;
            next = null;
        }
        public void display() {
            if (student == null) {
                System.out.println("Array is empty");
                return;
            }
            StudentList curr = this;
            while (curr != null && curr.student != null) {
                System.out.println(curr.student.name);
                curr = curr.next;
            }
        }
    }
    public static void main(String[] args) {
        StudentList myArr = new StudentList();
        System.out.println("==> Add");
        myArr.add("Mina");
        myArr.add("Kompheak");
        myArr.display();
        System.out.println("\n==> Remove at last");
        myArr.removeLast();
        myArr.add("Minea");
        myArr.add("Mehsa");
        myArr.display();
        System.out.println("\n==> Remove at larger index");
        myArr.remove(18);
        System.out.println("==> Clear all element");
        myArr.clear();
        myArr.display();
    }
}