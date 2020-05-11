package gd.rjb.lkm.modules.manager.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-26 11:58:49
 */
@Data
@TableName("suppliers")
public class SuppliersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String suppliersId;
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

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getSuppliersId() {
		return suppliersId;
	}

	public void setSuppliersId(String suppliersId) {
		this.suppliersId = suppliersId;
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

	@Override
	public String toString() {
		return "SuppliersEntity{" +
				"suppliersId='" + suppliersId + '\'' +
				", contactPerson='" + contactPerson + '\'' +
				", telephone='" + telephone + '\'' +
				", contactAddress='" + contactAddress + '\'' +
				'}';
	}
}
