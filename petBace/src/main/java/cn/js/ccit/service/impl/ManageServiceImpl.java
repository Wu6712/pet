package cn.js.ccit.service.impl;

import cn.js.ccit.entity.Manage;
import cn.js.ccit.mapper.ManageMapper;
import cn.js.ccit.service.IManageService;
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
 * @since 2023-07-11
 */
@Service
public class ManageServiceImpl extends ServiceImpl<ManageMapper, Manage> implements IManageService {

    @Autowired
    private ManageMapper mapper;

    @Override
    public List<Manage> getList() {

        List<Manage> list = mapper.getList();

        return list;

    }

    @Override
    public int insertOne(Manage manage) {

        manage.setIsHandle(0);
        return mapper.insertOne(manage);

    }

    @Override
    public int updateOne(Integer id) {

        return mapper.updateOne(id);

    }
}
