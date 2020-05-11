package gd.rjb.lkm.modules.manager.dao;

import gd.rjb.lkm.modules.manager.entity.SuppliersEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-26 11:58:49
 */
@Mapper
public interface SuppliersDao extends BaseMapper<SuppliersEntity> {
    boolean insertSuppliers(SuppliersEntity suppliersEntity);
	
}
