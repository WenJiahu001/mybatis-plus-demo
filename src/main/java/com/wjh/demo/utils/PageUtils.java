package com.wjh.demo.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjh.demo.common.vo.PageResult;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author 文家虎
 * @Package com.wjh.demo.utils
 * @date 2021/4/29 17:38
 */
public class PageUtils {
    /**
     * 转换分页结果
     *
     * @param page
     * @return 分页结果
     */
    public static PageResult convertPageResult(Page<?> page) {

        PageResult pageResult = new PageResult();
        pageResult.setPageIndex((int) page.getCurrent());
        pageResult.setPageSize((int) page.getSize());
        pageResult.setTotal((int) page.getTotal());
        pageResult.setItems(page.getRecords());
        return pageResult;
    }

    /**
     * 设置分页
     *
     * @param pageIndex 页码
     * @param pageSize  条数
     * @param sortField 排序字段
     * @param sort      排序方式
     */
    public static void startPage(Integer pageIndex, Integer pageSize, String sortField, String sort) {
        if (StringUtils.isEmpty(sortField))
            sortField = "id";

        if (pageIndex == null || pageIndex < 1) {
            pageIndex = 1;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = 20;
        }
        String filed = SQLFilter.sqlInject(sortField);
        String ascOrDesc = SQLFilter.sqlInject(sort);
        PageHelper.startPage(pageIndex, pageSize);

        if (!StringUtils.isBlank(filed)) {
            if (!StringUtils.isBlank(ascOrDesc)) {
                PageHelper.orderBy(filed + " " + ascOrDesc);
            } else {
                PageHelper.orderBy(filed + " asc");
            }
        }
    }

    /**
     * 生成分页结果
     *
     * @param list 查询集合
     * @return 分页结果
     */
    public static PageResult genPageResult(List<?> list) {
        PageInfo pageInfo = new PageInfo(list);
        PageResult pageResult = new PageResult();
        pageResult.setPageIndex(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotal((int) pageInfo.getTotal());
        pageResult.setItems(pageInfo.getList());
        PageHelper.clearPage();
        return pageResult;
    }
}
