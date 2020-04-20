package site.amass.swagger.example.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel("返回的基本数据类型")
@Getter
public class BaseVO {

	@ApiModelProperty("请求结果状态码")
	private Integer code;
	
	@ApiModelProperty("请求结果信息")
	private String message;
	
	@ApiModelProperty("返回的数据")
	private Object data;
}
