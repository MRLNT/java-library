package dao;

import java.util.ArrayList;
import java.util.List;

import models.Buku;
import services.BaseDao;

public class BukuDao implements BaseDao<Buku, Integer>{
    List<Buku> books = new ArrayList<>();

    @Override
    public void delete(Integer id) {
        books.remove(id - 1);
    }

    @Override
    public List<Buku> findAll() {
        return this.books;
    }

    @Override
    public Buku findById(Integer id) {
        return this.books.get(id - 1);
    }

    @Override
    public void save(Buku data) {
        books.add(data);
    }

    @Override
    public void update(Integer id, Buku data) {
        books.set(id - 1, data);
    }
}