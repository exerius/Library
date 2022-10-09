public class Book { // класс книги
    String id, name, author, publishHouse, publisher;
    Category categoryOfBook;
    int year;
    public Book(String id, String name, String author, String publishHouse, String publisher, int year, Category category){
        this.author = author;
        this.id = id;
        this.publishHouse = publishHouse;
        this.publisher = publisher;
        this.year = year;
        this.categoryOfBook = category;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book " + name + " by "+ author + "was published in " + year +" by " + publisher + " in " + publishHouse;
    }
}
