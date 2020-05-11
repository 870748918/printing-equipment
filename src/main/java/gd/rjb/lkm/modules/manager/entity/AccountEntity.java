package gd.rjb.lkm.modules.manager.entity;

/**
 * Created by LKM on 2020/3/2.
 */
public class AccountEntity {
    private int acoountId;
    private String place;
    private double total;

    public int getAcoountId() {
        return acoountId;
    }

    public void setAcoountId(int acoountId) {
        this.acoountId = acoountId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
