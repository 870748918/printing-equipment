package gd.rjb.lkm.modules.salesman.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import gd.rjb.lkm.modules.salesman.entity.AfterEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-18 16:48:10
 */
@Mapper
public interface AfterDao extends BaseMapper<AfterEntity> {
    boolean insertAfter(AfterEntity after);
	
}
