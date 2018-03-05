package org.lab.network.diagnostic.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Request info")
public class RequestInfo {

	@ApiModelProperty(value = "Target host")
	private String targetHost;

	@ApiModelProperty(value = "Target port", example = "80")
	private Integer targetPort = 80;

	@ApiModelProperty(value = "Target schema", example = "http")
	private String targetSchema = "http";

	@ApiModelProperty(value = "URI", example = "/")
	private String uri = "/";

	@ApiModelProperty(value = "Unsafe SSL validation", example = "false")
	private Boolean unsafeSsl = false;

	@ApiModelProperty(value = "Proxy host", required = false)
	private String proxyHost;

	@ApiModelProperty(value = "Proxy port", required = false)
	private Integer proxyPort;

	@ApiModelProperty(value = "Proxy username", required = false)
	private String proxyUsername;

	@ApiModelProperty(value = "Proxy password", required = false)
	private String proxyPassword;

	public boolean isProxyAutenticationEnabled() {
		return proxyHost != null && proxyPort != null && proxyUsername != null && proxyPassword != null;
	}

}
