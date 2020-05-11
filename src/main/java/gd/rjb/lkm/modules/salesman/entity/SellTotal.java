package gd.rjb.lkm.modules.salesman.entity;

/**
 * Created by LKM on 2020/4/30.
 */
public class SellTotal {
    private String gestores;
    private double total;

    public String getGestores() {
        return gestores;
    }

    public void setGestores(String gestores) {
        this.gestores = gestores;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SellTotal{" +
                "gestores='" + gestores + '\'' +
                ", total=" + total +
                '}';
    }
}
