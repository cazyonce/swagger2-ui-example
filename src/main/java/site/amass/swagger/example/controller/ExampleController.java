package site.amass.swagger.example.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import site.amass.swagger.example.controller.dto.AddBaseDataDTO;

@Api(tags = "文档示例")
@RestController
@RequestMapping("api")
public class ExampleController {

	@ApiOperation("ADD方式的API")
	@PostMapping("add/{id}/{id2}")
	public AddBaseDataDTO add(@PathVariable Integer id, @PathVariable Integer id2, String userName, String userName2,
			@RequestBody AddBaseDataDTO dto) {
		return null;
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
