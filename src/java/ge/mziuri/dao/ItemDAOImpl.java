package ge.mziuri.dao;

import ge.mziuri.model.Item;
import ge.mziuri.model.User;
import ge.mziuri.util.StringUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    private final Connection con;

    private PreparedStatement pstmt;

    public ItemDAOImpl() {
        con = DatabaseUtil.getConnection();
    }

    @Override
    public void addItem(Item item) {
        try {
            pstmt = con.prepareStatement("INSERT INTO ITEM (name,description,photoes,owner_id,point,type)  VALUES (?,?,?,?,?,?)");
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getDescription());
            pstmt.setString(3, StringUtil.getStringFromList(item.getPhotoes()));
            pstmt.setInt(4, item.getUser().getId());
            pstmt.setInt(5, item.getPoint());
            pstmt.setString(6, item.getType().name());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }
    }

    @Override
    public List<Item> getAllItem(int id) {
        List<Item> items = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM item WHERE owner_id <> ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setPhotoes(StringUtil.getStringListFromString(rs.getString("photoes")));
                user.setId(rs.getInt("owner_id"));
                item.setUser(user);
                item.setPoint(rs.getInt("Point"));
                items.add(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }
        return items;
    }

    @Override
    public List<Item> getAllItemByName(String name, int id) {
        List<Item> items = new ArrayList<>();

        try {
            pstmt = con.prepareStatement("SELECT * FROM item WHERE name LIKE ? AND owner_id <> ?");
            pstmt.setString(1, "%" + name + "%");
            pstmt.setInt(2, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setPhotoes(StringUtil.getStringListFromString(rs.getString("photoes")));
                user.setId(rs.getInt("owner_id"));
                item.setUser(user);
                item.setPoint(rs.getInt("Point"));
                items.add(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }
        return items;
    }

    @Override
    public List<Item> getAllMyItems(int id) {

        List<Item> items = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM item WHERE owner_id=?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setPhotoes(StringUtil.getStringListFromString(rs.getString("photoes")));
                user.setId(rs.getInt("owner_id"));
                item.setUser(user);
                item.setPoint(rs.getInt("Point"));
                items.add(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }
        return items;

    }

    @Override
    public void deleteItem(int id) {
        try {
            pstmt = con.prepareStatement("DELETE FROM ITEM WHERE id=?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }
    }

    @Override
    public void detailedItem(int id) {
        try {
            Item item = new Item();
            pstmt = con.prepareStatement("SELECT * FROM ITEM WHERE id=?");
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getDescription());
            pstmt.setString(3, StringUtil.getStringFromList(item.getPhotoes()));
            pstmt.setInt(4, item.getUser().getId());
            pstmt.setInt(5, item.getPoint());
            pstmt.setString(6, item.getType().name());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }

    }

    @Override
    public Item getItembyID(int id) {

        try {
            pstmt = con.prepareStatement("SELECT * FROM item WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setPhotoes(StringUtil.getStringListFromString(rs.getString("photoes")));
                user.setId(rs.getInt("owner_id"));
                item.setUser(user);
                item.setPoint(rs.getInt("Point"));
                return item;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }
        return null;
    }
}
