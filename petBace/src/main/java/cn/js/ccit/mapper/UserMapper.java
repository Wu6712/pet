package cn.js.ccit.mapper;

import cn.js.ccit.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 123
 * @since 2023-07-03
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User selectByUsername(User user);

    int insertOne(User user);

    int updateByUserName(String username, String newPassword);

    int updateOne(String username);

}
