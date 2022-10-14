public class Reader extends Human {

    public Reader(String name, String surname, String patronymic, String address, String id) {
        super(name, surname, patronymic, address, id);
    }
    public Reader(Human human){
        super(human);
    }

    @Override
    public void interactWithBook(Book book, Books list) {
    }

    @Override
    public Human clone() {
        return new Reader(this);
    }

    public Book[] reportOnBooks(){ //Вернуть список книг
        return null;
    }
}
