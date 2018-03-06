package org.lab.network.diagnostic.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Request info")
public class RequestInfo {

	public enum Scheme {
		http, https
	}

	@ApiModelProperty(value = "Host name")
	private String targetHost;

	@ApiModelProperty(value = "Host port", example = "80")
	private Integer targetPort;

	@ApiModelProperty(value = "Scheme", allowableValues = "http,https")
	private Scheme targetSchema;

	@ApiModelProperty(value = "Query path", example = "/")
	private String uri;

	@ApiModelProperty(value = "Unsafe SSL validation", example = "false")
	private Boolean unsafeSsl;

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

	public RequestInfo normalize() {
		uri = uri != null ? uri : "/";
		unsafeSsl = unsafeSsl != null ? unsafeSsl : true;
		if (targetSchema != null && targetPort == null) {
			switch (targetSchema) {
			case https:
				targetPort = 443;
				break;
			default:
				targetPort = 80;
				break;
			}
		}
		return this;
	}

}
