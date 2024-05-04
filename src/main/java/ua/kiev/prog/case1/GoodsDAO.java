package ua.kiev.prog.case1;

import ua.kiev.prog.shared.Client;
import ua.kiev.prog.shared.Goods;

import java.util.List;

// CRUD
public interface GoodsDAO {
    void createGoodsTable();
    void addGoods(String type, int quantity);
    List<Goods> getAllGoods();
    long count();
}
