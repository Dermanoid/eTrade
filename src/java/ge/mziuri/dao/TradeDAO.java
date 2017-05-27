 package ge.mziuri.dao;

import ge.mziuri.model.Item;
import ge.mziuri.model.Trade;
import java.util.List;

public interface TradeDAO {

    void trade(Item item1, Item item2);
    
    void addOffer(int item1Id, int item2Id);
    
    List<Trade> getAllNotTradedTrades(int userId);
}
