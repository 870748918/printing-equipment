package gd.rjb.lkm.modules.salesman.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.common.utils.Query;
import gd.rjb.lkm.modules.manager.entity.AccountEntity;
import gd.rjb.lkm.modules.salesman.dao.SellDao;
import gd.rjb.lkm.modules.salesman.entity.SellEntity;
import gd.rjb.lkm.modules.salesman.entity.SellGoodsTotal;
import gd.rjb.lkm.modules.salesman.entity.SellTotal;
import gd.rjb.lkm.modules.salesman.service.SellService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("sellService")
public class SellServiceImpl extends ServiceImpl<SellDao, SellEntity> implements SellService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SellEntity> page = this.page(
                new Query<SellEntity>().getPage(params),
                new QueryWrapper<SellEntity>()
        );
        for(SellEntity sell : page.getRecords()){
            sell.setGoods(this.baseMapper.queryGoods(sell.getGoods()));
        }

        return new PageUtils(page);
    }
    public boolean save(SellEntity sellEntity){
        return this.baseMapper.insertSell(sellEntity);
    }

    public List<AccountEntity> getTotalByAddress(String address){
        return this.baseMapper.totalByAddress(address);
    }

    @Override
    public List<AccountEntity> getAllTotal() {
        return this.baseMapper.allTotal();
    }

    @Override
    public List<SellTotal> getSellTotal() {
        return this.baseMapper.totoalByGestores();
    }

    @Override
    public List<SellGoodsTotal> getGoodsTotal() {
        List<SellGoodsTotal> sellGoodsTotals = this.baseMapper.totalByGoods();
        for(SellGoodsTotal sell : sellGoodsTotals){
            sell.setName(this.baseMapper.queryGoods(sell.getName()));
            System.out.println("KayMin Test:" + sell.getName());
        }
        return sellGoodsTotals;
    }

    @Override
    public List<SellGoodsTotal> getAddressTotal() {
        return this.baseMapper.totalByAddressToo();
    }


}