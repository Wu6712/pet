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
 * @since 2023-07-03
 */
@Data
@TableName("t_user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("用户ID")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("用户名")
      private String username;

      @ApiModelProperty("密码")
      private String password;

      @ApiModelProperty("信用分")
      private Integer credit;

      @ApiModelProperty("权限1超级管理员；2普通用户")
      private Integer permissions;

}
