/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.dao;

import ge.mziuri.model.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author C4C2
 */
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
            pstmt = con.prepareStatement("UPDATE item SET ststemuser_id = ? WHERE id = ?");
            pstmt.setInt(1, userId2);
            pstmt.setInt(2, item1.getId());
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("UPDATE item SET ststemuser_id = ? WHERE id = ?");
            pstmt.setInt(1, userId1);
            pstmt.setInt(2, item2.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
