package com.playtech.urltesting.spliturl.util;
/**
 * protocol, host, port, path, params
 * helps representing the url 
 * @author memrecaglan
 *
 */
public class UrlHelper {
	
	private String protocol;
	private String host;
	private String port;
	private String path;
	private String params;
	private Long executionTime;
	
	public UrlHelper() {
	}
	
	public UrlHelper(String protocol, String host, String port, String path, String params) {
		this.protocol = protocol;
		this.host = host;
		this.port = port;
		this.path = path;
		this.params = params;
	}


	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Long executionTime) {
		this.executionTime = executionTime;
	}

	@Override
	public String toString() {
		return "protocol : " + this.protocol + "\n" 
					+ "host : " + this.host + "\n" 
					+ "port : " + (this.port!=null ? this.port : "") +"\n" 
					+ "path : " + this.path + "\n" 
					+ "params : " + (this.params!=null ? this.params + "\n" : "" ) ;
	}

}
