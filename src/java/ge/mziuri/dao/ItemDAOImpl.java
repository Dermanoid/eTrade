package ge.mziuri.dao;

import ge.mziuri.model.Item;
import ge.mziuri.util.StringUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    private Connection con;

    private PreparedStatement pstmt;

    public ItemDAOImpl() {
        con = DatabaseUtil.getConnection();
    }

    @Override
    public void addItem(Item item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Item> getAllItem() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Item> getAllItemByName(String name) {
        try {
            pstmt = con.prepareStatement("SELECT * FROM item  WHERE NAME=?");
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Item item = new Item();
                item.setName(rs.getString("name"));
                String m = rs.getString("Photo");
                item.setPhotoes(StringUtil.getStringListFromString(m));
                item.setPoint(rs.getInt("Point"));
//                return item;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }
        return null;
    }
}
