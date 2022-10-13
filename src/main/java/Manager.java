import java.util.Scanner;

public class Manager extends Human { //Класс менеджера
    public Manager(String name, String surname, String patronymic, String address, String id) {
        super(name, surname, patronymic, address, id);
    }
    enum Attributes  {name, author, publishHouse, publisher, category}
    public static class Helper{
        Books list;
        public Helper(Books books){
            this.list = books;
        }
        public int[] statistics(){
            int[] stat = new int[2];
            stat[0] = this.list.handedOut;
            stat[1] = this.list.size() - stat[0];
            return  stat;
        }
        public int countBooksByCategory(Category category){
            return this.list.booksByCategory(category);
        }

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
    public Book[] booksByReader(Reader reader){
       return reader.reportOnBooks();
    }
    public Book transformBook(Book book){
        Scanner sc = new Scanner(System.in);
        System.out.println("Какой атрибут подлежит изменению?");
        Attributes attr = Attributes.valueOf(sc.next());
        System.out.println("Введите новое значение");
        String value = sc.next();
        Book newBook = new Book(book);
        switch (attr){
            case author:
                newBook.author = value;
            case name:
                newBook.name = value;
            case  publisher:
                newBook.publisher = value;
            case publishHouse:
                newBook.publishHouse = value;
            case category:
                newBook.categoryOfBook = Category.valueOf(value);
        }
        return newBook;
    }


}
