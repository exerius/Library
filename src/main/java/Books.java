import java.util.ArrayList;

public class Books{ //Книги, с которыми работаем
    private ArrayList<Book> list;
    int handedOut;
    public Books(){
        list = new ArrayList<Book>();
    }
    public void add(Book book){
        if(!list.contains(book)){
            list.add(book);
        }
        else {
            System.out.println("This book already exists");
        }
    }
    public void remove(Book book){
        list.remove(book);
    }
    public boolean contains(Book book){
        return list.contains(book);
    }
    public int booksByCategory(Category category){
        ArrayList<Book> tempList = new ArrayList<Book>(list);
        tempList.removeIf(book -> (book.categoryOfBook != category));
        return tempList.size();
    }
    public int size(){
        return list.size();
    }
}
