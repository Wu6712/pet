package cn.js.ccit.mapper;

import cn.js.ccit.entity.Log;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 123
 * @since 2023-07-08
 */
@Mapper
public interface LogMapper extends BaseMapper<Log> {

    List<Log> getListByUserName(String username);

    int insertOne(Log log);

    int deleteOneById(Integer id);

    int updateOne(Log log);

}
