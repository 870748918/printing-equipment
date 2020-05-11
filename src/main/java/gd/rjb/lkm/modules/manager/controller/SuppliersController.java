package gd.rjb.lkm.modules.manager.controller;

import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.common.utils.R;
import gd.rjb.lkm.modules.manager.entity.SuppliersEntity;
import gd.rjb.lkm.modules.manager.service.SuppliersService;
import gd.rjb.lkm.modules.manager.service.impl.SuppliersServiceImpl;
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
 * @date 2020-02-26 11:58:49
 */
@RestController
@RequestMapping("manager/suppliers")
public class SuppliersController {
    @Autowired
    private SuppliersService suppliersService;
    @Autowired
    private SuppliersServiceImpl suppliersServiceImpl;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("manager:suppliers:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = suppliersService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{suppliersid}")
    @RequiresPermissions("manager:suppliers:list")
    public R info(@PathVariable("suppliersid") String suppliersid){
		SuppliersEntity suppliers = suppliersService.getById(suppliersid);

        return R.ok().put("suppliers", suppliers);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manager:suppliers:save")
    public R save(@RequestBody SuppliersEntity suppliers){
        suppliers.setSuppliersId(UUID.randomUUID().toString());
        suppliersServiceImpl.save(suppliers);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manager:suppliers:update")
    public R update(@RequestBody SuppliersEntity suppliers){
		suppliersService.updateById(suppliers);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manager:suppliers:delete")
    public R delete(@RequestBody String[] suppliersids){
		suppliersService.removeByIds(Arrays.asList(suppliersids));

        return R.ok();
    }

}
