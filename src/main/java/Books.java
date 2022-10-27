import java.io.Serializable;
import java.util.ArrayList;

public class Books implements Serializable { //Книги, с которыми работаем
    private ArrayList<Book> list; //список книг
    int handedOut; //кол-во выданных книг
    public Books(){
        list = new ArrayList<Book>();
    } //конструктор
    public void add(Book book){ // добавление книги
        if(!list.contains(book)){
            list.add(book);
        }
        else {
            System.out.println("This book already exists");
        }
    }
    public void remove(Book book){
        list.remove(book);
    } // удаление книги
    public boolean contains(Book book){
        return list.contains(book);
    } // проверка существования
    public int booksByCategory(Category category){ // подсчет кол-ва книг по категории
        ArrayList<Book> tempList = new ArrayList<Book>(list);
        tempList.removeIf(book -> (book.categoryOfBook != category));
        return tempList.size();
    }
    public int size(){
        return list.size();
    } // вычисление собственного размера
    public Book findById(String id){ // поиск книги по id (для библиотекаря)
        for (Book book: list) {
            if(book.id.equals(id)){
                return book;
            }
        }
        return null;
    }

}
