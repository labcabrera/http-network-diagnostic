package org.lab.network.diagnostic;

import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.lab.network.diagnostic.domain.RequestInfo;

public class ProxyAutenticationTest {

	@Test
	@Ignore("Credentials required")
	public void test() {
		DiagnosticComponent component = new DiagnosticComponent();

		RequestInfo request = new RequestInfo();

		request.setTargetHost("www.google.com");
		request.setTargetPort(443);
		request.setTargetSchema("https");
		request.setUri("/");
		request.setUnsafeSsl(true);

		request.setProxyHost("proxytal");
		request.setProxyPort(80);
		request.setProxyUsername("******");
		request.setProxyPassword("******");

		Map<String, Object> result = component.check(request);

		System.out.println(result);

	}

}
