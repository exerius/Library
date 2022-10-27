import java.io.Serializable;
import java.util.ArrayList;

public class Save implements Serializable {
    public ArrayList<Manager> managers = new ArrayList<Manager>();
    public ArrayList<Librarian> librarians = new ArrayList<Librarian>();
    public ArrayList<Reader> readers = new ArrayList<Reader>();
    public Books books = new Books();
}
