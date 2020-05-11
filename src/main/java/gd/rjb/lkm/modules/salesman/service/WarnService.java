package gd.rjb.lkm.modules.salesman.service;

import com.baomidou.mybatisplus.extension.service.IService;
import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.modules.salesman.entity.WarnEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-27 16:10:23
 */
public interface WarnService extends IService<WarnEntity> {

    PageUtils queryPage(Map<String, Object> params);
    WarnEntity getWarn(String warnPlace);
}

