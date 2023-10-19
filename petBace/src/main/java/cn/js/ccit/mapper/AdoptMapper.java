package cn.js.ccit.mapper;

import cn.js.ccit.entity.Adopt;
import cn.js.ccit.entity.vo.AdoptVo;
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
public interface AdoptMapper extends BaseMapper<Adopt> {

    List<Adopt> getList();

    List<AdoptVo> getAdoptList();

    Adopt getById(Integer id);

    int updateOne(Integer id, Integer userId);

    List<Adopt> getListByType(String petType);

    int updateVaccine(Integer id);

    int insertOne(Adopt adopt);

}
