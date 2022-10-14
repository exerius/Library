import java.util.Scanner;

public class Manager extends Human { //Класс менеджера
    public Manager(String name, String surname, String patronymic, String address, String id) {
        super(name, surname, patronymic, address, id);
    }
    public Manager(Human human){
        super(human);
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
    public void interactWithBook(Book book, Books list) {
        if(list.contains(book)){
            list.remove(book);
        }
        else {
            list.add(book);
        }
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
    public void showData() {
        super.showData();
        System.out.println(id);
    }

    @Override
    public Human clone() {
        return new Manager(this);
    }

    public void statisticsByHuman(Human human){
        human.showData();
   }
   public Human transformHuman(Human human){
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
