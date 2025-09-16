package LibraryPractice;

import java.util.List;
//세부사항기술하기?
public class Library {
    private BookDAO bookDAO;
    public Library() {
        this.bookDAO = new BookDAO();
    }

    public void addBook(String author, String title) {
        BookDTO book = new BookDTO(0, author, title, false);
        bookDAO.addBook(book);
        System.out.println("도서 추가");
    }

    public void listAllBooks() {
        List<BookDTO> books = bookDAO.getAllBooks();
        for (BookDTO bookDTO : books) {//전체순회
            System.out.println(bookDTO.toString());
        }
    }

    public void searchBooks(String title) {
        List<BookDTO> allBooks = bookDAO.getAllBooks();
        if (allBooks.isEmpty()) {
            System.out.println("no books");
        }
        List<BookDTO> foundBooks = bookDAO.searchBooks(title);
        if (foundBooks.isEmpty()) {
            System.out.println("no books");
        } else {
            for (BookDTO book : foundBooks) {
                System.out.println(book);
            }
        }

    }

    public void rentBook(String title) {//도서대여 조건
        List<BookDTO> books = bookDAO.searchBooks(title);
        if (books.isEmpty()) {
            System.out.println("no books");
        }
        BookDTO book = books.get(0);//순회후 찾은 도서
        if(book.isRented()){
            System.out.println("이미 대여중인도서");
        }
        else{
            bookDAO.rentBook(title,true);
            System.out.println(title+"대여완료");
        }


    }

    public void returnBook (String title){
        List<BookDTO> books = bookDAO.searchBooks(title);
        if (books.isEmpty()) {
            System.out.println("no books");
            return;
        }
        BookDTO book = books.get(0);
        if(!book.isRented()){
            System.out.println("현재 반납되어있는도서");
        }
        else{
            bookDAO.rentBook(title,false);
            System.out.println(title+"반납완료");
        }

        }

    public void removeBook(String title) {
        List<BookDTO> books = bookDAO.searchBooks(title);
         if (books.isEmpty()) {
             System.out.println("no books");
             return;
         }
         BookDTO book = books.get(0);
         if(book.isRented()){
             System.out.println("대여중인 도서는 삭제 불가능합니다.");
         }
         else {
             boolean removeBook = bookDAO.removeBook(title);
             if(removeBook){
                 System.out.println("도서가 성공적으로 삭제되었습니다.");
             }
             else {
                 System.out.println("도서 삭제에 실패했습니다.");
             }
         }

    }
}







