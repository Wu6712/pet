package cn.js.ccit.service.impl;

import cn.js.ccit.entity.User;
import cn.js.ccit.mapper.UserMapper;
import cn.js.ccit.service.IUserService;
import cn.js.ccit.utils.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 123
 * @since 2023-07-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int register(User user) {
        User u = userMapper.selectByUsername(user);

        if (u != null) {
            return 2;
        }

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setCredit(100);
        user.setPermissions(2);

        return userMapper.insertOne(user);

    }

    @Override
    public User login(String username, String password) {

        User user = new User();
        user.setUsername(username);

        User u = userMapper.selectByUsername(user);

        if (u == null || new BCryptPasswordEncoder().encode(password).equals(u.getPassword())) {
            return null;
        }

        return u;

    }

    @Override
    public int changePasswd(String username, String oldPassword, String newPassword) {

        User user = new User();
        user.setUsername(username);

        User u = userMapper.selectByUsername(user);

        System.out.println(u);

        if (!new BCryptPasswordEncoder().matches(oldPassword, u.getPassword())) {
            return 2;
        }

        int i = userMapper.updateByUserName(username, new BCryptPasswordEncoder().encode(newPassword));

        return i;
    }

    @Override
    public User getByUserName(String username) {

        User user = new User();
        user.setUsername(username);

        return userMapper.selectByUsername(user);

    }

    @Override
    public int changePermissions(String username) {

        return userMapper.updateOne(username);

    }
}
