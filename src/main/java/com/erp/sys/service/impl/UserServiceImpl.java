package com.erp.sys.service.impl;

import com.baomidou.mybatisplus.core.injector.methods.DeleteById;
import com.erp.sys.entity.User;
import com.erp.sys.mapper.RoleMapper;
import com.erp.sys.mapper.UserMapper;
import com.erp.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2020-01-09
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public boolean removeById(Serializable id) {
        //根据用户ID删除用户角色中间表的数据
        roleMapper.deleteRoleUserByUid(id);
        return super.removeById(id);
    }
    @Override
    public void saveUserRole(Integer uid, Integer[] ids) {
        //根据用户ID删除sys_role_user里面的数据
        this.roleMapper.deleteRoleUserByUid(uid);
        if(null!=ids&&ids.length>0) {
            for (Integer rid : ids) {
                this.roleMapper.insertUserRole(uid,rid);
            }
        }
    }
}
