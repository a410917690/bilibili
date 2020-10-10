package org.lanqiao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.lanqiao.entity.TComComment;
import org.lanqiao.service.TComCommentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评论的评论(TComComment)表控制层
 *
 * @author makejava
 * @since 2020-10-07 11:33:06
 */
@RestController
@CrossOrigin
public class TComCommentController {
    /**
     * 服务对象
     */
    @Reference
     TComCommentService tComCommentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */


}