package site.amass.swagger.example.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import site.amass.swagger.example.controller.dto.AddUserDTO;

@Api(tags = "文档示例")
@RestController
@RequestMapping("api")
public class ExampleController {

	@ApiOperation("ADD方式的API")
	@PostMapping("add")
	public void add(@RequestBody AddUserDTO dto) {
	}

	@ApiOperation("PUT方式的API")
	@PutMapping
	public void put() {

	}

	@ApiOperation("DELETE方式的API")
	@DeleteMapping
	public void delete() {

	}

	@ApiOperation("GET方式的API")
	@GetMapping
	public void get() {
	}
}
