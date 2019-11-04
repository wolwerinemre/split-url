package com.playtech.urltesting.spliturl;

import static java.lang.System.exit;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;

import com.playtech.urltesting.spliturl.service.SplitUrlService;
import com.playtech.urltesting.spliturl.util.UrlHelper;
/**
 * Sprint boot starting application and initialize service
 * And iteration 100000 method
 * Can Using aspect for it
 * @author memrecaglan
 *
 */
@EnableAutoConfiguration
@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private SplitUrlService splitUrlService;
	
	public static void main(String[] args) throws MalformedURLException {
		 SpringApplication app = new SpringApplication(Application.class);
         app.setBannerMode(Banner.Mode.OFF);
         app.run(args);		
	}

	public void run(String... arg0) throws Exception {
		if (arg0.length > 0) {
			printUrl(arg0);
        } else {
        		System.out.println("please enter url!");
        }
		System.out.println("--- exit ---");
        exit(0);
		
	}

	private void printUrl(String... arg0) throws Exception {
		System.out.println("URL is " +arg0[0]);
		StopWatch stopWatch = new StopWatch("Performance Test Result");
		
		System.out.println("--- regex ---");
		stopWatch.start("RegexUrlIteration");
		System.out.println(regexUrlIteration(arg0));
		stopWatch.stop();
		
		System.out.println("--- state machine ---");
		stopWatch.start("StateMachineUrlIteration");
		System.out.println(stateMachineUrlIteration(arg0));
		stopWatch.stop();
		
		System.out.println(stopWatch.prettyPrint());
	}

	private UrlHelper regexUrlIteration(String... arg0) throws Exception {
		UrlHelper  regexUrl= new UrlHelper();
		for (int i = 0; i < 10000; i++) {
			 regexUrl= splitUrlService.splitUrlByRegex(arg0[0].toString());
		}
		return regexUrl;
	}
	
	private UrlHelper stateMachineUrlIteration(String... arg0) throws Exception {
		UrlHelper  stateMachineUrl= new UrlHelper();
		for (int i = 0; i < 10000; i++) {
			 stateMachineUrl= splitUrlService.splitUrlByStateMachine(arg0[0].toString());
		}
		return stateMachineUrl;
	}

}
