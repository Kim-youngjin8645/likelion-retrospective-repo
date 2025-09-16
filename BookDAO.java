package LibraryPractice;

import java.util.ArrayList;
import java.util.List;

//DAO에는 이 메소드들이 어떻게 동작하는지!
public class BookDAO {
    private List<BookDTO> bookList;
    private long nextBookId;

    public BookDAO() {
        this.bookList = new ArrayList<>();
        nextBookId = 1;
    }
    //도서추가.
    public void addBook(BookDTO book) {
        book.setId(nextBookId);
        bookList.add(book);
        nextBookId++;
    }
    //전체조회
    public List<BookDTO> getAllBooks() {
        return new ArrayList<>(bookList);
    }
    //제목으로 도서 검색하기.
    public List<BookDTO> searchBooks(String title) {
        List<BookDTO> result=new ArrayList<>();
        for(BookDTO book:bookList){
            if(book.getTitle().equals(title)){//순회한 후 제목이 맞니?
                result.add(book);//결과도출
            }
        }
        return result;
    }
    //도서 대여
    public boolean rentBook(String title, boolean isRented){
        for(BookDTO book:bookList){//전체순회
            if(book.getTitle().equals(title)){//제목발견.
                book.setRented(isRented);
                return true;
            }
        }
        return false; //책을못찾음.

    }
    //도서삭제.
    public boolean removeBook(String title){
        for(int i =0;i<bookList.size();i++){
            if(bookList.get(i).getTitle().equals(title)){
                bookList.remove(i);
                return true;
            }
        }
        return false;
    }


}
