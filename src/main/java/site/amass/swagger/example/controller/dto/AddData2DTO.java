package site.amass.swagger.example.controller.dto;

import java.util.ArrayList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel("添加数据2示例")
@Getter
public class AddData2DTO {

	@ApiModelProperty(value = "array<Integer>类型参数", required = true,example = "[]")
	private ArrayList<Integer> arrayInteger;

}
