package gd.rjb.lkm.modules.salesman.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.common.utils.Query;
import gd.rjb.lkm.modules.salesman.dao.GoodsDao;
import gd.rjb.lkm.modules.salesman.entity.GoodsEntity;
import gd.rjb.lkm.modules.salesman.entity.WarnEntity;
import gd.rjb.lkm.modules.salesman.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("goodsService")
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, GoodsEntity> implements GoodsService {
    @Autowired
    WarnServiceImpl warnService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GoodsEntity> page = this.page(
                new Query<GoodsEntity>().getPage(params),
                new QueryWrapper<GoodsEntity>()
        );
        WarnEntity warnEntity = warnService.getWarn((String)params.get("address"));
        List<GoodsEntity> goodsEntities = new ArrayList<>();
        System.out.println("明"+(String)params.get("address"));
        for(GoodsEntity goodsEntity : page.getRecords()){
           if(goodsEntity.getAddress().equals(params.get("address").toString())){
               if(goodsEntity.getGoodsNum()< warnEntity.getWarnNum()){
                   goodsEntity.setStatus(0);
               }
               else{
                   goodsEntity.setStatus(1);
               }
               goodsEntities.add(goodsEntity);
           }
        }
        page.setRecords(goodsEntities);
        return new PageUtils(page);
    }

    @Override
    public List<GoodsEntity> getAllGoods(String address) {
        return this.baseMapper.selectList( new QueryWrapper<GoodsEntity>().eq("address",address));
    }

    public boolean save(GoodsEntity entity){
        return this.baseMapper.insertGoods(entity);
    }
}