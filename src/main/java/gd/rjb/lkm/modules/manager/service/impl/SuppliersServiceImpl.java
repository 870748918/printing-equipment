package gd.rjb.lkm.modules.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.common.utils.Query;
import gd.rjb.lkm.modules.manager.dao.SuppliersDao;
import gd.rjb.lkm.modules.manager.entity.SuppliersEntity;
import gd.rjb.lkm.modules.manager.service.SuppliersService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("suppliersService")
public class SuppliersServiceImpl extends ServiceImpl<SuppliersDao, SuppliersEntity> implements SuppliersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SuppliersEntity> page = this.page(
                new Query<SuppliersEntity>().getPage(params),
                new QueryWrapper<SuppliersEntity>()
        );

        return new PageUtils(page);
    }
    public boolean save(SuppliersEntity suppliersEntity){
        return this.baseMapper.insertSuppliers(suppliersEntity);
    }
}