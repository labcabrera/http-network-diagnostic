package org.lab.network.diagnostic;

import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.lab.network.diagnostic.domain.RequestInfo;
import org.lab.network.diagnostic.domain.RequestInfo.Scheme;

public class DirectHttpsConnectionTest {

	@Test
	@Ignore("Intranet required")
	public void test() {
		DiagnosticComponent component = new DiagnosticComponent();

		RequestInfo request = new RequestInfo();

		request.setTargetHost("wcorreo10cpd2.mapfre.net");
		request.setTargetPort(443);
		request.setTargetSchema(Scheme.https);
		request.setUri("/owa/");
		request.setUnsafeSsl(true);

		Map<String, Object> result = component.check(request);

		System.out.println(result);

	}
}
