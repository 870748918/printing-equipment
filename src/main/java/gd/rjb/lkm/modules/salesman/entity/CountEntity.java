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
 * @date 2020-02-21 16:21:32
 */
@Data
@TableName("count")
public class CountEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String countId;
	/**
	 * 
	 */
	private String goodsId;
	/**
	 * 
	 */
	private Integer countNum;
	/**
	 * 
	 */
	private String countPerson;
	private int status;
	/**
	 * 
	 */
	private String date;

	@Override
	public String toString() {
		return "CountEntity{" +
				"countId='" + countId + '\'' +
				", goodsId='" + goodsId + '\'' +
				", countNum=" + countNum +
				", countPerson='" + countPerson + '\'' +
				", date=" + date +
				'}';
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getCountId() {
		return countId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setCountId(String countId) {
		this.countId = countId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getCountNum() {
		return countNum;
	}

	public void setCountNum(Integer countNum) {
		this.countNum = countNum;
	}

	public String getCountPerson() {
		return countPerson;
	}

	public void setCountPerson(String countPerson) {
		this.countPerson = countPerson;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
