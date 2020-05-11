package gd.rjb.lkm.modules.salesman.entity;

/**
 * Created by LKM on 2020/5/9.
 */
public class SellGoodsTotal {
    private int value;
    private String name;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SellGoodsTotal{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
