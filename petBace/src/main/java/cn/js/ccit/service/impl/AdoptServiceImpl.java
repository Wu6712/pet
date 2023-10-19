package cn.js.ccit.service.impl;

import cn.js.ccit.entity.Adopt;
import cn.js.ccit.entity.User;
import cn.js.ccit.entity.vo.AdoptVo;
import cn.js.ccit.mapper.AdoptMapper;
import cn.js.ccit.mapper.UserMapper;
import cn.js.ccit.service.IAdoptService;
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
public class AdoptServiceImpl extends ServiceImpl<AdoptMapper, Adopt> implements IAdoptService {

    @Autowired
    private AdoptMapper adoptMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Adopt> getList() {

        return adoptMapper.getList();

    }

    @Override
    public Adopt getById(Integer id) {
        return adoptMapper.getById(id);
    }

    @Override
    public int updateOne(Integer id, String username) {

        User user = new User();
        user.setUsername(username);
        User u = userMapper.selectByUsername(user);

        return adoptMapper.updateOne(id, u.getId());

    }

    @Override
    public List<Adopt> getListByType(String petType) {

        return adoptMapper.getListByType(petType);

    }

    @Override
    public List<AdoptVo> getLists() {

        return adoptMapper.getAdoptList();

    }

    @Override
    public int audit(Integer id) {
        return adoptMapper.updateVaccine(id);
    }

    @Override
    public int insertOne(Adopt adopt) {
        return adoptMapper.insertOne(adopt);
    }
}
