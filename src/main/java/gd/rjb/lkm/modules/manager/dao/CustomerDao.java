package gd.rjb.lkm.modules.manager.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import gd.rjb.lkm.modules.manager.entity.CustomerEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-26 13:54:29
 */
@Mapper
public interface CustomerDao extends BaseMapper<CustomerEntity> {
    boolean insertCustomer(CustomerEntity CustomerEntity);
}
