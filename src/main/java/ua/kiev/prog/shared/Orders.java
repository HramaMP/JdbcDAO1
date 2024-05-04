package ua.kiev.prog.shared;

public class Orders {
    @Id
    private int id;

    private int clientId;
    private String clientName;
    private float orderSum;
    private String orderDetails;


    public Orders() {
    }

    public Orders(int clientId, String clientName, float orderSum, String orderDetails) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.orderSum = orderSum;
        this.orderDetails = orderDetails;
    }

    public int getOrderId() {
        return id;
    }

    public void setOrderId(int id) {
        this.id = id;
    }

    public int getOrderClientId() {
        return clientId;
    }

    public void setOrderClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getOrderClientName() {
        return clientName;
    }

    public void setOrderClientName(String clientName) {
        this.clientName = clientName;
    }

    public float getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(float orderSum) {
        this.orderSum = orderSum;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ClientID='" + clientId + '\'' +
                ", clientName='" + clientName + '\'' +
                ", orderSum=" + orderSum +
                ", orderDetails='" + orderDetails +
                '}';
    }
}

