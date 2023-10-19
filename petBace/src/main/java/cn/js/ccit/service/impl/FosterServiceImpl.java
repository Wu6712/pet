package cn.js.ccit.service.impl;

import cn.js.ccit.entity.Foster;
import cn.js.ccit.mapper.FosterMapper;
import cn.js.ccit.service.IFosterService;
import com.alibaba.fastjson.JSONObject;
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
 * @since 2023-07-06
 */
@Service
public class FosterServiceImpl extends ServiceImpl<FosterMapper, Foster> implements IFosterService {

    @Autowired
    private FosterMapper fosterMapper;

    @Override
    public int insertOne(Foster foster) {

        return fosterMapper.insertOne(foster);

    }

    @Override
    public List<Foster> getList() {
        return fosterMapper.getList();
    }

    @Override
    public int updateOneById(Integer id) {

        return fosterMapper.upateOneById(id);

    }

    @Override
    public Foster selectById(Integer id) {
        return fosterMapper.selectById(id);
    }
}
