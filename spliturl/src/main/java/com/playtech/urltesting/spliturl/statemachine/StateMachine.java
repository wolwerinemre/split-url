package com.playtech.urltesting.spliturl.statemachine;

import java.net.URL;

import com.playtech.urltesting.spliturl.statemachine.enums.StateEnum;
import com.playtech.urltesting.spliturl.statemachine.eventlistener.StateEventListener;

/**
 *  implementation of events on state machine. 
 *  Basically it checks the state and does
 *  corresponding operations.
 * @author memrecaglan
 *
 */
public class StateMachine implements StateEventListener {
	
	public StateEnum currentState;
	
	public String onEventUrlParseStart() throws Exception {
		String value = "";
		if(currentState == StateEnum.START) {
			value = "State Machine is Started.";
		}
		 return value;
	}

	public String onEventUrlParseProtocol(URL aURL) throws Exception {
		String value = "";
		if(currentState == StateEnum.PROTOCOL) {
			value = currentState.onEventUrlParseProtocol(aURL);
		}
		 return value;
	}

	public String onEventUrlParseHost(URL aURL) throws Exception {
		String value = "";
		if(currentState == StateEnum.HOST) {
			value = currentState.onEventUrlParseHost(aURL);			
		}
		return value;
	}

	public String onEventUrlParsePort(URL aURL) throws Exception{
		String value = "";
		if(currentState == StateEnum.PORT) {
			value = currentState.onEventUrlParsePort(aURL);			
		}
		return value;
	}

	public String onEventUrlParsePath(URL aURL) throws Exception {
		String value = "";
		if(currentState == StateEnum.PATH) {
			value = currentState.onEventUrlParsePath(aURL);			
		}
		return value;
	}

	public String onEventUrlParseParam(URL aURL) throws Exception {
		String value = "";
		if(currentState == StateEnum.PARAMS) {
			value = currentState.onEventUrlParseParam(aURL);			
		}
		return value;
	}
	
	public StateEnum getCurrentState() {
		return currentState;
	}

	public void setCurrentState(StateEnum currentState) {
		this.currentState = currentState;
	}

}
