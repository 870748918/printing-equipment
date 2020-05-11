package gd.rjb.lkm.modules.salesman.service;

import com.baomidou.mybatisplus.extension.service.IService;
import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.modules.salesman.entity.GoodsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-17 16:42:58
 */
public interface GoodsService extends IService<GoodsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<GoodsEntity> getAllGoods(String address);
}

