package gd.rjb.lkm.modules.salesman.controller;

import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.common.utils.R;
import gd.rjb.lkm.modules.salesman.entity.WarnEntity;
import gd.rjb.lkm.modules.salesman.service.WarnService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-27 16:10:23
 */
@RestController
@RequestMapping("salesman/warn")
public class WarnController {
    @Autowired
    private WarnService warnService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("salesman:warn:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = warnService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{warnId}")
    @RequiresPermissions("salesman:warn:list")
    public R info(@PathVariable("warnId") Integer warnId){
		WarnEntity warn = warnService.getById(warnId);
        return R.ok().put("warn", warn);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("salesman:warn:save")
    public R save(@RequestBody WarnEntity warn){
		warnService.save(warn);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("salesman:warn:update")
    public R update(@RequestBody WarnEntity warn){
		warnService.updateById(warn);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("salesman:warn:delete")
    public R delete(@RequestBody Integer[] warnIds){
		warnService.removeByIds(Arrays.asList(warnIds));

        return R.ok();
    }

}
