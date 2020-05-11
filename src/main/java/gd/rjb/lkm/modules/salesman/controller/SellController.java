package gd.rjb.lkm.modules.salesman.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.common.utils.R;
import gd.rjb.lkm.modules.salesman.entity.GoodsEntity;
import gd.rjb.lkm.modules.salesman.entity.SellEntity;
import gd.rjb.lkm.modules.salesman.entity.SellGoodsTotal;
import gd.rjb.lkm.modules.salesman.entity.SellTotal;
import gd.rjb.lkm.modules.salesman.service.GoodsService;
import gd.rjb.lkm.modules.salesman.service.SellService;
import gd.rjb.lkm.modules.salesman.service.impl.SellServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-18 18:10:12
 */
@RestController
@RequestMapping("salesman/sell")
public class SellController {
    @Autowired
    private SellService sellService;
    @Autowired
    private SellServiceImpl sellServiceImpl;
    @Autowired
    private GoodsService goodsService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("salesman:sale:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sellService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{sellId}")
    @RequiresPermissions("salesman:sale:list")
    public R info(@PathVariable("sellId") String sellId){
		SellEntity sell = sellService.getById(sellId);

        return R.ok().put("sell", sell);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("salesman:sale:save")
    public R save(@RequestBody SellEntity sell){
        sell.setSellId(UUID.randomUUID().toString());
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        sell.setDate(ft.format(dNow));
        GoodsEntity goodsEntity = goodsService.getById(sell.getGoods());
        if(sell.getIsVip() == 1){
            sell.setTotal(sell.getGoodsNum()*goodsEntity.getPrice()*0.8);
        }else{
            sell.setTotal(sell.getGoodsNum()*goodsEntity.getPrice());
        }
        sellServiceImpl.save(sell);
        goodsEntity.setGoodsNum(goodsEntity.getGoodsNum()-sell.getGoodsNum());
        goodsService.update(goodsEntity,new UpdateWrapper<GoodsEntity>().eq("goods_id",sell.getGoods()));
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("salesman:sale:update")
    public R update(@RequestBody SellEntity sell,@RequestParam int oldGoodsNum){
        GoodsEntity goodsEntity = goodsService.getById(sell.getGoods());
        goodsEntity.setGoodsNum(goodsEntity.getGoodsNum()+(oldGoodsNum-sell.getGoodsNum()));
        if(sell.getIsVip() == 1){
            sell.setTotal(sell.getGoodsNum()*goodsEntity.getPrice()*0.8);
        }else{
            sell.setTotal(sell.getGoodsNum()*goodsEntity.getPrice());
        }
        goodsService.updateById(goodsEntity);
		sellService.updateById(sell);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("salesman:sale:delete")
    public R delete(@RequestBody String[] sellIds){
		sellService.removeByIds(Arrays.asList(sellIds));

        return R.ok();
    }

    /**
     * 获取业务员的销售总额
     */
    @RequestMapping("/total")
    public R total() {
        List<SellTotal> sellTotals =  sellService.getSellTotal();

        return R.ok().put("totals",sellTotals);
    }

    /**
     * 获取打印器材的销售总额
     */
    @RequestMapping("/goodsTotal")
    public R goodsTotal() {
        List<SellGoodsTotal> goodsTotals =  sellService.getGoodsTotal();

        return R.ok().put("totals",goodsTotals);
    }

    /**
     * 获取地区的销售总额
     */
    @RequestMapping("/addressTotal")
    public R addressTotal() {
        List<SellGoodsTotal> addressTotal =  sellService.getAddressTotal();
        System.out.println("kayMin Test address:");
        return R.ok().put("totals",addressTotal);
    }

}
