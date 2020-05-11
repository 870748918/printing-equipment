package gd.rjb.lkm.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by LKM on 2020/2/17.
 */
@Data
@TableName("region")
public class regionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 区域ID
     */
    @TableId
    private String regionID;
    /**
     * 区域名称
     */
    private String regionName;
    /**
     * 区域的父区域
     */
    private String parentID;
    /**
     * 区域等级
     */
    private int level;
}
