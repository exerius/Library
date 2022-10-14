import java.util.Scanner;

public class Manager extends Human { //Класс менеджера
    public Manager(String name, String surname, String patronymic, String address, String id) { //конструктор
        super(name, surname, patronymic, address, id);
    }
    public Manager(Human human){ //другой конструктор
        super(human);
    }
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
    public Book[] booksByReader(Reader reader){ //получение информации о книгах читателя
       return reader.reportOnBooks();
    }
    public Book transformBook(Book book){ // изменение атрибута книги
        Scanner sc = new Scanner(System.in);
        System.out.println("Какой атрибут подлежит изменению?");
        Attributes attr = Attributes.valueOf(sc.next());
        System.out.println("Введите новое значение");
        String value = sc.next();
        Book newHuman = new Book(book);
        switch (attr){
            case author:
                newHuman.author = value;
            case name:
                newHuman.name = value;
            case  publisher:
                newHuman.publisher = value;
            case publishHouse:
                newHuman.publishHouse = value;
            case category:
                newHuman.categoryOfBook = Category.valueOf(value);
        }
        return newHuman;
    }

    @Override
    public void showData() { //вывод информации о себе
        super.showData();
        System.out.println(id);
    }

    @Override
    public Human clone() { // клонирование (реализация абстрактного метода)
        return new Manager(this);
    }

    public void statisticsByHuman(Human human){ //получение данных о друг человеке
        human.showData();
   }
   public Human transformHuman(Human human){ // преобразование человека
       Scanner sc = new Scanner(System.in);
       System.out.println("Какой атрибут подлежит изменению?");
       String attr = sc.next();
       System.out.println("Введите новое значение");
       String value = sc.next();
       Human newHuman = human.clone();
       switch (attr){
           case "name":
               newHuman.name = value;
           case "surname":
               newHuman.surname = value;
           case  "patronymic":
               newHuman.patronymic = value;
           case "adress":
               newHuman.address = value;
       }
       return newHuman;
   }}
