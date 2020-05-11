package gd.rjb.lkm.modules.salesman.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.common.utils.Query;
import gd.rjb.lkm.modules.salesman.dao.CountDao;
import gd.rjb.lkm.modules.salesman.entity.CountEntity;
import gd.rjb.lkm.modules.salesman.service.CountService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("countService")
public class CountServiceImpl extends ServiceImpl<CountDao, CountEntity> implements CountService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CountEntity> page = this.page(
                new Query<CountEntity>().getPage(params),
                new QueryWrapper<CountEntity>()
        );
        for(CountEntity count : page.getRecords()){
            count.setGoodsId(this.baseMapper.queryGoods(count.getGoodsId()));
        }

        return new PageUtils(page);
    }
    public boolean save(CountEntity countEntity){
        return this.baseMapper.insertCount(countEntity);
    }
}