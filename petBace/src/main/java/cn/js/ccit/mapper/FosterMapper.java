package cn.js.ccit.mapper;

import cn.js.ccit.entity.Foster;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 123
 * @since 2023-07-06
 */
@Mapper
public interface FosterMapper extends BaseMapper<Foster> {

    int insertOne(Foster foster);

    List<Foster> getList();

    int upateOneById(Integer id);

}
