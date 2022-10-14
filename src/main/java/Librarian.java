public class Librarian extends Human {
    Book foundBook = null;
    public Librarian(String name, String surname, String patronymic, String address, String id) {
        super(name, surname, patronymic, address, id);
    }
    public Librarian(Human human){
        super(human);
    }

    @Override
    public void interactWithBook(Book book, Books list) {
    }

    @Override
    public Human clone() {
        return new Librarian(this);
    }

    public Book findBookById(String id, Books list){
        return list.findById(id);
    }
}
