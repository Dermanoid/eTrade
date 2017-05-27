package ge.mziuri.dao;

import ge.mziuri.model.Item;
import ge.mziuri.model.Trade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TradeDAOImpl implements TradeDAO {

    private Connection con;

    private PreparedStatement pstmt;

    public TradeDAOImpl() {
        con = DatabaseUtil.getConnection();
    }
    
    @Override
    public void trade(Item item1, Item item2) {
        int userId1 = item1.getUser().getId();
        int userId2 = item2.getUser().getId();
        try {
            pstmt = con.prepareStatement("UPDATE item SET systemuser_id = ? WHERE id = ?");
            pstmt.setInt(1, userId2);
            pstmt.setInt(2, item1.getId());
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("UPDATE item SET systemuser_id = ? WHERE id = ?");
            pstmt.setInt(1, userId1);
            pstmt.setInt(2, item2.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }
    }
    
    @Override
    public void addOffer(int item1Id, int item2Id) {
        try {
            pstmt = con.prepareStatement("INSERT INTO trade (send_item_id, received_item_id) VALUES (?, ?)");
            pstmt.setInt(1, item1Id);
            pstmt.setInt(2, item2Id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }
    }
    
    @Override
    public List<Trade> getAllNotTradedTrades(int userId) {
        List<Trade> trades = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT trade.send_item_id, trade.received_item_id FROM trade INNER JOIN item ON trade.received_item_id = item.id WHERE item.owner_id = ?");
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int sendId = rs.getInt("send_item_id");
                int receiveId = rs.getInt("received_item_id");
                ItemDAO itemDAO = new ItemDAOImpl();
                Item sendItem = itemDAO.getItembyID(sendId);
                itemDAO = new ItemDAOImpl();
                Item receiveItem = itemDAO.getItembyID(receiveId);
                Trade trade = new Trade();
                trade.setSendItem(sendItem);
                trade.setReceiveItem(receiveItem);
                trades.add(trade);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }
        return trades;
    }
}
