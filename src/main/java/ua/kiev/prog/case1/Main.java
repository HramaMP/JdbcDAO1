package ua.kiev.prog.case1;

import ua.kiev.prog.shared.Client;
import ua.kiev.prog.shared.ConnectionFactory;
import ua.kiev.prog.shared.Goods;
import ua.kiev.prog.shared.Orders;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

// DB > JDBC (H) > DAO > App

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection();
             Scanner sc = new Scanner(System.in))
        {
            ClientDAO dao = new ClientDAOImpl(conn);
            dao.createTable();
            GoodsDAO gdao = new GoodsDAOImpl(conn);
            gdao.createGoodsTable();
            OrderDAO odao = new OrderDAOImpl(conn);
            odao.createOrderTable();

            while (true) {
                System.out.println("1: add client");
                System.out.println("2: view clients");
                System.out.println("3: view count");
                System.out.println("4: add goods");
                System.out.println("5: view goods");
                System.out.println("6: add order");
                System.out.println("7: view orders");
                System.out.print("-> ");

                String s = sc.nextLine();
                switch (s) {
                    case "1":
                        System.out.print("Enter client name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter client age: ");
                        String sAge = sc.nextLine();
                        int age = Integer.parseInt(sAge);

                        dao.addClient(name, age);
                        break;
                    case "2":
                        List<Client> list = dao.getAll();
                        for (Client client : list) {
                            System.out.println(client);
                        }
                        break;
                    case "3":
                        System.out.println("Count: " + dao.count());
                        break;
                    case "4":
                        System.out.print("Enter goods type: ");
                        String type = sc.nextLine();
                        System.out.print("Enter quantity of goods: ");
                        String sQuantity = sc.nextLine();
                        int quantity = Integer.parseInt(sQuantity);

                        gdao.addGoods(type, quantity );
                        break;
                    case "5":
                        List<Goods> goodsList = gdao.getAllGoods();
                        for (Goods good : goodsList) {
                            System.out.println(good);
                        }
                        break;
                    case "6":
                        System.out.print("Enter client ID: ");
                        String sClientId = sc.nextLine();
                        int clientId = Integer.parseInt(sClientId);
                        System.out.print("Enter client name: ");
                        String clientName = sc.nextLine();
                        System.out.print("Enter order sum ");
                        String sOrderSum = sc.nextLine();
                        float orderSum = Float.parseFloat(sOrderSum);
                        System.out.print("Enter order details: ");
                        String orderDetails = sc.nextLine();


                        odao.addOrder(clientId, clientName, orderSum, orderDetails);
                        break;
                    case "7":
                        List<Orders> ordersList = odao.getAllOrder();
                        for (Orders order : ordersList) {
                            System.out.println(order);
                        }
                        break;

                    default:
                        return;
                }
            }
        }
    }
}
