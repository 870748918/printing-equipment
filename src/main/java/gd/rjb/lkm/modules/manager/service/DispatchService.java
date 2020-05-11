package gd.rjb.lkm.modules.manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.modules.manager.entity.DispatchEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-04-13 23:04:09
 */
public interface DispatchService extends IService<DispatchEntity> {

    PageUtils queryPage(Map<String, Object> params);

}

