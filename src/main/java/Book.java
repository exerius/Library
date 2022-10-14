public class Book { // класс книги
    public String id, name, author, publishHouse, publisher; //публичные даные
    public Category categoryOfBook;
    public int year;
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

    @Override
    public String toString() { // метод определяющий вывод объекта книги в виде строки
        return "Book " + name + " by "+ author + " was published in " + year +" by " + publisher + " in " + publishHouse;
    }
}
