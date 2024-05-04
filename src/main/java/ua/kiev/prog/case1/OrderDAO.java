package ua.kiev.prog.case1;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import ua.kiev.prog.shared.Client;
import ua.kiev.prog.shared.Goods;
import ua.kiev.prog.shared.Orders;



import java.util.List;

// CRUD
public interface OrderDAO {
    void createOrderTable();
    void addOrder(int clientId, String clientName, float orderSum, String orderDetails);
    List<Orders> getAllOrder();
    long count();
}
