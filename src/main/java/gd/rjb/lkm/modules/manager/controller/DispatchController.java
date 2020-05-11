package gd.rjb.lkm.modules.manager.controller;

import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.common.utils.R;
import gd.rjb.lkm.modules.manager.entity.DispatchEntity;
import gd.rjb.lkm.modules.manager.service.DispatchService;
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
 * @date 2020-04-13 23:04:09
 */
@RestController
@RequestMapping("manager/dispatch")
public class DispatchController {
    @Autowired
    private DispatchService dispatchService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("manager:dispatch:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dispatchService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{dispatchId}")
    @RequiresPermissions("manager:dispatch:info")
    public R info(@PathVariable("dispatchId") String dispatchId){
		DispatchEntity dispatch = dispatchService.getById(dispatchId);

        return R.ok().put("dispatch", dispatch);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manager:dispatch:save")
    public R save(@RequestBody DispatchEntity dispatch){
		dispatchService.save(dispatch);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manager:dispatch:update")
    public R update(@RequestBody DispatchEntity dispatch){
		dispatchService.updateById(dispatch);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("manager:dispatch:delete")
    public R delete(@RequestBody String[] dispatchIds){
		dispatchService.removeByIds(Arrays.asList(dispatchIds));

        return R.ok();
    }

}
