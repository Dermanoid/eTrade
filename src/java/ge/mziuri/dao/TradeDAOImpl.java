/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.dao;

import ge.mziuri.model.Item;

/**
 *
 * @author C4C2
 */
public class TradeDAOImpl implements TradeDAO {

    @Override
    public void trade(Item item1, Item item2) {
        Item item3 = null;
        item3.setUser(item1.getUser());
        item1.setUser(item2.getUser());
        item2.setUser(item2.getUser());

    }

}
