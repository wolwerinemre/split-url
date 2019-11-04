package com.playtech.urltesting.spliturl.service;

import com.playtech.urltesting.spliturl.util.UrlHelper;
/**
 * SplitUrl Service interface
 * @author memrecaglan
 *
 */
public interface SplitUrlService {

	public UrlHelper splitUrlByRegex(String url) throws Exception;

	public UrlHelper splitUrlByStateMachine(String url) throws Exception;

}
