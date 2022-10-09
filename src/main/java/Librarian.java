public class Librarian extends Human {
    Book foundBook = null;
    public Librarian(String name, String surname, String patronymic, String address, String id) {
        super(name, surname, patronymic, address, id);
    }

    @Override
    public Book interactWithBook(Book book, Books list) {
        return null;
    }
    public Book findBookById(String id, Books list){
        return list.findById(id);
    }
}
