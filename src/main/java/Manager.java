public class Manager extends Human { //Класс менеджера
    public Manager(String name, String surname, String patronymic, String address, String id) {
        super(name, surname, patronymic, address, id);
    }

    @Override
    public Book interactWithBook(Book book, Books list) {
        if(list.contains(book)){
            list.remove(book);
        }
        else {
            list.add(book);
        }
        return null;
    }
    public int countBooksByCategory(Category category, Books list){
        return list.booksByCategory(category);
    }
    public Book[] booksByReader(Reader reader){
       return reader.reportOnBooks();
    }
    public int[] statistics(Books list){
        int[] stat = new int[2];
        stat[0] = list.handedOut;
        stat[1] = list.size();
        return  stat;
    }

}
