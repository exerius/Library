import java.util.Scanner;

public class Main { //рабочий класс
    public static void main(String[] args){ //рабочий метод
        Books books = new Books(); //список книг, с которым работаем(пока пустой)
        Book temp_book; // временная книга, которую мы иногда создаем
        boolean program_runs = true; // переменная, определяющая, когда программа должна прекратиться
        Human temp_human = null; // временный человек; появляется для выполнения операций
        Scanner sc = new Scanner(System.in);//сканер; читает ввод
        while(program_runs){// цикл с меню
                System.out.print("""
                            ================ Menu =============
                            
                            1- Add new book
                            2- Delete a book
                            3- Find a book
                            4- Gather statistics
                            5- Take book
                            6- Exit
                            
                            """);
                switch (sc.next()){ // выбор варианта
                    case "1": //добавление книги
                        temp_human = new Manager("Ivanov", "Ivan", // создаем менеджера, который добавит книгу
                                "Ivanovich", "temp", "000");
                        System.out.println("Enter book id"); // сбор характеристик книги
                        String id = sc.next();
                        System.out.println("Enter name of book");
                        String name  = sc.next();
                        System.out.println("Enter book`s author name");
                        String author = sc.next();
                        System.out.println("Enter book`s publish house");
                        String publishHouse = sc.next();
                        System.out.println("Enter book`s publisher");
                        String publisher = sc.next();
                        System.out.println("Enter book`s publish year");
                        int year = Integer.parseInt(sc.next());
                        System.out.println("Enter book`s genre");
                        Category genre = Category.valueOf(sc.next());
                        temp_human.interactWithBook(new Book(id, name, author, publishHouse, publisher, year, genre), books); // менеджер добавляет книгу
                        break;
                    case "2": //удаление книги
                        temp_human = new Librarian("Ivanov", "Ivan",
                                "Ivanovich", "temp", "000"); // создаем библиотекаря, который найдет книгу
                        System.out.println("Enter book`s id");
                        id = sc.next(); //ищем книгу, котору будем удалять по id
                        temp_book = ((Librarian) temp_human).findBookById(id, books); //временная книга, для удаления из списка
                        temp_human = new Librarian("Ivanov", "Ivan",
                                "Ivanovich", "temp", "000"); // создаем менеджера, который удалит книгу
                        temp_human.interactWithBook(temp_book, books);
                        break;
                    case "3": //поиск книги по id
                        temp_human = new Librarian("Ivanov", "Ivan",
                                "Ivanovich", "temp", "000"); // создаем библиотекаря, который найдет книгу
                        System.out.println("Enter book`s id");
                        id = sc.next();
                        System.out.println(((Librarian) temp_human).findBookById(id, books));
                        break;
                    case "4": // сбор статистики по книгам
                        temp_human = new Manager("Ivanov", "Ivan",
                            "Ivanovich", "temp", "000"); // создаем менеджера, который соберет статистику
                        Manager.Helper helper = new Manager.Helper(books); // создаем помощника менеджера
                        System.out.println("Книг выдано:");
                        System.out.println(helper.statistics()[0]);
                        System.out.println("Книг осталось:");
                        System.out.println(helper.statistics()[1]);
                        System.out.println("Введите категорию");
                        Category ct = Category.valueOf(sc.next());
                        System.out.println("Количество книг данной категории:");
                        System.out.println(helper.countBooksByCategory(ct));
                    case "5": // взять книгу
                        temp_human = new Librarian("Ivanov", "Ivan",
                                "Ivanovich", "temp", "000"); //создаем библиотекаря, который найжет книгу
                        System.out.println("Enter book`s id");
                        id = sc.next();
                        Book book =  ((Librarian) temp_human).findBookById(id, books);
                        temp_human = new Reader("Ivanov", "Ivan",
                                "Ivanovich", "temp", "000"); //создаем читателя, который воьметкнигу
                        temp_human.interactWithBook(book, books);
                    case "6": //выход из программы
                        program_runs = false;
                        break;
                    default:
                        break;
                }

        }
    }
}
