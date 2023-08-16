package services.book;

import java.util.List;
import models.Buku;

public interface BookService {
    //CRUD
    void createBook(Buku buku);
    List<Buku> getAllBook();
    Buku getBookById(Integer id);
    void deleteBook(Integer id);
}