package services.person;

import java.util.List;

import dao.OrangDao;
import models.Orang;

public class PersonServiceImplementation implements PersonService{
    OrangDao orangDao;
    
    public PersonServiceImplementation(OrangDao orangDao) {
        this.orangDao = orangDao;
    }

    @Override
    public void createPerson(Orang orang) {
        // validasi
        if (orang.getNama() == ""){
            // throw exception judul bukunya masih empty
        }
        orangDao.save(orang);
        System.out.println("ANGGOTA TELAH DI TAMBAHKAN");
        
    }

    @Override
    public List<Orang> getAllPerson(){
        return orangDao.findAll();
    }

    @Override
    public Orang getPersonById(Integer id) {
        //IndexOutOfBoundsException: Index 2 out of bounds for length 2
        // validasi id yang diinput misalnya <0 / 0>
        //throw exception errornya
        return orangDao.findById(id);
    }

    @Override
    public void deletePerson(Integer id) {
        orangDao.delete(id);
        System.out.println("ANGGOTA TELAH DI HAPUS");
    }
}