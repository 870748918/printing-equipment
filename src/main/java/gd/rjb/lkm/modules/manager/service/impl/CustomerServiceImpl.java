package gd.rjb.lkm.modules.manager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.common.utils.Query;
import gd.rjb.lkm.modules.manager.dao.CustomerDao;
import gd.rjb.lkm.modules.manager.entity.CustomerEntity;
import gd.rjb.lkm.modules.manager.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("customerService")
public class CustomerServiceImpl extends ServiceImpl<CustomerDao, CustomerEntity> implements CustomerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CustomerEntity> page = this.page(
                new Query<CustomerEntity>().getPage(params),
                new QueryWrapper<CustomerEntity>()
        );

        return new PageUtils(page);
    }
    public boolean save(CustomerEntity customerEntity){
        return this.baseMapper.insertCustomer(customerEntity);
    }

}