package ge.mziuri.dao;

import ge.mziuri.model.Item;
import ge.mziuri.model.ProdType;
import ge.mziuri.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ItemDAOimpl {

    private Connection con;

    private PreparedStatement pstmt;

    public ItemDAOimpl() {
        con = DatabaseUtil.getConnection();
    }

    public void item(int id, User user, List photo, String name, int point, ProdType type) throws SQLException {
        try {
            pstmt = con.prepareStatement("SELECT * FROM item");
            pstmt.setInt(1, id);
            pstmt.setInt(2, user.getId());
            pstmt.setString(3, "photo");  // ესარი photo_ს მაგივრად უნდა ჩაწერო    (ფრჩილებში იმიტოა რო არ გააწითლოს)
            pstmt.setString(4, name);
            pstmt.setInt(5, point);
            pstmt.setString(6, type.name());
            ResultSet rs = pstmt.executeQuery();
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
