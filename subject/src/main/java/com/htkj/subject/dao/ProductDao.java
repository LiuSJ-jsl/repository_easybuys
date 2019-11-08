package com.htkj.subject.dao;

import com.htkj.subject.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: 首页的dao
 * @Author: LiuSJ
 * @date: 2019/10/21 15:58
 */
@Component
public interface ProductDao {
    /**
     * @return java.util.List<com.htkj.easybuy_entity.entity.Product>
     * @MethodName: getProductByIsDelete
     * @Description: 查询首页
     * @author LiuShanJie
     * @Param []
     * @date 2019/10/21 15:54
     */
    List<Product> getProductByIsDelete();
}
