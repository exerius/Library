import java.util.ArrayList;

public class Reader extends Human {
    public ArrayList<Book> booksTaken = new ArrayList<Book>(); //список взятых книг

    public Reader(String name, String surname, String patronymic, String address, String id) {
        super(name, surname, patronymic, address, id);
    }
    public Reader(Human human){
        super(human);
    }
    public Reader(){super();}

    @Override
    public void interactWithBook(Book book, Books list) {
        if (booksTaken.contains(book)){
            booksTaken.remove(book);
        }
        else{

            booksTaken.add(book); //взять или сдать книгу
        }
    }
    public Book askLibrarianToFindBook(String id, Librarian librarian, Books books){ // попросить библиотекаря найти книгу
        return  librarian.findBookById(id, books);

    }
    @Override
    public void interactWithBook(Book book, Books list, Human human) { //не используется
        human.interactWithBook(book, list, this);


    }
    public ArrayList<Book> reportOnBooks(){ //Вернуть список книг
        return booksTaken;
    }
}
