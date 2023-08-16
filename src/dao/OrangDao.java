package dao;

import java.util.ArrayList;
import java.util.List;

import models.Orang;
import services.BaseDao;

public class OrangDao implements BaseDao<Orang, Integer>{
    List<Orang> persons = new ArrayList<>();

    @Override
    public void delete(Integer id) {
        persons.remove(id - 1);
    }

    @Override
    public List<Orang> findAll() {
        return this.persons;
    }

    @Override
    public Orang findById(Integer id) {
        return this.persons.get(id - 1);
    }

    @Override
    public void save(Orang data) {
        persons.add(data);
    }

    @Override
    public void update(Integer id, Orang data) {
        persons.set(id - 1, data);
    }
}