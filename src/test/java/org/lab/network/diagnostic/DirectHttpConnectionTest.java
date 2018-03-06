package org.lab.network.diagnostic;

import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.lab.network.diagnostic.domain.RequestInfo;
import org.lab.network.diagnostic.domain.RequestInfo.Scheme;

public class DirectHttpConnectionTest {

	@Test
	@Ignore("Intranet required")
	public void test() {
		DiagnosticComponent component = new DiagnosticComponent();

		RequestInfo request = new RequestInfo();

		request.setTargetHost("les000900201");
		request.setTargetPort(8080);
		request.setTargetSchema(Scheme.http);
		request.setUri("/");
		request.setUnsafeSsl(false);

		Map<String, Object> result = component.check(request);

		System.out.println(result);

	}
}
