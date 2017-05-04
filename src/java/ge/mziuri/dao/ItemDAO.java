package ge.mziuri.dao;

import ge.mziuri.model.Item;
import ge.mziuri.model.ProdType;
import ge.mziuri.model.User;
import java.util.List;

public interface ItemDAO {
    
    Item item (int id, User user, List photo, String name, int point, ProdType type);
};



