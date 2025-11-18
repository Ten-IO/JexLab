/*
 *  Create a model following class diagrams and objects:
 ▪ Phone shop:  Product and Category
 ▪ Youtube: User and Video
 ▪ BookStore: Book and Author
 1. Create a class diagram to represent relationship of two classes
 2. Implement each Java Class with at least 5 attributes defined
 3. Create at least 1 objects of related Class
 4. Create at least 3 objects with values assigned
 5. Create an array and put all objects to that array
 6. Create a loop to display all object in that array
 */

package week03;

public class e08_ClassDiagram{
    static class Product{Category category;String model, price, size, release; }
    static class Category{boolean phone, accessories, parts, wearables, others;}
    class PhoneShop{
        Product product = new Product();
        void setValue(Category category, String model, String price, String size, String release){
            this.product.category = category;
            this.product.model = model;
            this.product.price = price;
            this.product.size = size;
            this.product.release = release;
        }
        void display(){
            System.out.println("\n== Product Category ==");
            Category cat = product.category;
            if (cat.phone)
            System.out.println("Product Type: PHONE");
            else if(cat.accessories)
            System.out.println("Product Type: ACCESSORIES");
            else if(cat.parts)
            System.out.println("Product Type: ELECTRONIC PARTS");
            else if(cat.wearables)
            System.out.println("Product Type: WEARABLES");
            else
            System.out.println("Product Type: OTHERS");
            System.out.println("== Detail ==");
            System.out.printf("Model:   %s%nPrice:   %s%nSize:    %s%nRelease: %s%n", product.model, product.price, product.size, product.release);
        }
    }

    static class User{String id, name, type, country; Video video;}
    static class Video{String id, name, dateofupload, type, location;}
    class Youtube{
        User user = new User();
        void setValue(String id, String name, String type, String country, Video video){
            this.user.id = id;
            this.user.name = name;
            this.user.video= video;
            this.user.type =  type;
            this.user.country= country;
        }
        void display(){
            System.out.println("\n== About User ==");
            System.out.printf("ID:       %s%nUsername: %s%nType:     %s%nCountry:  %s%n", user.id, user.name, user.type, user.country);
            System.out.println("== Video Details ==");
            Video vid = user.video;
            System.out.printf("ID         :%s%nTitle      :%s%nUpload Date:%s%nType       :%s%nLocation   :%s%n", vid.id, vid.name, vid.dateofupload, vid.type, vid.location);
        }
    }

    static class Book{String id, title, publisher, date; Author author;}
    static class Author{String name, gender, email, achievement, nationality;}
    class BookStore{
        Book book = new Book();
        void setValue(String id, String title, String publisher, String date, Author author){
            this.book.id = id;
            this.book.title = title;
            this.book.publisher = publisher;
            this.book.date = date;
            this.book.author = author;
        }
        void display(){
            System.out.println("\n== Book Detail ==");
            System.out.printf("ID:        %s%nTitle:     %s%nPublisher: %s%nDate:      %s%n", book.id, book.title, book.publisher, book.date);
            System.out.println("== Author Detail ==");
            Author au = book.author;
            System.out.printf("Author     :%s%nGender     :%s%nUpload Date:%s%nType       :%s%nLocation   :%s%n", au.name, au.gender, au.email, au.achievement, au.nationality);
        }
    }
    public static void main(String[] args) {
        // Phone Store
        Category category = new Category();
        category.phone = true;
        PhoneShop shop = new e08_ClassDiagram().new PhoneShop();
        shop.setValue(category, "iPhone 13", "$999", "6.1 inches", "2021");

        // Youtube 
        Video video = new Video();
        video.id = "v03";
        video.name = "Cooking Show";
        video.dateofupload = "2021-06-10";
        video.type = "Food";
        video.location = "Italy";

        Youtube youtube = new e08_ClassDiagram().new Youtube();
        youtube.setValue("u23", "Nara", "Influencer", "JP", video);

        // Bookstore
        Author author = new Author();
        author.name = "J.K. Rowling";
        author.gender = "Female";
        author.email = "jk.rowling@mail.com";
        author.achievement = "Harry Potter Series, Grammy Award";
        author.nationality = "British";

        BookStore bookstore = new e08_ClassDiagram().new BookStore();
        bookstore.setValue("010", "A Game of Thrones", "Bantam Books", "1996",author);
        
        Object[] arr = new Object[3];
        arr[0] = shop;
        arr[1] = youtube;
        arr[2] = bookstore;
        for (Object obj : arr) {
            if (obj instanceof PhoneShop) {
                ((PhoneShop) obj).display();
            } else if (obj instanceof Youtube) {
                ((Youtube) obj).display();
            } else if (obj instanceof BookStore) {
                ((BookStore) obj).display();
            }}
    }
}