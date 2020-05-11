package gd.rjb.lkm.modules.salesman.service;

import com.baomidou.mybatisplus.extension.service.IService;
import gd.rjb.lkm.common.utils.PageUtils;
import gd.rjb.lkm.modules.salesman.entity.AddEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-02-23 11:51:41
 */
public interface AddService extends IService<AddEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

