package services.borrow;

import java.util.List;

import dao.PinjamDao;
import models.Pinjam;

public class BorrowServiceImplementation implements BorrowService{
    PinjamDao pinjamDao;

    public BorrowServiceImplementation(PinjamDao pinjamDao) {
        this.pinjamDao = pinjamDao;
    }

    @Override
    public void createBorrow(Pinjam pinjam) {
        //validasi
        pinjamDao.save(pinjam);
    }

    @Override
    public void deleteBorrow(Integer id) {
        pinjamDao.delete(id);
        System.out.println("BUKU TELAH DIKEMBALIKAN");
    }

    @Override
    public List<Pinjam> getAllBorrow() {
        return pinjamDao.findAll();
    }

    @Override
    public Pinjam getBorrowById(Integer id) {
        return pinjamDao.findById(id);
    }
}
