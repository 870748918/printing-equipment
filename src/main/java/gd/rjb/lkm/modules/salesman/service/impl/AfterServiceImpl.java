package gd.rjb.lkm.modules.salesman.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.common.utils.Query;
import gd.rjb.lkm.modules.salesman.dao.AfterDao;
import gd.rjb.lkm.modules.salesman.entity.AfterEntity;
import gd.rjb.lkm.modules.salesman.service.AfterService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("afterService")
public class AfterServiceImpl extends ServiceImpl<AfterDao, AfterEntity> implements AfterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AfterEntity> page = this.page(
                new Query<AfterEntity>().getPage(params),
                new QueryWrapper<AfterEntity>()
        );

        return new PageUtils(page);
    }
    public boolean save(AfterEntity after){
        return this.baseMapper.insertAfter(after);
    }
}