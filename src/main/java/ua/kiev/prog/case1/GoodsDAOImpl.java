package ua.kiev.prog.case1;

import ua.kiev.prog.shared.Client;
import ua.kiev.prog.shared.Goods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAOImpl implements GoodsDAO {

    private final Connection conn;

    public GoodsDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void createGoodsTable() {
        try {
            try (Statement st = conn.createStatement()) {
                st.execute("DROP TABLE IF EXISTS Goods");
                st.execute("CREATE TABLE Goods (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, type VARCHAR(20) NOT NULL, quantity INT)");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void addGoods(String type, int quantity) {
        try {
            try (PreparedStatement st = conn.prepareStatement("INSERT INTO Goods (type, quantity) VALUES(?, ?)")) {
                st.setString(1, type);
                st.setInt(2, quantity);
                st.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Goods> getAllGoods() {
        List<Goods> res = new ArrayList<>();

        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT * FROM Goods")) {
                    while (rs.next()) {
                        Goods good = new Goods();

                        good.setGoodsId(rs.getInt(1));
                        good.setGoodsType(rs.getString(2));
                        good.setGoodsQuantity(rs.getInt(3));

                        res.add(good);
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
                try (ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM Goods")) {
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
