package com.codesniper.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codesniper.entity.SpuComment;
import com.codesniper.service.SpuCommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 商品评价(SpuComment)表控制层
 *
 * @author CodeSniper
 * @since 2022-03-14 16:39:40
 */
@RestController
@RequestMapping("spuComment")
public class SpuCommentController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SpuCommentService spuCommentService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param spuComment 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SpuComment> page, SpuComment spuComment) {
        return success(this.spuCommentService.page(page, new QueryWrapper<>(spuComment)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.spuCommentService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param spuComment 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SpuComment spuComment) {
        return success(this.spuCommentService.save(spuComment));
    }

    /**
     * 修改数据
     *
     * @param spuComment 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SpuComment spuComment) {
        return success(this.spuCommentService.updateById(spuComment));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.spuCommentService.removeByIds(idList));
    }
}

