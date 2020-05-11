package gd.rjb.lkm.modules.salesman.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import gd.rjb.lkm.modules.salesman.entity.GoodsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-17 16:42:58
 */
@Mapper
public interface GoodsDao extends BaseMapper<GoodsEntity> {
    boolean insertGoods(GoodsEntity goods);
    List<GoodsEntity> selectAllGoods(String address);
}
