import java.io.Serializable;
import java.util.Scanner;

public class Book implements Serializable { // класс книги
    public String id, name, author, publishHouse, publisher; //публичные даные
    public Category categoryOfBook;
    public int year;
    public Reader owner = null;
    public Book(String id, String name, String author, String publishHouse, String publisher, int year, Category category){ //конструктор
        this.author = author;
        this.id = id;
        this.publishHouse = publishHouse;
        this.publisher = publisher;
        this.year = year;
        this.categoryOfBook = category;
        this.name = name;
    }
    public  Book(Book book){ // другой конструтор
        this.author = book.author;
        this.id = book.id;
        this.publishHouse = book.publishHouse;
        this.publisher = book.publisher;
        this.year = book.year;
        this.categoryOfBook = book.categoryOfBook;
        this.name = book.name;
    }
    public Book(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter book id"); // сбор характеристик книги
        this.id = sc.next();
        System.out.println("Enter name of book");
        this.name  = sc.next();
        System.out.println("Enter book`s author name");
        this.author = sc.next();
        System.out.println("Enter book`s publish house");
        this.publishHouse = sc.next();
        System.out.println("Enter book`s publisher");
        this.publisher = sc.next();
        System.out.println("Enter book`s publish year");
        this.year = Integer.parseInt(sc.next());
        System.out.println("Enter book`s genre");
        this.categoryOfBook = Category.valueOf(sc.next());
    }

    @Override
    public String toString() { // метод определяющий вывод объекта книги в виде строки
        return "Book " + name + " by "+ author + " was published in " + year +" by " + publisher + " in " + publishHouse;
    }
}
