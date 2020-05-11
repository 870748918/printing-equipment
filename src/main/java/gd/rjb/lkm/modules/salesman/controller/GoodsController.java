package gd.rjb.lkm.modules.salesman.controller;

import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.common.utils.R;
import gd.rjb.lkm.modules.salesman.entity.GoodsEntity;
import gd.rjb.lkm.modules.salesman.service.GoodsService;
import gd.rjb.lkm.modules.salesman.service.impl.GoodsServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-17 16:42:58
 */
@RestController
@RequestMapping("/salesman/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsServiceImpl goodsServiceImpl;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("salesman:goods:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodsService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/all_list")
    @RequiresPermissions("salesman:goods:list")
    public R all_list(@RequestParam String address){
        List<GoodsEntity> goodsList =  goodsService.getAllGoods(address);

        return R.ok().put("goodsList", goodsList);
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{goodsid}")
    @RequiresPermissions("salesman:goods:list")
    public R info(@PathVariable("goodsid") String goodsid){
		GoodsEntity goods = goodsService.getById(goodsid);

        return R.ok().put("goods", goods);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("salesman:goods:save")
    public R save(@RequestBody GoodsEntity goods){
        goods.setGoodsId(UUID.randomUUID().toString());
		goodsServiceImpl.save(goods);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("salesman:goods:update")
    public R update(@RequestBody GoodsEntity goods){
		goodsService.updateById(goods);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("salesman:goods:delete")
    public R delete(@RequestBody String[] goodsids){
		goodsService.removeByIds(Arrays.asList(goodsids));

        return R.ok();
    }

}
