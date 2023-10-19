package cn.js.ccit.mapper;

import cn.js.ccit.entity.Manage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 123
 * @since 2023-07-11
 */
@Mapper
public interface ManageMapper extends BaseMapper<Manage> {

    List<Manage> getList();

    int insertOne(Manage manage);

    int updateOne(Integer id);

}
