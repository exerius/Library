import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Books books = new Books();
        Book temp_book;
        boolean program_runs = true;
        Human temp_human = null;
        Scanner sc = new Scanner(System.in);
        enum variants{
            Reader(1),
            Librarian(2),
            Manager(3);
            private int code;
            private variants(int code){
                this.code = code;
            }
            public int getCode(){ return code;}
        }
        variants user_profession;
        while(program_runs){
                System.out.print("""
                            ================Who are you? =============
                            
                            1- Add new book
                            2- Delete a book
                            3- Find a book
                            4- Gather statistics
                            5- Exit
                            
                            """);
                switch (sc.next()){
                    case "1":
                        temp_human = new Manager("Ivanov", "Ivan",
                                "Ivanovich", "temp", "000");
                        System.out.println("Enter book id");
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
                        temp_human.interactWithBook(new Book(id, name, author, publishHouse, publisher, year, genre), books);
                        break;
                    case "2":
                        temp_human = new Librarian("Ivanov", "Ivan",
                                "Ivanovich", "temp", "000");
                        System.out.println("Enter book`s id");
                        id = sc.next();
                        temp_book = ((Librarian) temp_human).findBookById(id, books);
                        temp_human = new Librarian("Ivanov", "Ivan",
                                "Ivanovich", "temp", "000");
                        temp_human.interactWithBook(temp_book, books);
                        break;
                    case "3":
                        temp_human = new Librarian("Ivanov", "Ivan",
                                "Ivanovich", "temp", "000");
                        System.out.println("Enter book`s id");
                        id = sc.next();
                        System.out.println(((Librarian) temp_human).findBookById(id, books));
                        break;
                    case "4":
                        temp_human = new Manager("Ivanov", "Ivan",
                            "Ivanovich", "temp", "000");
                        Manager.Helper helper = new Manager.Helper(books);
                        System.out.println("Книг выдано:");
                        System.out.println(helper.statistics()[0]);
                        System.out.println("Книг осталось:");
                        System.out.println(helper.statistics()[1]);
                        System.out.println("Введите категорию");
                        Category ct = Category.valueOf(sc.next());
                        System.out.println("Количество книг данной категории:");
                        System.out.println(helper.countBooksByCategory(ct));
                    case "5":
                        program_runs = false;
                        break;
                    default:
                        break;
                }

        }
    }
}
