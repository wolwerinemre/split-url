package com.playtech.urltesting.spliturl.service.impl;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.playtech.urltesting.spliturl.service.SplitUrlService;
import com.playtech.urltesting.spliturl.statemachine.StateMachine;
import com.playtech.urltesting.spliturl.statemachine.enums.StateEnum;
import com.playtech.urltesting.spliturl.util.UrlHelper;
/**
 * business layer methods.
 * @author memrecaglan
 *
 */

@Service
public class SplitUrlServiceImpl implements SplitUrlService {
	
	private final static String urlPattern = "^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*)?)?(#(.*))?";
	
	/**
	 * For Regex
	 * Split and adding urlhelper
	 * @param url
	 * @return
	 * @throws Exception
	 */
	private UrlHelper splitOperationByRegex(String url) throws Exception{
		UrlHelper regexUrlHelper = new UrlHelper();
		
		try {	
			Pattern pattern = Pattern.compile(urlPattern);
			Matcher matcher = pattern.matcher(url);
			matcher.find();
			String protocol = matcher.group(2);
			String uri = matcher.group(4);
			String host =  uri.contains(":") ? uri.split(":")[0] : uri;
			String port = uri.contains(":") ? uri.split(":")[1] : null;
			String path = matcher.group(5);
			String params = matcher.group(7);
			regexUrlHelper = new UrlHelper(protocol, host, port, path, params);

		} catch (Exception e) {
			throw new Exception("Exception regex..."+ e);
		}
		
		
		return regexUrlHelper;
	}
	/**
	 * For state machine
	 * Every state working and
	 * Split and adding urlhelper
	 * @param url
	 * @return
	 * @throws Exception
	 */
	private UrlHelper splitOperationByStateMachne(String url) throws Exception {
		UrlHelper stateUrlHelper = new UrlHelper();
		try {

			StateMachine machine = new StateMachine();
			machine.setCurrentState(StateEnum.START); // start state
			machine.onEventUrlParseStart();
			URL aURL = new URL(url);
			machine.setCurrentState(StateEnum.PROTOCOL);
			stateUrlHelper.setProtocol(machine.onEventUrlParseProtocol(aURL));
			machine.setCurrentState(StateEnum.HOST);
			stateUrlHelper.setHost(machine.onEventUrlParseHost(aURL));
			machine.setCurrentState(StateEnum.PORT);
			stateUrlHelper.setPort(machine.onEventUrlParsePort(aURL));
			machine.setCurrentState(StateEnum.PATH);
			stateUrlHelper.setPath(machine.onEventUrlParsePath(aURL));
			machine.setCurrentState(StateEnum.PARAMS);
			stateUrlHelper.setParams(machine.onEventUrlParseParam(aURL));
			
		} catch (Exception e) {
			throw new Exception("Exception state machine..."+ e);
		}
		return stateUrlHelper;
	}
	
	public UrlHelper splitUrlByRegex(String url) throws Exception{
		return splitOperationByRegex(url);
	}
	
	public UrlHelper splitUrlByStateMachine(String url) throws Exception{
		return splitOperationByStateMachne(url);
	}
}
