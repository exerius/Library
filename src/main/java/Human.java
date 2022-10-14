import java.util.ArrayList;

public abstract class Human { //Класс человека
    public String name, surname, patronymic, address;
    protected String id;
    protected static ArrayList<String> listOfIds = new ArrayList<String>();
    public Human(String name, String surname, String patronymic, String address, String id){
            if(!listOfIds.contains(id)){
                this.address = address;
                this.id = id;
                this.name = name;
                this.surname = surname;
                this.patronymic = patronymic;
                listOfIds.add(id);
            }
    }
    public Human(Human human){
        this.address = human.address;
        this.id = human.id;
        this.name = human.name;
        this.patronymic = human.patronymic;
        this.surname = human.surname;

    }
    public abstract void interactWithBook(Book book, Books list); // Данный метод описывает взаимодействие с книгой и списком книг
    public void showData(){
        System.out.println(name);
        System.out.println(surname);
        System.out.println(patronymic);
        System.out.println(address);
    }

    public abstract Human clone();
}
