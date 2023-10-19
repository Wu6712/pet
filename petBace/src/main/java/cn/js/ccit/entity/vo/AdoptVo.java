package cn.js.ccit.entity.vo;

import cn.js.ccit.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AdoptVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("宠物名")
    private String petName;

    @ApiModelProperty("品种类型")
    private String petType;

    @ApiModelProperty("疫苗情况 1,已打;0,未打")
    private Integer vaccine;

    @ApiModelProperty("宠物照片")
    private String imageURL;

    private User user;

}
