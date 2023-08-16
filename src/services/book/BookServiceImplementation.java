package services.book;

import java.util.List;

import dao.BukuDao;
import models.Buku;

public class BookServiceImplementation implements BookService{
    BukuDao bukuDao;
    
    public BookServiceImplementation(BukuDao bukuDao) {
        this.bukuDao = bukuDao;
    }

    @Override
    public void createBook(Buku buku) {
        // validasi
        if (buku.getJudul() == ""){
            // throw exception judul bukunya masih empty
        }
        bukuDao.save(buku);
        System.out.println("BUKU TELAH DI TAMBAHKAN");
        
    }

    @Override
    public List<Buku> getAllBook(){
        return bukuDao.findAll();
    }

    @Override
    public Buku getBookById(Integer id) {
        //IndexOutOfBoundsException: Index 2 out of bounds for length 2
        // validasi id yang diinput misalnya <0 / 0>
        //throw exception errornya
        return bukuDao.findById(id);
    }

    @Override
    public void deleteBook(Integer id) {
        bukuDao.delete(id);
        System.out.println("BUKU TELAH DI HAPUS");
    }
}