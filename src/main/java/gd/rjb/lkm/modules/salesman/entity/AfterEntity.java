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
 * @date 2020-02-18 16:48:10
 */
@Data
@TableName("after")
public class AfterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String afterId;
	/**
	 * 
	 */
	private String goods;
	/**
	 * 
	 */
	private String contactPerson;
	/**
	 * 
	 */
	private String telephone;
	/**
	 * 
	 */
	private String contactAddress;
	/**
	 * 
	 */
	private String date;
	/**
	 * 
	 */
	private String address;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getAfterId() {
		return afterId;
	}

	public void setAfterId(String afterId) {
		this.afterId = afterId;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
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

	@Override
	public String toString() {
		return "AfterEntity{" +
				"afterId='" + afterId + '\'' +
				", goods='" + goods + '\'' +
				", contactPerson='" + contactPerson + '\'' +
				", telephone='" + telephone + '\'' +
				", contactAddress='" + contactAddress + '\'' +
				", date=" + date +
				", address='" + address + '\'' +
				'}';
	}
}
