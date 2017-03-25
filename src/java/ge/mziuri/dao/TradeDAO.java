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
public interface TradeDAO {

    void trade(Item item1, Item item2);
}
