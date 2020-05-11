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
 * @date 2020-02-23 11:51:41
 */
@Data
@TableName("goods_add")
public class AddEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String addId;
	/**
	 * 
	 */
	private String goodsId;
	/**
	 * 
	 */
	private Integer addNum;
	/**
	 * 
	 */
	private String addPerson;
	/**
	 * 
	 */
	private String date;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getAddId() {
		return addId;
	}

	public void setAddId(String addId) {
		this.addId = addId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getAddNum() {
		return addNum;
	}

	public void setAddNum(Integer addNum) {
		this.addNum = addNum;
	}

	public String getAddPerson() {
		return addPerson;
	}

	public void setAddPerson(String addPerson) {
		this.addPerson = addPerson;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "AddEntity{" +
				"addId='" + addId + '\'' +
				", goodsId='" + goodsId + '\'' +
				", addNum=" + addNum +
				", addPerson='" + addPerson + '\'' +
				", date='" + date + '\'' +
				'}';
	}
}
