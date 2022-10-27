import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Human implements Serializable { //Класс человека (абстрактный)
    public String name, surname, patronymic, address; //публичне данные
    protected String id; // скрытые данные
    protected static ArrayList<String> listOfIds = new ArrayList<String>(); // список всех id людей
    public Human(String name, String surname, String patronymic, String address, String id){ //конструктор
            if(!listOfIds.contains(id)){
                this.address = address;
                this.id = id;
                this.name = name;
                this.surname = surname;
                this.patronymic = patronymic;
                listOfIds.add(id);
            }
    }
    public Human(Human human){ // другой конструктор
        this.address = human.address;
        this.id = human.id;
        this.name = human.name;
        this.patronymic = human.patronymic;
        this.surname = human.surname;

    }
    public Human(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию");
        this.surname = scanner.next();
        System.out.println("Введите имя");
        this.name = scanner.next();
        System.out.println("Введите отчество");
        this.name = scanner.next();
        System.out.println("Введите id");
        this.name = scanner.next();
        System.out.println("Введите адрес");
        this.name = scanner.next();

    }
    public abstract void interactWithBook(Book book, Books list); // Данный метод описывает взаимодействие с книгой и списком книг
    public abstract void interactWithBook(Book book, Books list, Human human);
    public void showData(){ // метод вывода информации о себе
        System.out.println(name);
        System.out.println(surname);
        System.out.println(patronymic);
        System.out.println(address);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }

    public abstract Human clone(); // абстрактный метод самокопирования
}
