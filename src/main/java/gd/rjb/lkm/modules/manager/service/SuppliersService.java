package gd.rjb.lkm.modules.manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.modules.manager.entity.SuppliersEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-26 11:58:49
 */
public interface SuppliersService extends IService<SuppliersEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

