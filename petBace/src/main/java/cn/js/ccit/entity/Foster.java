package cn.js.ccit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@TableName("t_foster")
@ApiModel(value = "Foster对象", description = "")
public class Foster implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("ID")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("用户名")
      private String username;

      @ApiModelProperty("寄养时间")
      private String fosterTime;

      @ApiModelProperty("宠物名")
      private String petName;

      @ApiModelProperty("宠物品种")
      private String petType;

      @ApiModelProperty("联系方式")
      private String phone;

      private Integer vaccine;

      private String imageUrl;
}
