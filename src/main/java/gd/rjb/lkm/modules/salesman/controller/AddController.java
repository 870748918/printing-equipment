package gd.rjb.lkm.modules.salesman.controller;

import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.common.utils.R;
import gd.rjb.lkm.modules.salesman.entity.AddEntity;
import gd.rjb.lkm.modules.salesman.entity.GoodsEntity;
import gd.rjb.lkm.modules.salesman.service.AddService;
import gd.rjb.lkm.modules.salesman.service.GoodsService;
import gd.rjb.lkm.modules.salesman.service.impl.AddServiceImpl;
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
 * @date 2020-02-23 11:51:41
 */
@RestController
@RequestMapping("salesman/add")
public class AddController {
    @Autowired
    private AddService addService;
    @Autowired
    private AddServiceImpl addServiceImpl;
    @Autowired
    private GoodsService goodsService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("salesman:add:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = addService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{addid}")
    @RequiresPermissions("salesman:add:list")
    public R info(@PathVariable("addid") String addid){
		AddEntity add = addService.getById(addid);

        return R.ok().put("add", add);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("salesman:add:save")
    public R save(@RequestBody AddEntity add){
        add.setAddId(UUID.randomUUID().toString());
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        add.setDate(ft.format(dNow));
		addServiceImpl.save(add);
        GoodsEntity goodsEntity = goodsService.getById(add.getGoodsId());
        goodsEntity.setGoodsNum(goodsEntity.getGoodsNum()+add.getAddNum());
        goodsService.updateById(goodsEntity);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("salesman:add:update")
    public R update(@RequestBody AddEntity add,@RequestParam int oldGoodsNum){
        GoodsEntity goodsEntity = goodsService.getById(add.getGoodsId());
        goodsEntity.setGoodsNum(goodsEntity.getGoodsNum()-(oldGoodsNum-add.getAddNum()));
        goodsService.updateById(goodsEntity);
		addService.updateById(add);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("salesman:add:delete")
    public R delete(@RequestBody String[] addids){
		addService.removeByIds(Arrays.asList(addids));

        return R.ok();
    }

}
