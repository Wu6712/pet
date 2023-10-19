package cn.js.ccit.service;

import cn.js.ccit.entity.Foster;
import com.alibaba.fastjson.JSONObject;
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
public interface IFosterService extends IService<Foster> {

    int insertOne(Foster foster);

    List<Foster> getList();

    int updateOneById(Integer id);

    Foster selectById(Integer id);

}
