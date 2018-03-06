package org.lab.network.diagnostic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.lab.network.diagnostic.domain.RequestInfo;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DiagnosticComponent {

	public Map<String, Object> check(RequestInfo request) {
		Map<String, Object> result = new LinkedHashMap<>();

		CloseableHttpClient client;
		try {
			client = buildClient(request);
		}
		catch (Exception ex) {
			log.error("Client build error", ex);
			result.put("httpClientBuildError", ex.getMessage());
			return result;
		}

		try {

			HttpHost target = new HttpHost( //@formatter:off
				request.getTargetHost(),
				request.getTargetPort(),
				request.getTargetSchema().name()); //@formatter:on

			HttpHost proxy = null;

			if (request.getProxyHost() != null) {
				proxy = new HttpHost(request.getProxyHost(), request.getProxyPort());
			}

			RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
			HttpGet httpget = new HttpGet(request.getUri());
			httpget.setConfig(config);

			CloseableHttpResponse response = client.execute(target, httpget);
			result.put("statusLine", response.getStatusLine().toString());

			try {
				result.put("content", readContent(response.getEntity().getContent()));
			}
			catch (Exception ex) {
				result.put("errorReadingContent", ex.getMessage());
			}

		}
		catch (Exception ex) {
			log.error("HTTP error", ex);
			result.put("exception", ex.getClass().getName());
			result.put("exceptionMessage", ex.getMessage());
		}

		return result;
	}

	private CloseableHttpClient buildClient(RequestInfo request)
		throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

		if (request.isProxyAutenticationEnabled()) {
			CredentialsProvider credsProvider = new BasicCredentialsProvider();
			//@formatter:off
			credsProvider.setCredentials(
					new AuthScope(request.getProxyHost(), request.getProxyPort()),
					new UsernamePasswordCredentials(request.getProxyUsername(), request.getProxyPassword()));
			//@formatter:on
		}

		if (request.getUnsafeSsl()) {
			SSLContext ctx = SSLContext.getInstance("TLS");
			ctx.init(new KeyManager[0], new TrustManager[] { new UnsecureTrustManager() }, new SecureRandom());
			return HttpClients.custom().setSSLContext(ctx).build();
		}
		else {
			return HttpClientBuilder.create().build();
		}
	}

	private String readContent(InputStream in) throws IOException {
		StringBuilder builder = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		while ((line = reader.readLine()) != null) {
			builder.append(line);
		}
		in.close();
		return builder.toString();
	}

}
