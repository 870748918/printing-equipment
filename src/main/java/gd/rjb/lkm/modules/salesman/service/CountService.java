package gd.rjb.lkm.modules.salesman.service;

import com.baomidou.mybatisplus.extension.service.IService;
import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.modules.salesman.entity.CountEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-21 16:21:32
 */
public interface CountService extends IService<CountEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

