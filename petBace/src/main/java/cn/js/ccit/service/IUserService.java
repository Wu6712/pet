package cn.js.ccit.service;

import cn.js.ccit.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 123
 * @since 2023-07-03
 */
public interface IUserService extends IService<User> {

    int register(User user);

    User login(String username, String password);

    int changePasswd(String username, String oldPassword, String newPassword);

    User getByUserName(String username);

    int changePermissions(String username);

}
