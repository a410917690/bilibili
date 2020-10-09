package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.TRoles;
import org.lanqiao.service.TRolesService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色(TRoles)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:09
 */
@RestController
@CrossOrigin
public class TRolesController {
    /**
     * 服务对象
     */
    @Reference
    TRolesService tRolesService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne12")
    public TRoles selectOne(Integer id) {
        return this.tRolesService.queryById(id);
    }

}