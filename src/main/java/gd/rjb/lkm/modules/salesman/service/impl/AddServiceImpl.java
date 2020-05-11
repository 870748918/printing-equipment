package gd.rjb.lkm.modules.salesman.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.common.utils.Query;
import gd.rjb.lkm.modules.salesman.dao.AddDao;
import gd.rjb.lkm.modules.salesman.entity.AddEntity;
import gd.rjb.lkm.modules.salesman.service.AddService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("addService")
public class AddServiceImpl extends ServiceImpl<AddDao, AddEntity> implements AddService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AddEntity> page = this.page(
                new Query<AddEntity>().getPage(params),
                new QueryWrapper<AddEntity>()
        );
        for(AddEntity addEntity : page.getRecords()){
            addEntity.setGoodsId(this.baseMapper.queryGoods(addEntity.getGoodsId()));
        }
        return new PageUtils(page);
    }
    public boolean save(AddEntity addEntity){
        return this.baseMapper.insertAdd(addEntity);
    }
}