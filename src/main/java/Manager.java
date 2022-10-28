import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends Human { //Класс менеджера
    public Manager(String name, String surname, String patronymic, String address, String id) { //конструктор
        super(name, surname, patronymic, address, id);
    }
    public Manager(Human human){ //другой конструктор
        super(human);
    }
    public Manager(){super();}
    enum Attributes  {name, author, publishHouse, publisher, category}  //внутренне перечисление
    public static class Helper{ //внутренний класс-помощник для сбора статистики по списку книг
        Books list;
        public Helper(Books books){ //конструктор
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
    public void interactWithBook(Book book, Books list) { // реализация абстрактного метода класса-родителя
        if(list.contains(book)){
            list.remove(book);
        }
        else {
            list.add(book);
        }
    }

    @Override
    public void interactWithBook(Book book, Books list, Human human) {

    }

    public ArrayList<Book> booksByReader(Reader reader){ //получение информации о книгах читателя
       return reader.reportOnBooks();
    }
    public void transformBook(Book book){ // изменение атрибута книги
        Scanner sc = new Scanner(System.in);
        System.out.println("Какой атрибут подлежит изменению?");
        Attributes attr = Attributes.valueOf(sc.next());
        System.out.println("Введите новое значение");
        Book newHuman = new Book(book);
        switch (attr){
            case author:
                book.author = sc.next();
                break;
            case name:
                book.name = sc.next();
                break;
            case  publisher:
                book.publisher = sc.next();
                break;
            case publishHouse:
                book.publishHouse = sc.next();
                break;
            case category:
                book.categoryOfBook = Category.valueOf(sc.next());
                break;
        }
    }

    @Override
    public void showData() { //вывод информации о себе
        super.showData();
        System.out.println(id);
    }

    public void statisticsByHuman(Human human){ //получение данных о друг человеке
        human.showData();
   }
   public void transformHuman(Human human){ // преобразование человека
       Scanner sc = new Scanner(System.in);
       System.out.println("Какой атрибут подлежит изменению?");
       String attr = sc.next();
       System.out.println("Введите новое значение");
       switch (attr){
           case "name":
               human.name = sc.next();
               break;
           case "surname":
               human.surname = sc.next();
               break;
           case  "patronymic":
               human.patronymic = sc.next();
               break;
           case "adress":
               human.address = sc.next();
               break;
       }
   }}
