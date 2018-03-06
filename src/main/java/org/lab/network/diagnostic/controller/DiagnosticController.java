package org.lab.network.diagnostic.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.lab.network.diagnostic.DiagnosticComponent;
import org.lab.network.diagnostic.domain.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/api")
public class DiagnosticController {

	@Autowired
	private DiagnosticComponent component;

	@GetMapping(value = "/date")
	@ApiOperation(value = "Date controller")
	public ResponseEntity<Date> ping() {
		return ResponseEntity.ok(Calendar.getInstance().getTime());
	}

	@PostMapping(value = "/ping")
	@ApiOperation(value = "Check HTTP connection using optional proxy")
	public Map<String, Object> ping(@ApiParam(value = "Query info", required = true) RequestInfo request) {
		return component.check(request.normalize());
	}

}
