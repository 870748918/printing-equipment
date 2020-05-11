package gd.rjb.lkm.modules.salesman.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import gd.rjb.lkm.modules.salesman.entity.CountEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-21 16:21:32
 */
@Mapper
public interface CountDao extends BaseMapper<CountEntity> {
    boolean insertCount(CountEntity count);
    String queryGoods(String goodsId);
}
