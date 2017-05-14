package ge.mziuri.dao;

import ge.mziuri.model.Item;
import java.util.List;

public interface ItemDAO {

    void addItem(Item item);

    List<Item> getAllItem();

    List<Item> getAllItemByName(String name);

    List<Item> GetAllMyItems(int id);
};
