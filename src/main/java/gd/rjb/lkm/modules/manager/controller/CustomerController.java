package gd.rjb.lkm.modules.manager.controller;

import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.common.utils.R;
import gd.rjb.lkm.modules.manager.entity.CustomerEntity;
import gd.rjb.lkm.modules.manager.service.CustomerService;
import gd.rjb.lkm.modules.manager.service.impl.CustomerServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-26 13:54:29
 */
@RestController
@RequestMapping("manager/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("manager:customer:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = customerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{customerid}")
    @RequiresPermissions("manager:customer:list")
    public R info(@PathVariable("customerid") String customerid){
		CustomerEntity customer = customerService.getById(customerid);

        return R.ok().put("customer", customer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manager:customer:save")
    public R save(@RequestBody CustomerEntity customer){
        customer.setCustomerId(UUID.randomUUID().toString());
		customerServiceImpl.save(customer);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manager:customer:update")
    public R update(@RequestBody CustomerEntity customer){
		customerService.updateById(customer);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manager:customer:delete")
    public R delete(@RequestBody String[] customerids){
		customerService.removeByIds(Arrays.asList(customerids));

        return R.ok();
    }

}
