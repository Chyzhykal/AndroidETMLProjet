package etml.app.meetapp.Repositories;

import java.util.Date;
import java.util.List;

import etml.app.meetapp.Entities.CategoryEntitiy;

public interface Repository<Item> {

    void add(Item entity);

    void update(Item entity);

    void remove(Item entity);

    Item getById();

    List<Item> getNewest();

    List<Item> getAll();

    List<Item> getByCategory(CategoryEntitiy category);

    List<Item> getNewerThan(Date date);
}
