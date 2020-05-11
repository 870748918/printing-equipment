package gd.rjb.lkm.modules.salesman.service;

import com.baomidou.mybatisplus.extension.service.IService;
import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.modules.manager.entity.AccountEntity;
import gd.rjb.lkm.modules.salesman.entity.SellEntity;
import gd.rjb.lkm.modules.salesman.entity.SellGoodsTotal;
import gd.rjb.lkm.modules.salesman.entity.SellTotal;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-18 18:10:12
 */
public interface SellService extends IService<SellEntity> {

    PageUtils queryPage(Map<String, Object> params);
    public List<AccountEntity> getTotalByAddress(String address);
    public List<AccountEntity> getAllTotal();
    public List<SellTotal> getSellTotal();
    public List<SellGoodsTotal> getGoodsTotal();
    public List<SellGoodsTotal> getAddressTotal();
}

