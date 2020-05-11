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
 * @date 2020-02-27 16:10:23
 */
@Data
@TableName("warn")
public class WarnEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer warnId;
	/**
	 * 
	 */
	private Integer warnNum;
	/**
	 * 
	 */
	private String warnPlace;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getWarnId() {
		return warnId;
	}

	public void setWarnId(Integer warnId) {
		this.warnId = warnId;
	}

	public Integer getWarnNum() {
		return warnNum;
	}

	public void setWarnNum(Integer warnNum) {
		this.warnNum = warnNum;
	}

	public String getWarnPlace() {
		return warnPlace;
	}

	public void setWarnPlace(String warnPlace) {
		this.warnPlace = warnPlace;
	}

	@Override
	public String toString() {
		return "WarnEntity{" +
				"warnId=" + warnId +
				", warnNum=" + warnNum +
				", warnPlace='" + warnPlace + '\'' +
				'}';
	}
}
