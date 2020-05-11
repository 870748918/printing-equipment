package gd.rjb.lkm.modules.salesman.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-18 18:10:12
 */
@Data
@TableName("sell")
public class SellEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String sellId;
	/**
	 * 
	 */
	private String goods;
	/**
	 * 
	 */
	private Integer goodsNum;
	/**
	 * 
	 */
	private String buyer;
	/**
	 * 
	 */
	private String telephone;
	/**
	 * 
	 */
	private String gestores;
	/**
	 * 
	 */
	private String date;
	/**
	 * 
	 */
	private String address;

	private int isVip;

	private double total;


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getSellId() {
		return sellId;
	}

	public void setSellId(String sellId) {
		this.sellId = sellId;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getGestores() {
		return gestores;
	}

	public void setGestores(String gestores) {
		this.gestores = gestores;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getIsVip() {
		return isVip;
	}

	public void setIsVip(int isVip) {
		this.isVip = isVip;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "SellEntity{" +
				"sellId='" + sellId + '\'' +
				", goods='" + goods + '\'' +
				", goodsNum=" + goodsNum +
				", buyer='" + buyer + '\'' +
				", telephone='" + telephone + '\'' +
				", gestores='" + gestores + '\'' +
				", date=" + date +
				", address='" + address + '\'' +
				'}';
	}
}
