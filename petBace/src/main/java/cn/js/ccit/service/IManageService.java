package cn.js.ccit.service;

import cn.js.ccit.entity.Manage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 123
 * @since 2023-07-11
 */
public interface IManageService extends IService<Manage> {

    List<Manage> getList();

    int insertOne(Manage manage);

    int updateOne(Integer id);

}
