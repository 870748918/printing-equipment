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
 * @date 2020-04-13 23:04:09
 */
@Data
@TableName("dispatch")
public class DispatchEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String dispatchId;
	/**
	 * 
	 */
	private String dispatchPerson;
	/**
	 * 
	 */
	private String from;
	/**
	 * 
	 */
	private String to;
	/**
	 * 
	 */
	private Integer status;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getDispatchId() {
		return dispatchId;
	}

	public void setDispatchId(String dispatchId) {
		this.dispatchId = dispatchId;
	}

	public String getDispatchPerson() {
		return dispatchPerson;
	}

	public void setDispatchPerson(String dispatchPerson) {
		this.dispatchPerson = dispatchPerson;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
