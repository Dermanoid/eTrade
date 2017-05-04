package ge.mziuri.dao;

import ge.mziuri.model.ProdType;
import ge.mziuri.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import ge.mziuri.util.StringUtil;

public class ItemDAOImpl {

    private Connection con;

    private PreparedStatement pstmt;

    public ItemDAOImpl() {
        con = DatabaseUtil.getConnection();
    }

    public void item(int id, User user, List<String> photo, String name, int point, ProdType type) throws SQLException {
        try {
            pstmt = con.prepareStatement("SELECT * FROM item");
            pstmt.setInt(1, id);
            pstmt.setInt(2, user.getId());
            pstmt.setString(3, StringUtil.getStringFromList(photo));
            pstmt.setString(4, name);
            pstmt.setInt(5, point);
            pstmt.setString(6, type.name());
            ResultSet rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(con);
        }
    }
}
