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
 * @since 2023-07-06
 */
@Data
@TableName("t_adopt")
@ApiModel(value = "Adopt对象", description = "")
public class Adopt implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("ID")
      @TableId(value = "id", type = IdType.AUTO)
        private Integer id;

      @ApiModelProperty("宠物名")
      private String petName;

      @ApiModelProperty("品种类型")
      private String petType;

      @ApiModelProperty("疫苗情况 1,已打;0,未打")
      private Integer vaccine;

      @ApiModelProperty("主人ID")
      private Integer userId;

      @ApiModelProperty("宠物照片")
      private String imageURL;

}
