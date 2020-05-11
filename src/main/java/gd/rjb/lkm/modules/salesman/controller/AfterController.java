package gd.rjb.lkm.modules.salesman.controller;

import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.common.utils.R;
import gd.rjb.lkm.modules.salesman.entity.AfterEntity;
import gd.rjb.lkm.modules.salesman.service.AfterService;
import gd.rjb.lkm.modules.salesman.service.impl.AfterServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.UUID;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-18 16:48:10
 */
@RestController
@RequestMapping("/salesman/after")
public class AfterController {
    @Autowired
    private AfterService afterService;
    @Autowired
    private AfterServiceImpl afterServiceImpl;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("salesman:after:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = afterService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{afterid}")
    @RequiresPermissions("salesman:after:list")
    public R info(@PathVariable("afterid") String afterid){
		AfterEntity after = afterService.getById(afterid);

        return R.ok().put("after", after);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("salesman:after:save")
    public R save(@RequestBody AfterEntity after){
        after.setAfterId(UUID.randomUUID().toString());
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        after.setDate(ft.format(dNow));
        afterServiceImpl.save(after);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("salesman:after:update")
    public R update(@RequestBody AfterEntity after){
		afterService.updateById(after);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("salesman:after:delete")
    public R delete(@RequestBody String[] afterids){
		afterService.removeByIds(Arrays.asList(afterids));

        return R.ok();
    }

}
