package services.borrow;

import models.Pinjam;
import java.util.List;

public interface BorrowService {
    //CRUD
    void createBorrow(Pinjam pinjam);
    List<Pinjam> getAllBorrow();
    Pinjam getBorrowById(Integer id);
    void deleteBorrow(Integer id);
}