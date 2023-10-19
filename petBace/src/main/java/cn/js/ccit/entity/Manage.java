package cn.js.ccit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author 123
 * @since 2023-07-11
 */
@Data
@TableName("t_manage")
@ApiModel(value = "Manage对象", description = "")
public class Manage implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("id")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("被举报名")
      private String name;

      @ApiModelProperty("举报描述")
      private String description;

      @ApiModelProperty("1，以处理；0，未处理")
      private Integer isHandle;

}
