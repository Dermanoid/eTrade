package ge.mziuri.dao;

import ge.mziuri.model.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import util.StringUtil;

public class SearchDAOImpl implements SearchDAO {

    private Connection con;

    private PreparedStatement pstmt;

    public SearchDAOImpl() {
        con = DatabaseUtil.getConnection();
    }

    @Override
    public Item item(String Name) {
        try {
            pstmt = con.prepareStatement("SELECT * FROM item  WHERE NAME=?");
            pstmt.setString(1, Name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Item item = new Item();
                item.setName(rs.getString("name"));
                String m = rs.getString("Photo");
                StringUtil st = new StringUtil();
                item.setPhoto(st.getStringListFromString(m));
                item.setPoint(rs.getInt("Point"));
                return item;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
