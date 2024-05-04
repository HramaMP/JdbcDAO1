package ua.kiev.prog.shared;

public class Goods {
    @Id
    private int id;

    private String name;
    private int age;

    public Goods() {
    }

    public Goods(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getGoodsId() {
        return id;
    }

    public void setGoodsId(int id) {
        this.id = id;
    }

    public String getGoodsType() {
        return name;
    }

    public void setGoodsType(String name) {
        this.name = name;
    }

    public int getGoodsQuantity() {
        return age;
    }

    public void setGoodsQuantity(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
