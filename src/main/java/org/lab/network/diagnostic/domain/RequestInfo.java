package org.lab.network.diagnostic.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Request info")
public class RequestInfo {

	@ApiModelProperty(value = "Target host")
	String targetHost;

	@ApiModelProperty(value = "Target port", example = "80")
	Integer targetPort = 80;

	@ApiModelProperty(value = "Target schema", example = "http")
	String targetSchema = "http";

	@ApiModelProperty(value = "URI", example = "/")
	String uri = "/";

	@ApiModelProperty(value = "Unsafe SSL validation", example = "false")
	Boolean unsafeSsl = false;

	@ApiModelProperty(value = "Proxy host", required = false)
	String proxyHost;

	@ApiModelProperty(value = "Proxy port", required = false)
	Integer proxyPort;

	@ApiModelProperty(value = "Proxy username", required = false)
	String proxyUsername;

	@ApiModelProperty(value = "Proxy password", required = false)
	String proxyPassword;

	public boolean isProxyAutenticationEnabled() {
		return proxyHost != null && proxyPort != null && proxyUsername != null && proxyPassword != null;
	}

}
