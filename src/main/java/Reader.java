public class Reader extends Human {

    public Reader(String name, String surname, String patronymic, String address, String id) {
        super(name, surname, patronymic, address, id);
    }

    @Override
    public Book interactWithBook(Book book, Books list) {
        return null;
    }
    public Book[] reportOnBooks(){ //Вернуть список книг
        return null;
    }
}
