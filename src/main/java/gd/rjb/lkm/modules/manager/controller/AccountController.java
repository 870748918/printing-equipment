package gd.rjb.lkm.modules.manager.controller;

import gd.rjb.lkm.common.utils.R;
import gd.rjb.lkm.modules.manager.entity.AccountEntity;
import gd.rjb.lkm.modules.salesman.service.impl.SellServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by LKM on 2020/3/2.
 */
@RestController
@RequestMapping("manager/account")
public class AccountController {
    @Autowired
    private SellServiceImpl sellService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("manager:account:list")
    public R list(@RequestParam Map<String, Object> params){
        String address = (String)params.get("address");
        List<AccountEntity> accountEntities;
        if(address.equals("桂林市")){
            accountEntities = sellService.getAllTotal();
        }else{
            accountEntities = sellService.getTotalByAddress(address);
        }

        for(AccountEntity accountEntity : accountEntities){
            if(accountEntity.getPlace().equals("") || accountEntity.getPlace()==null){
                accountEntity.setPlace("桂林市");
            }
            accountEntity.setAcoountId(1);
        }
        return R.ok().put("list", accountEntities);
    }
}
