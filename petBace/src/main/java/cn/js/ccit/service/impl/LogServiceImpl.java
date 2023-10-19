package cn.js.ccit.service.impl;

import cn.js.ccit.entity.Log;
import cn.js.ccit.mapper.LogMapper;
import cn.js.ccit.service.ILogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 123
 * @since 2023-07-08
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public List<Log> getListByUserName(String username) {
        return logMapper.getListByUserName(username);
    }

    @Override
    public int insertOne(Log log) {

        return logMapper.insertOne(log);

    }

    @Override
    public int deleteOne(Integer id) {

        return logMapper.deleteOneById(id);

    }

    @Override
    public int updateOne1(Log log) {

        return logMapper.updateOne(log);

    }
}
