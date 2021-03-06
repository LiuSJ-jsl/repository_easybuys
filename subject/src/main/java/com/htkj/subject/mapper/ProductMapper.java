package com.htkj.subject.mapper;

import com.htkj.subject.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description:
 * @Author: LiuShanJie
 * @date: 2019/11/13 8:54
 */
public interface ProductMapper {
    /**
     * @return java.util.List<com.htkj.easybuy_entity.entity.Product>
     * @MethodName: getProductByIsDelete
     * @Description: 查询首页
     * @author LiuShanJie
     * @Param []
     * @date 2019/10/21 15:54
     */
    @Select("select * from easybuy.easybuy_product where isDelete = 0 and id = 1546211")
    List<Product> getProductByIsDelete();

    /**
     * @param []
     * @return java.util.List<com.htkj.subject.entity.Product>
     * @MethodName: getProduct
     * @Description: 获取1546211的id
     * @author LiuShanJie
     * @date 2019/12/18 15:18
     */
    @Select("select * from easybuy.easybuy_product where isDelete = 0 and id = 1546211")
    Product getProduct();

    /**
     * @param [id]
     * @return com.htkj.subject.entity.Product
     * @MethodName: getProductById
     * @Description: 查询单个
     * @author LiuShanJie
     * @date 2019/11/11 8:20
     */
    @Select("select * from easybuy.easybuy_product where id = #{id};")
    Product getProductById(@Param("id") int id);
}
