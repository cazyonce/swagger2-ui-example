package site.amass.swagger.example.controller.dto;

import java.util.ArrayList;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel("添加基本数据示例")
@Getter
public class AddBaseDataDTO {

	@ApiModelProperty(value = "char类型参数", required = true, example = "c")
	private char charDataType;

	@ApiModelProperty(value = "byte类型参数", required = true, example = "1")
	private Byte byteDataType;

	@ApiModelProperty(value = "short类型参数", required = true, example = "1")
	private Short shortDataType;

	@ApiModelProperty(value = "long类型参数", required = true, example = "1")
	private Long longDataType;

	@ApiModelProperty(value = "integer类型参数", required = true, example = "1")
	private Integer integerDataType;

	@ApiModelProperty(value = "int类型参数", required = true, example = "1")
	private int intDataType;

	@ApiModelProperty(value = "string类型参数", required = true, example = "1")
	private String stringDataType;

	@ApiModelProperty(value = "float类型参数", required = true, example = "1")
	private Float floatDataType;

	@ApiModelProperty(value = "double类型参数", required = true, example = "1")
	private Double doubleDataType;

	@ApiModelProperty(value = "boolean类型参数", required = true, example = "1")
	private Boolean booleanDataType;

	@ApiModelProperty(value = "array<string>类型参数", required = true, example = "[]")
	private ArrayList<String> arrayString;

	@ApiModelProperty(value = "array<AddDataDTO>类型参数", required = true, example = "[{}]")
	private ArrayList<AddDataDTO> arrayAddDataDTO;

	@ApiModelProperty(value = "array<array<AddDataDTO>>类型参数", required = true, example = "[[{}]]")
	private ArrayList<ArrayList<AddDataDTO>> arrayArrayAddDataDTO;

	@ApiModelProperty(value = "ArrayList<ArrayList<ArrayList<AddDataDTO>>>类型参数", required = true, example = "[[[{}]]]")
	private ArrayList<ArrayList<ArrayList<AddDataDTO>>> arrayArrayArrayAddDataDTO;

	@ApiModelProperty(value = "ArrayList4类型参数", required = true, example = "[[[{}]]]")
	private ArrayList<ArrayList<ArrayList<ArrayList<AddDataDTO>>>> array4AddDataDTO;

	@ApiModelProperty(value = "map<string,integer>类型参数", required = true, example = "")
	private Map<String, Integer> mapStringInteger;

	@ApiModelProperty(value = "map<string,AddDataDTO>类型参数", required = true, example = "")
	private Map<String, AddDataDTO> mapStringAddDataDTO;

	@ApiModelProperty(value = "addDataDTO类型参数", required = true, example = "{}")
	private AddDataDTO addDataDTO;

}
