package Runner;
import Controller.BookDaoImpl;
import DAOinterface.BookDao;
import model.Books;
import java.awt.print.Book;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccessBook {
    public static void main(String[] args) {

        BookDAO bookDAO = new BookDaoImpl();
        System.out.println("---------Inserting book recods-------------");

        ArrayList<Books> BookList = new ArrayList<>();

        Books b1 = new Books();
        b1.setIsbn(120);
        b1.setBookName("Java Book");
        BookList.add(b1);

        Books b2 = new Books();
        b2.setIsbn(300);
        b2.setBookName("Python Book");
        BookList.add(b2);

        Books b3 = new Books();
        b3.setIsbn(365);
        b3.setBookName("JavaScript Book");
        BookList.add(b3);

        Books b4 = new Books();
        b4.setIsbn(256);
        b4.setBookName("SQL Book");
        BookList.add(b4);


        //bookDAO.saveBook(BookList);

        System.out.println("======Display list of all books =====");
        try{

            for(Books cc : bookDAO.getAllBooks()){
                int ISBN = cc.getIsbn();
                String BookName = cc.getBookName();
                System.out.println("=========================");
                System.out.println("ISBN Number : " + ISBN + "and Book name: " + BookName);
            }

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }

        System.out.println("------Book information is updating-----");
        Books Bookupdating = new Books();
        Bookupdating.setIsbn(3);
        Bookupdating.setBookName("Algortihms Book");
        boolean result = bookDAO.updateBook(Bookupdating, 3);
        System.out.println(result);

        boolean a = bookDAO.deleteBook(4);
        if(a == true){
            System.out.println("Record is deleted");
        }else{
            System.out.println("Record is not deleted");
        }
    }
}