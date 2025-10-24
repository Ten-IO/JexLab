/**
 * Create a model following objects:
 * ▪ ID Card
 * ▪ Facebook Post
 * ▪ Phone
 * ▪ Book
 *    1. Implement a Java Class with at least 5 attributes defined
 *    2. Create at least 3 objects with values assigned  
 *    3. Create an array and put all objects to that array
 */
package week02;

import java.util.ArrayList;

public class e11_classObj {
    public interface Table {
        String[] getRow();

        String[] getHeads();

    }

    public class IDCard implements Table {
        int id, expiration;
        String name, field, contact;

        public IDCard(int id, String name, String field, String contact, int expiration) {
            this.id = id;
            this.expiration = expiration;
            this.name = name;
            this.field = field;
            this.contact = contact;
        }

        public String[] getRow() {
            return new String[] { String.valueOf(id), name, field, contact, String.valueOf(expiration) };
        }

        public String[] getHeads() {
            return new String[] { "", "", "ID Cards", "", "" };
        }
    }

    public class FacebookPost implements Table {
        int id, postDate;
        String title, tag, location;

        public FacebookPost(int id, int postDate, String title, String tag, String location) {
            this.id = id;
            this.postDate = postDate;
            this.title = title;
            this.tag = tag;
            this.location = location;
        }

        public String[] getRow() {
            return new String[] { String.valueOf(id), title, tag, String.valueOf(postDate), location };
        }

        public String[] getHeads() {
            return new String[] { "", "", "Facebook Post", "", "" };
        }
    }

    public class Phone implements Table{
        String holder, tel, location, model;
        float balance;

        public Phone(String holder, String tel, String model, float balance, String location) {
            this.holder = holder;
            this.tel = tel;
            this.location = location;
            this.model = model;
            this.balance = balance;
        }

        public String[] getRow(){
            return new String[]{model, tel, String.valueOf(balance), holder, location};
        }

        public String[] getHeads() {
            return new String[] { "", "", "Phone", "", "" };
        }
    }

    public class Book implements Table {
        String isbn, publisher, author;
        int price, year;

        public Book(String isbn, String author, String publisher, int price, int year) {
            this.isbn = isbn;
            this.publisher = publisher;
            this.author = author;
            this.price = price;
            this.year = year;
        }

        public String[] getRow() {
            return new String[] { isbn, author, publisher, String.valueOf(price), String.valueOf(year) };
        }

        public String[] getHeads() {
            return new String[] { "", "", "Book", "", "" };
        }
    }

    static void show(ArrayList<? extends Table> ls) {
        for (Table t : ls) {
            if (t == null)
                return;
        }
        String[] head = ls.get(0).getHeads();
        System.out.println("+_______________________________________________________________________________________________________________________+");
        System.out.printf("| %-20s   %-27s   %-11s   %-27s   %-20s |%n", head[0], head[1], head[2], head[3], head[4]);
        System.out.println("|_______________________________________________________________________________________________________________________|");
        for (Table t : ls) {
            String[] row = t.getRow();
            System.out.printf("| %-20s | %-20s | %-20s | %-25s | %-20s |%n", row[0], row[1], row[2], row[3], row[4]);
        }
        System.out.println("|______________________|______________________|______________________|___________________________|______________________|\n");
    }

    
    public static void main(String[] args) {
        e11_classObj instance = new e11_classObj();
        // === IDCard objects ===
        ArrayList<IDCard> tb_01 = new ArrayList<>();
        tb_01.add(instance.new IDCard(101, "Alice Johnson", "Engineering", "alice.j@example.com", 2026));
        tb_01.add(instance.new IDCard(102, "Bob Smith", "Marketing", "bob.s@example.com", 2025));
        tb_01.add(instance.new IDCard(103, "Charlie Brown", "Finance", "charlie.b@example.com", 2027));
        
        // === FacebookPost objects ===
        ArrayList<FacebookPost> tb_02 = new ArrayList<>();
        tb_02.add(instance.new FacebookPost(1, 20241001, "Vacation Time!", "Travel", "Hawaii"));
        tb_02.add(instance.new FacebookPost(2, 20240915, "New Job Update", "Career", "New York"));
        tb_02.add(instance.new FacebookPost(3, 20240810, "Cooking with Friends", "Food", "Home"));
        
        // === Phone objects ===
        ArrayList<Phone> tb_03 = new ArrayList<>();
        tb_03.add(instance.new Phone("Alice Johnson", "+1-555-111-2222", "iPhone 15", 50.75f, "New York"));
        tb_03.add(instance.new Phone("Bob Smith", "+1-555-333-4444", "Samsung S24", 120.00f, "Los Angeles"));
        tb_03.add(instance.new Phone("Charlie Brown", "+1-555-555-6666", "Google Pixel 9", 75.50f, "Chicago"));

        // === Book objects ===
        ArrayList<Book> tb_04 = new ArrayList<>();
        tb_04.add(instance.new Book("978-0-123456-47-2", "J.K. Rowling", "Bloomsbury", 25, 2007));
        tb_04.add(instance.new Book("978-1-234567-89-0", "George Orwell", "Penguin", 15, 1949));
        tb_04.add(instance.new Book("978-0-987654-32-1", "Haruki Murakami", "Vintage", 30, 2015));

        show(tb_01);
        show(tb_02);
        show(tb_03);
        show(tb_04);
    }
}
