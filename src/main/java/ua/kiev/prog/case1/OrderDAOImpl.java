package ua.kiev.prog.case1;

import ua.kiev.prog.shared.Client;
import ua.kiev.prog.shared.Goods;
import ua.kiev.prog.shared.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class OrderDAOImpl implements OrderDAO {

    private final Connection conn;

    public OrderDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void createOrderTable() {
        try {
            try (Statement st = conn.createStatement()) {
                st.execute("DROP TABLE IF EXISTS Orders");
                st.execute("CREATE TABLE Orders(orderId INT NOT NULL AUTO_INCREMENT PRIMARY KEY, clientId INT, "
                        + "clientName VARCHAR(20), orderSum INT, orderDETAILS VARCHAR(100))");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void addOrder(int clientId, String clientName, float orderSum, String orderDetails) {
        try {
            try (PreparedStatement st = conn.prepareStatement("INSERT INTO Orders (clientID, clientName, orderSum, orderDetails) VALUES(?, ?, ? , ?)")) {
                st.setInt(1, clientId);
                st.setString(2, clientName);
                st.setFloat(3, orderSum);
                st.setString(4, orderDetails);
                st.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Orders> getAllOrder() {
        List<Orders> res = new ArrayList<>();

        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT * FROM Orders")) {
                    while (rs.next()) {
                        Orders order = new Orders();

                        order.setOrderId(rs.getInt(1));
                        order.setOrderClientId(rs.getInt(2));
                        order.setOrderClientName(rs.getString(3));
                        order.setOrderSum(rs.getFloat(4));
                        order.setOrderDetails(rs.getString(5));
                        res.add(order);
                    }
                }
            }

            return res;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public long count() {
        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM Orders")) {
                    if (rs.next())
                        return rs.getLong(1);
                    else
                        throw new RuntimeException("Count failed");
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
