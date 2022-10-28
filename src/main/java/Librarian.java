public class Librarian extends Human {
    Book foundBook = null; // найденная книга
    public Librarian(String name, String surname, String patronymic, String address, String id) {
        super(name, surname, patronymic, address, id);
    }
    public Librarian(Human human){
        super(human);
    }
    public Librarian(){super();}

    @Override
    public void interactWithBook(Book book, Books list) {
    }

    @Override
    public void interactWithBook(Book book, Books list, Human human) { //взять или выдать книгу
        if(book.owner == null){
            book.owner = (Reader) human;
            list.handedOut += 1;
        }
        else{
            book.owner = null;
            list.handedOut -=1;
        }

    }

    public Book findBookById(String id, Books list){ //поиск книги
        foundBook = list.findById(id);
        return list.findById(id);
    }
}
