package gd.rjb.lkm.modules.salesman.controller;

import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.common.utils.R;
import gd.rjb.lkm.modules.salesman.entity.CountEntity;
import gd.rjb.lkm.modules.salesman.entity.GoodsEntity;
import gd.rjb.lkm.modules.salesman.service.CountService;
import gd.rjb.lkm.modules.salesman.service.GoodsService;
import gd.rjb.lkm.modules.salesman.service.impl.CountServiceImpl;
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
 * @date 2020-02-21 16:21:32
 */
@RestController
@RequestMapping("salesman/count")
public class CountController {
    @Autowired
    private CountService countService;
    @Autowired
    private CountServiceImpl countServiceImp;
    @Autowired
    private GoodsService goodsService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("salesman:count:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = countService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{countid}")
    @RequiresPermissions("salesman:count:list")
    public R info(@PathVariable("countid") String countid){
		CountEntity count = countService.getById(countid);

        return R.ok().put("count", count);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("salesman:count:save")
    public R save(@RequestBody CountEntity count){
        count.setCountId(UUID.randomUUID().toString());
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        count.setDate(ft.format(dNow));
        GoodsEntity goodsEntity = goodsService.getById(count.getGoodsId());
        if(goodsEntity.getGoodsNum() == count.getCountNum()){
            count.setStatus(1);
        }else{
            count.setStatus(0);
        }
        countServiceImp.save(count);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("salesman:count:update")
    public R update(@RequestBody CountEntity count){
        GoodsEntity goodsEntity = goodsService.getById(count.getGoodsId());
        if(goodsEntity.getGoodsNum() == count.getCountNum()){
            count.setStatus(1);
        }else{
            count.setStatus(0);
        }
		countService.updateById(count);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("salesman:count:delete")
    public R delete(@RequestBody String[] countids){
		countService.removeByIds(Arrays.asList(countids));

        return R.ok();
    }

}
