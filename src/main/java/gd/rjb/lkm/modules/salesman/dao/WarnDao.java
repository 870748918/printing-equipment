package gd.rjb.lkm.modules.salesman.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import gd.rjb.lkm.modules.salesman.entity.WarnEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-27 16:10:23
 */
@Mapper
public interface WarnDao extends BaseMapper<WarnEntity> {
    String queryRegion(String regionID);
	WarnEntity getByWarnPlace(String warnPlace);
}
