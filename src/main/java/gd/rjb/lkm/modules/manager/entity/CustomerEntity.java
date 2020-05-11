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
 * @date 2020-02-26 13:54:29
 */
@Data
@TableName("customer")
public class CustomerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String customerId;
	/**
	 * 
	 */
	private String customerName;
	/**
	 * 
	 */
	private String telephone;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "CustomerEntity{" +
				"customerId='" + customerId + '\'' +
				", customerName='" + customerName + '\'' +
				", telephone='" + telephone + '\'' +
				'}';
	}
}
