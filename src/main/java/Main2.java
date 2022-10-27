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
                            save.books.add(new Book());
                        case "2":
                            save.managers.add(new Manager());
                        case "3":
                            save.librarians.add(new Librarian());
                        case "4":
                            save.readers.add(new Reader());
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
                            3- Add book
                            4- Delete book
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
                            for (Reader r: save.readers) {
                                if(r.id.equals(id)){
                                    reader = r;
                                }
                            }
                            man.booksByReader(reader);
                            break;
                        case "3":
                        case "4":
                            man.interactWithBook(new Book(), save.books);
                            break;
                    }
                    break;
                case "3": //действия читателя
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
                    System.out.println("""
                            ============= Choose action: =============
                            1- Gather statistics
                            2- Gather statistics by reader
                            3- Add book
                            4- Delete book
                            """);
                    switch(sc.next()){

                    }
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
