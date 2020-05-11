package gd.rjb.lkm.modules.salesman.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import gd.rjb.lkm.modules.salesman.entity.AddEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-23 11:51:41
 */
@Mapper
public interface AddDao extends BaseMapper<AddEntity> {
    boolean insertAdd(AddEntity add);
    String queryGoods(String goodsId);
}
