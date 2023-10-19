package cn.js.ccit.service;

import cn.js.ccit.entity.Log;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 123
 * @since 2023-07-08
 */
public interface ILogService extends IService<Log> {

    List<Log> getListByUserName(String username);

    int insertOne(Log log);

    int deleteOne(Integer id);

    int updateOne1(Log log);

}
