package ge.mziuri.dao;

import ge.mziuri.model.Item;
import java.util.List;

public interface ItemDAO {

    void addItem(Item item);

    List<Item> getAllItem(int id);

    List<Item> getAllItemByName(String name, int id);

    Item getItembyID(int id);

    List<Item> getAllMyItems(int id);

    void deleteItem(int id);

    void detailedItem(int id);
};
