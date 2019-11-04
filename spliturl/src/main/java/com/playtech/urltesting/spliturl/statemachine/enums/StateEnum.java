package com.playtech.urltesting.spliturl.statemachine.enums;

import java.net.URL;

import com.playtech.urltesting.spliturl.statemachine.eventlistener.StateEventListener;

/**
 * provides states and implements state changing methods.
 * @author memrecaglan
 *
 */
public enum StateEnum implements StateEventListener{
	
	START,
	PROTOCOL,
	HOST,
	PORT,
	PATH,
	PARAMS;

	public String onEventUrlParseProtocol(URL aURL){
		return aURL.getProtocol();
	}
	public String onEventUrlParseHost(URL aURL) {
		return aURL.getHost();
	}
	public String onEventUrlParsePort(URL aURL) {
		return aURL.getPort()!= -1 ? Integer.toString(aURL.getPort()) : "";
	}
	public String onEventUrlParsePath(URL aURL) throws Exception {
		return aURL.getPath();
	}
	public String onEventUrlParseParam(URL aURL) throws Exception {
		return aURL.getQuery();
		
	}
	public String onEventUrlParseStart() throws Exception {
		return "";
	}
	

}