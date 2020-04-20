package site.amass.swagger.example.controller.dto;

import java.util.ArrayList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel("添加数据示例")
@Getter
public class AddDataDTO {

	@ApiModelProperty(value = "array<string>类型参数", required = true,example = "[]")
	private ArrayList<String> arrayString;
	
	@ApiModelProperty(value = "addData2DTO类型参数", required = true,example = "[]")
	private AddData2DTO addData2DTO;

}
