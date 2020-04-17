package site.amass.swagger.example.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel("添加用户")
@Getter
public class AddUserDTO {

	@ApiModelProperty(value = "Integer类型参数", required = true)
	private Integer integerDataType;

	@ApiModelProperty(value = "签名验证|加密方式：MD5(MD5(uid+skey)+time)，长度32位")
	private String sign;

	@ApiModelProperty(value = "秒级时间戳|注：请求到达时间相差不能超过5分钟", required = true)
	private Long time;

	@ApiModelProperty(value = "传入此参数表示使用站点API|注：可选参数")
	private String vhost;
}
