package dao;

import java.util.ArrayList;
import java.util.List;

import models.Pinjam;
import services.BaseDao;

public class PinjamDao implements BaseDao<Pinjam, Integer>{
    List<Pinjam> borrows = new ArrayList<>();

    @Override
    public void delete(Integer id) {
        borrows.remove(id - 1);   
    }

    @Override
    public List<Pinjam> findAll() {
        return this.borrows;
    }

    @Override
    public Pinjam findById(Integer id) {
        return this.borrows.get(id - 1);
    }

    @Override
    public void save(Pinjam data) {
        borrows.add(data);
    }

    @Override
    public void update(Integer id, Pinjam data) {
        borrows.set(id - 1, data);
    }
}