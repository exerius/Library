import java.util.ArrayList;

public class Reader extends Human {
    public ArrayList<Book> booksTaken = new ArrayList<Book>();

    public Reader(String name, String surname, String patronymic, String address, String id) {
        super(name, surname, patronymic, address, id);
    }
    public Reader(Human human){
        super(human);
    }
    public Reader(){super();}

    @Override
    public void interactWithBook(Book book, Books list) {
    }
    public Book askLibrarianToFindBook(String id, Librarian librarian, Books books){
        return  librarian.findBookById(id, books);

    }
    @Override
    public void interactWithBook(Book book, Books list, Human human) {
        human.interactWithBook(book, list, this);
        if (booksTaken.contains(book)){
            booksTaken.add(book);
        }
        else{
            booksTaken.remove(book);
        }

    }

    @Override
    public Human clone() {
        return new Reader(this);
    }

    public ArrayList<Book> reportOnBooks(){ //Вернуть список книг
        return booksTaken;
    }
}
