package com.playtech.urltesting.spliturl.statemachine.eventlistener;

import java.net.URL;

/**
 * State Event Listener
 * @author memrecaglan
 *
 */
public interface StateEventListener {

	public String onEventUrlParseStart() throws Exception;
	public String onEventUrlParseProtocol(URL aURL) throws Exception;
    public String onEventUrlParseHost(URL aURL) throws Exception;
    public String onEventUrlParsePort(URL aURL) throws Exception;
    public String onEventUrlParsePath(URL aURL) throws Exception;
    public String onEventUrlParseParam(URL aURL) throws Exception;
    
}
