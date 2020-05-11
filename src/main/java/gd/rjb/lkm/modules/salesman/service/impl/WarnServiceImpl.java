package gd.rjb.lkm.modules.salesman.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.common.utils.Query;
import gd.rjb.lkm.modules.salesman.dao.WarnDao;
import gd.rjb.lkm.modules.salesman.entity.WarnEntity;
import gd.rjb.lkm.modules.salesman.service.WarnService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("warnService")
public class WarnServiceImpl extends ServiceImpl<WarnDao, WarnEntity> implements WarnService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WarnEntity> page = this.page(
                new Query<WarnEntity>().getPage(params),
                new QueryWrapper<WarnEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public WarnEntity getWarn(String warnPlace) {
        return this.baseMapper.getByWarnPlace(warnPlace);
    }

}