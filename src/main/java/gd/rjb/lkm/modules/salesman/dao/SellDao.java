package gd.rjb.lkm.modules.salesman.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import gd.rjb.lkm.modules.manager.entity.AccountEntity;
import gd.rjb.lkm.modules.salesman.entity.SellEntity;
import gd.rjb.lkm.modules.salesman.entity.SellGoodsTotal;
import gd.rjb.lkm.modules.salesman.entity.SellTotal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-18 18:10:12
 */
@Mapper
public interface SellDao extends BaseMapper<SellEntity> {
    boolean insertSell(SellEntity sell);
    String queryGoods(String goodsId);
    List<AccountEntity> totalByAddress(String address);
    List<AccountEntity> allTotal();
    List<SellTotal> totoalByGestores();
    List<SellGoodsTotal> totalByGoods();
    List<SellGoodsTotal> totalByAddressToo();
}
