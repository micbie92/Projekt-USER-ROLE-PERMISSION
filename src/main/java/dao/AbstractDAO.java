package dao;

import models.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by mbielecki on 10.07.15.
 */
public class AbstractDAO<E extends Entity>{

    Random random = new Random();

    private List<E> list = new ArrayList<E>();

    public List<E> getList() {
        return new ArrayList<E>(list);
    }

    public  Integer add(E entity) {
        if (entity == null) throw new IllegalArgumentException("entity is null");
        if(list.contains(entity)) throw new IllegalArgumentException("entity exist in ds");
        entity.setId(random.nextInt());
        list.add(entity);
        return entity.getId();
    }

    public E find(Integer id) {
        for (E entity : list) {
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        throw new IllegalArgumentException("Entity not found");
    }

    public E findByName(String name){
        for (E entity : list){
            if(entity.getName().equals(name)){
                return entity;
            }
        }
        throw new IllegalArgumentException("Entity not found");
    }

    public void delete(E entity) {
        if(entity == null) throw new IllegalArgumentException("Entity is null");
        list.remove(entity);
    }

    public void edit(E entity){
        if (entity == null)
            throw new IllegalArgumentException();
        for(int i = 0; i < list.size(); ++i)
        {
            if(list.get(i).getId() == entity.getId())
            {
                list.set(i, entity);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

}
