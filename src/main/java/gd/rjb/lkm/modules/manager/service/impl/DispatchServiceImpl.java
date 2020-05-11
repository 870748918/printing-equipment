package gd.rjb.lkm.modules.manager.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.common.utils.Query;

import gd.rjb.lkm.modules.manager.dao.DispatchDao;
import gd.rjb.lkm.modules.manager.entity.DispatchEntity;
import gd.rjb.lkm.modules.manager.service.DispatchService;


@Service("dispatchService")
public class DispatchServiceImpl extends ServiceImpl<DispatchDao, DispatchEntity> implements DispatchService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DispatchEntity> page = this.page(
                new Query<DispatchEntity>().getPage(params),
                new QueryWrapper<DispatchEntity>()
        );

        return new PageUtils(page);
    }

}