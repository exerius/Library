import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
    Save save = new Save();
    ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("save.dat"));
            save  = (Save) ois.readObject();
        } catch (ClassNotFoundException | IOException ignored) {
        }
        boolean program_runs = true; // переменная, определяющая, когда программа должна прекратиться
        Scanner sc = new Scanner(System.in);//сканер; читает ввод
        while(program_runs){// цикл с меню
            System.out.print("""
                            ================ Who are you? =============
                            
                            1- Administrator
                            2- Manager
                            3- Reader
                            4- Quit
                            
                            """);
            switch (sc.next()){ // выбор варианта
                case "1": //Создание книги или кого-нибудь еще
                    System.out.print("""
                            ================ What are you going to create? =============
                            
                            1- Book
                            2- Manager
                            3- Librarian
                            4- Reader
                            
                            """);

                    switch (sc.next()){
                        case "1":
                            save.books.add(new Book()); //выбираем, что создать
                            break;
                        case "2":
                            save.managers.add(new Manager());
                            break;
                        case "3":
                            save.librarians.add(new Librarian());
                            break;
                        case "4":
                            save.readers.add(new Reader());
                            break;
                        default:
                            break;
                    }
                    break;
                case "2": //Действия менеджера
                    System.out.println("============= Choose manager by id: =============");
                    for (Manager m: save.managers) {
                        System.out.println(m.id+"- "+m);

                    }
                    String id = sc.next();
                    Manager man = null;
                    for (Manager m: save.managers) {
                        if(m.id.equals(id)){
                            man = m;
                        }
                    }
                    System.out.println("""
                            ============= Choose action: =============
                            1- Gather statistics
                            2- Gather statistics by reader
                            3- Gather human`s statistics
                            4- Transform human
                            5- Add book
                            6- Delete book
                            7- Transform book
                            """);
                    switch (sc.next()){
                        case "1":
                            Manager.Helper helper = new Manager.Helper(save.books); // создаем помощника менеджера
                            System.out.println("Books given away:");
                            System.out.println(helper.statistics()[0]);
                            System.out.println("Books left:");
                            System.out.println(helper.statistics()[1]);
                            System.out.println("Enter category");
                            Category ct = Category.valueOf(sc.next());
                            System.out.println("Number of books in this category:");
                            System.out.println(helper.countBooksByCategory(ct));
                            break;
                        case "2":
                            System.out.println("============= Choose reader by id: =============");
                            for (Reader r: save.readers) {
                                System.out.println(r.id+"- "+r);

                            }
                            id = sc.next();
                            Reader reader = null;
                            for (Reader r: save.readers) { //поиск читателя по id
                                if(r.id.equals(id)){
                                    reader = r;
                                }
                            }
                            System.out.println(man.booksByReader(reader));
                            break;
                        case "3":
                            System.out.println("Enter human`s id"); //поиск и вывод данных всех людей с таким id
                            id = sc.next();
                            for (Reader r: save.readers) {
                                if(r.id.equals(id)){
                                    man.statisticsByHuman(r);
                                }
                            }
                            for (Librarian l: save.librarians) {
                                if(l.id.equals(id)){
                                    man.statisticsByHuman(l);
                                }
                            }
                            for (Manager m: save.managers) {
                                if(m.id.equals(id)){
                                    man.statisticsByHuman(m);
                                }
                            }
                            break;
                        case "4":
                            System.out.println("Enter human`s id"); //изменение всехлюдей с таким id
                            id = sc.next();
                            for (Reader r: save.readers) {
                                if(r.id.equals(id)){
                                    man.transformHuman(r);
                                }
                            }
                            for (Librarian l: save.librarians) {
                                if(l.id.equals(id)){
                                   man.transformHuman(l);
                                }
                            }
                            for (Manager m: save.managers) {
                                if(m.id.equals(id)){
                                   man.transformHuman(m);
                                }
                            }
                            break;
                        case "5":
                        case "6":
                            man.interactWithBook(new Book(), save.books); // добавление или удаление книги
                            break;
                        case "7":
                            System.out.println("Enter books`s id");
                            id = sc.next();
                            for (int i = 0; i < save.books.list.size(); i++) {
                                if(save.books.list.get(i).id.equals(id)){
                                    man.transformBook(save.books.list.get(i));
                                }
                            }
                            break;
                    }
                    break;
                case "3": //действия читателя (взять или сдать книгу по id у выбранного библиотекаря)
                    System.out.println("============= Choose reader by id: =============");
                    for (Reader r: save.readers) {
                        System.out.println(r.id+"- "+r);

                    }
                    id = sc.next();
                    Reader reader = null;
                    for (Reader r: save.readers) {
                        if(r.id.equals(id)){
                            reader = r;
                        }
                    }
                    System.out.println("============= Choose librarian to ask for a book or to return it: =============");
                    for (Librarian l: save.librarians) {
                        System.out.println(l.id+"- "+l);

                    }
                    id = sc.next();
                    Librarian libr = null;
                    for (Librarian l: save.librarians) {
                        if(l.id.equals(id)){
                            libr = l;
                        }
                    }
                    System.out.println("Choose book to return or receive");
                    for (Book b: save.books.list) {
                        System.out.println(b.id+"- "+b);

                    }
                    id = sc.next();
                    Book book = null;
                    for (Book b: save.books.list) {
                        if(b.id.equals(id)){
                            book = b;
                        }
                    }
                    reader.interactWithBook(book, save.books);
                    break;
                case "4": //выход из программы
                    program_runs = false;
                    break;
                default:
                    break;
            }

        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("save.dat"));
            oos.writeObject(save);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
