package org.lab.network.diagnostic;

import java.util.Map;

import org.lab.network.diagnostic.domain.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/api/diagnostic")
public class DiagnosticController {

	@Autowired
	private DiagnosticComponent component;

	@PostMapping(value = "/ping")
	@ApiOperation(value = "Check HTTP connection")
	public Map<String, Object> test(@ApiParam(value = "Request info", required = true) RequestInfo request) {
		return component.check(request);
	}

}
