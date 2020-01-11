package com.erp.sys.mapper;

import com.erp.sys.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2020-01-10
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    void deleteRolePermissionByPid(@Param("id")Serializable id);

}
