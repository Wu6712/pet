package cn.js.ccit.service;

import cn.js.ccit.entity.Adopt;
import cn.js.ccit.entity.vo.AdoptVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 123
 * @since 2023-07-06
 */
public interface IAdoptService extends IService<Adopt> {

    List<Adopt> getList();

    Adopt getById(Integer id);

    int updateOne(Integer id, String username);

    List<Adopt> getListByType(String petType);

    List<AdoptVo> getLists();

    int audit(Integer id);

    int insertOne(Adopt adopt);

}
