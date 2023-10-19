package cn.js.ccit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author 123
 * @since 2023-07-13
 */
@TableName("t_foster_manage")
@ApiModel(value = "FosterManage对象", description = "")
public class FosterManage implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("id")
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private String vaccine;

    private Integer userId;

    
    public Integer getId() {
        return id;
    }

      public void setId(Integer id) {
          this.id = id;
      }
    
    public String getVaccine() {
        return vaccine;
    }

      public void setVaccine(String vaccine) {
          this.vaccine = vaccine;
      }
    
    public Integer getUserId() {
        return userId;
    }

      public void setUserId(Integer userId) {
          this.userId = userId;
      }

    @Override
    public String toString() {
        return "FosterManage{" +
              ", id=" + id +
                  ", vaccine=" + vaccine +
                  ", userId=" + userId +
              "}";
    }
}
