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
 * @date 2020-02-17 16:42:58
 */
@Data
@TableName("goods")
public class GoodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String goodsId;
	/**
	 * 
	 */
	private String goodsName;
	/**
	 * 
	 */
	private Integer goodsNum;
	/**
	 * 
	 */
	private String address;

	private float price;

	private int status;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}



	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GoodsEntity{" +
				"goodsId='" + goodsId + '\'' +
				", goodsName='" + goodsName + '\'' +
				", goodsNum=" + goodsNum +
				", address='" + address + '\'' +
				'}';
	}
}

