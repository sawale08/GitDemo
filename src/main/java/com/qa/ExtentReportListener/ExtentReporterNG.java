	package com.qa.ExtentReportListener;
	import java.io.File;
	import java.util.Calendar;
	import java.util.Date;
	import java.util.List;
	import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
	import org.testng.ISuite;
	import org.testng.ISuiteResult;
	import org.testng.ITestContext;
	import org.testng.ITestResult;
	import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

	public class ExtentReporterNG implements IReporter {
		private ExtentReports extent;

		public void generateReport(List <XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory )
		{
			extent = new ExtentReports(outputDirectory + File.separator + "Extent.html", true);
			
			for (ISuite suite: suites){
				Map<String, ISuiteResult> result = suite.getResults();
				
				for(ISuiteResult r: result.values()){
					ITestContext context = r.getTestContext();
					
					buildTestNodes(context.getPassedTests(), LogStatus.PASS);
					buildTestNodes(context.getPassedTests(), LogStatus.FAIL);
					buildTestNodes(context.getPassedTests(), LogStatus.SKIP);
				
				}
			}
			extent.flush();
			extent.close();
			
		}
		
		public void buildTestNodes(IResultMap tests, LogStatus status)
		{
			ExtentTest test;
			
			if(tests.size() > 0){
				for(ITestResult result: tests.getAllResults()){
					test = extent.startTest(result.getMethod().getMethodName());
					
					test.setStartedTime(getTime(result.getStartMillis()));
					test.setEndedTime(getTime(result.getEndMillis()));
					
					for(String group: result.getMethod().getGroups())
					test.assignCategory(group);
					
					if(result.getThrowable()!=null){
						test.log(status, result.getThrowable());
					}else {
						test.log(status, "Test" + status.toString().toLowerCase() +"ed");
					}
					extent.endTest(test);
				}
			}
		}
		
		private Date getTime(long millis){
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(millis);
			return calendar.getTime();
			
		}
//		public void addTest(Test arg0) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		public void flush() {
//			// TODO Auto-generated method stub
//			
//		}
//
//		public void setTestRunnerLogs() {
//			// TODO Auto-generated method stub
//			
//		}
//
//
//		public void start(Report arg0) {
//			// TODO Auto-generated method stub
//			
//		}
//	public void addTest(Test arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void flush() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void setTestRunnerLogs() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void start(Report arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void stop() {
//		// TODO Auto-generated method stub
//		
//	}

}
	/*
	Starting ChromeDriver 75.0.3770.90 (a6dcaf7e3ec6f70a194cc25e8149475c6590e025-refs/branch-heads/3770@{#1003}) on port 27249
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
[1562864958.661][WARNING]: Timed out connecting to Chrome, retrying...
Jul 11, 2019 10:39:21 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
before Navigate to https://www.crmpro.com/index.html
after navigate to https://www.crmpro.com/index.html
Starting ChromeDriver 75.0.3770.90 (a6dcaf7e3ec6f70a194cc25e8149475c6590e025-refs/branch-heads/3770@{#1003}) on port 41196
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Jul 11, 2019 10:39:42 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
before Navigate to https://www.crmpro.com/index.html
after navigate to https://www.crmpro.com/index.html
Trying to find Element By xptahBy.name: username
Trying to find Element By xptahBy.name: username
Trying to find Element By xptahBy.name: password
Trying to find Element By xptahBy.name: password
Trying to find Element By xptahBy.xpath: //input[@type='submit']
Trying to find Element By xptahBy.xpath: //input[@type='submit']
Trying to click on [[ChromeDriver: chrome on XP (a7388d49e01098d28ecf7751b8ffce84)] -> xpath: //input[@type='submit']]
Trying to click on [[ChromeDriver: chrome on XP (a7388d49e01098d28ecf7751b8ffce84)] -> xpath: //input[@type='submit']]
Starting ChromeDriver 75.0.3770.90 (a6dcaf7e3ec6f70a194cc25e8149475c6590e025-refs/branch-heads/3770@{#1003}) on port 23632
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Jul 11, 2019 10:40:12 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
before Navigate to https://www.crmpro.com/index.html
after navigate to https://www.crmpro.com/index.html
Trying to find Element By xptahBy.xpath: //img[contains(@class,'img-responsive')]
Trying to find Element By xptahBy.xpath: //img[contains(@class,'img-responsive')]
Starting ChromeDriver 75.0.3770.90 (a6dcaf7e3ec6f70a194cc25e8149475c6590e025-refs/branch-heads/3770@{#1003}) on port 3190
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Jul 11, 2019 10:40:23 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
before Navigate to https://www.crmpro.com/index.html
after navigate to https://www.crmpro.com/index.html
Trying to find Element By xptahBy.name: username
Trying to find Element By xptahBy.name: username
Trying to find Element By xptahBy.name: password
Trying to find Element By xptahBy.name: password
Trying to find Element By xptahBy.xpath: //input[@type='submit']
Trying to find Element By xptahBy.xpath: //input[@type='submit']
Trying to click on [[ChromeDriver: chrome on XP (8310a4cdf0b4ad8a64154777836090cd)] -> xpath: //input[@type='submit']]
Trying to click on [[ChromeDriver: chrome on XP (8310a4cdf0b4ad8a64154777836090cd)] -> xpath: //input[@type='submit']]
Trying to find Element By xptahBy.xpath: //td[contains(text(),'User: sujatas s')]
Trying to find Element By xptahBy.xpath: //td[contains(text(),'User: sujatas s')]
Starting ChromeDriver 75.0.3770.90 (a6dcaf7e3ec6f70a194cc25e8149475c6590e025-refs/branch-heads/3770@{#1003}) on port 34977
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Jul 11, 2019 10:40:46 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
before Navigate to https://www.crmpro.com/index.html
after navigate to https://www.crmpro.com/index.html
Trying to find Element By xptahBy.name: username
Trying to find Element By xptahBy.name: username
Trying to find Element By xptahBy.name: password
Trying to find Element By xptahBy.name: password
Trying to find Element By xptahBy.xpath: //input[@type='submit']
Trying to find Element By xptahBy.xpath: //input[@type='submit']
Trying to click on [[ChromeDriver: chrome on XP (d49a570a7e075f57ece7921e3a1c72a1)] -> xpath: //input[@type='submit']]
Exception Occur  org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element <input type="submit" value="Login" class="btn btn-small"> is not clickable at point (1182, 117). Other element would receive the click: <div id="preloader" style="opacity: 0.330625;">...</div>
  (Session info: chrome=75.0.3770.100)
Build info: version: '3.141.59', revision: 'e82be7d358', time: '2018-11-14T08:25:48'
System info: host: 'LAPTOP-BM04L1NK', ip: '192.168.0.104', os.name: 'Windows 8.1', os.arch: 'amd64', os.version: '6.3', java.version: '1.8.0_51'
Driver info: org.openqa.selenium.chrome.ChromeDriver
Capabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 75.0.3770.100, chrome: {chromedriverVersion: 75.0.3770.90 (a6dcaf7e3ec6f..., userDataDir: C:\Users\Sai\AppData\Local\...}, goog:chromeOptions: {debuggerAddress: localhost:54379}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}
Session ID: d49a570a7e075f57ece7921e3a1c72a1
Starting ChromeDriver 75.0.3770.90 (a6dcaf7e3ec6f70a194cc25e8149475c6590e025-refs/branch-heads/3770@{#1003}) on port 27201
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Jul 11, 2019 10:41:01 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
before Navigate to https://www.crmpro.com/index.html
after navigate to https://www.crmpro.com/index.html
Trying to find Element By xptahBy.name: username
Trying to find Element By xptahBy.name: username
Trying to find Element By xptahBy.name: password
Trying to find Element By xptahBy.name: password
Trying to find Element By xptahBy.xpath: //input[@type='submit']
Trying to find Element By xptahBy.xpath: //input[@type='submit']
Trying to click on [[ChromeDriver: chrome on XP (d6098a8ef501b1e3dcddb211df7f3151)] -> xpath: //input[@type='submit']]
Exception Occur  org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element <input type="submit" value="Login" class="btn btn-small"> is not clickable at point (1182, 117). Other element would receive the click: <div id="preloader" style="opacity: 0.0521361;">...</div>
  (Session info: chrome=75.0.3770.100)
Build info: version: '3.141.59', revision: 'e82be7d358', time: '2018-11-14T08:25:48'
System info: host: 'LAPTOP-BM04L1NK', ip: '192.168.0.104', os.name: 'Windows 8.1', os.arch: 'amd64', os.version: '6.3', java.version: '1.8.0_51'
Driver info: org.openqa.selenium.chrome.ChromeDriver
Capabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 75.0.3770.100, chrome: {chromedriverVersion: 75.0.3770.90 (a6dcaf7e3ec6f..., userDataDir: C:\Users\Sai\AppData\Local\...}, goog:chromeOptions: {debuggerAddress: localhost:54423}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}
Session ID: d6098a8ef501b1e3dcddb211df7f3151
3----------4
Mr.
Tom
Peter
Google
Mrs. 
Andrew
Audrey
Android
Dr.
Charlie
Johnson
Gynac
Starting ChromeDriver 75.0.3770.90 (a6dcaf7e3ec6f70a194cc25e8149475c6590e025-refs/branch-heads/3770@{#1003}) on port 47900
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Jul 11, 2019 10:41:23 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
before Navigate to https://www.crmpro.com/index.html
after navigate to https://www.crmpro.com/index.html
Trying to find Element By xptahBy.name: username
Trying to find Element By xptahBy.name: username
Trying to find Element By xptahBy.name: password
Trying to find Element By xptahBy.name: password
Trying to find Element By xptahBy.xpath: //input[@type='submit']
Trying to find Element By xptahBy.xpath: //input[@type='submit']
Trying to click on [[ChromeDriver: chrome on XP (93b534c69f450451ddc7539f0077a490)] -> xpath: //input[@type='submit']]
Trying to click on [[ChromeDriver: chrome on XP (93b534c69f450451ddc7539f0077a490)] -> xpath: //input[@type='submit']]
Trying to find Element By xptahBy.xpath: //a[text()='Contacts']
Trying to find Element By xptahBy.xpath: //a[text()='Contacts']
Trying to click on [[ChromeDriver: chrome on XP (93b534c69f450451ddc7539f0077a490)] -> xpath: //a[text()='Contacts']]
Trying to click on [[ChromeDriver: chrome on XP (93b534c69f450451ddc7539f0077a490)] -> xpath: //a[text()='Contacts']]
Trying to find Element By xptahBy.xpath: //a[text()='Contacts']
Trying to find Element By xptahBy.xpath: //a[text()='Contacts']
Trying to find Element By xptahBy.xpath: //a[text()='New Contact']
Trying to find Element By xptahBy.xpath: //a[text()='New Contact']
Trying to click on [[ChromeDriver: chrome on XP (93b534c69f450451ddc7539f0077a490)] -> xpath: //a[text()='New Contact']]
Trying to click on [[ChromeDriver: chrome on XP (93b534c69f450451ddc7539f0077a490)] -> xpath: //a[text()='New Contact']]
Trying to find Element By xptahBy.name: title
Trying to find Element By xptahBy.name: title
Trying to find Element By xptahBy.xpath: .//option[normalize-space(.) = "Mr."]
Trying to find Element By xptahBy.xpath: .//option[normalize-space(.) = "Mr."]
Trying to click on [[[[ChromeDriver: chrome on XP (93b534c69f450451ddc7539f0077a490)] -> name: title]] -> xpath: .//option[normalize-space(.) = "Mr."]]
Trying to click on [[[[ChromeDriver: chrome on XP (93b534c69f450451ddc7539f0077a490)] -> name: title]] -> xpath: .//option[normalize-space(.) = "Mr."]]
Trying to find Element By xptahBy.id: first_name
Trying to find Element By xptahBy.id: first_name
Trying to find Element By xptahBy.id: surname
Trying to find Element By xptahBy.id: surname
Trying to find Element By xptahBy.name: client_lookup
Trying to find Element By xptahBy.name: client_lookup
Trying to find Element By xptahBy.xpath: //input[@type='submit' and @value='Save']
Trying to find Element By xptahBy.xpath: //input[@type='submit' and @value='Save']
Trying to click on [[ChromeDriver: chrome on XP (93b534c69f450451ddc7539f0077a490)] -> xpath: //input[@type='submit' and @value='Save']]
Trying to click on [[ChromeDriver: chrome on XP (93b534c69f450451ddc7539f0077a490)] -> xpath: //input[@type='submit' and @value='Save']]
Starting ChromeDriver 75.0.3770.90 (a6dcaf7e3ec6f70a194cc25e8149475c6590e025-refs/branch-heads/3770@{#1003}) on port 34137
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Jul 11, 2019 10:42:10 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
before Navigate to https://www.crmpro.com/index.html
after navigate to https://www.crmpro.com/index.html
Trying to find Element By xptahBy.name: username
Trying to find Element By xptahBy.name: username
Trying to find Element By xptahBy.name: password
Trying to find Element By xptahBy.name: password
Trying to find Element By xptahBy.xpath: //input[@type='submit']
Trying to find Element By xptahBy.xpath: //input[@type='submit']
Trying to click on [[ChromeDriver: chrome on XP (153db08041916bb3a8553cd4f2b7d1bb)] -> xpath: //input[@type='submit']]
Trying to click on [[ChromeDriver: chrome on XP (153db08041916bb3a8553cd4f2b7d1bb)] -> xpath: //input[@type='submit']]
Trying to find Element By xptahBy.xpath: //a[text()='Contacts']
Trying to find Element By xptahBy.xpath: //a[text()='Contacts']
Trying to click on [[ChromeDriver: chrome on XP (153db08041916bb3a8553cd4f2b7d1bb)] -> xpath: //a[text()='Contacts']]
Trying to click on [[ChromeDriver: chrome on XP (153db08041916bb3a8553cd4f2b7d1bb)] -> xpath: //a[text()='Contacts']]
Trying to find Element By xptahBy.xpath: //a[text()='Contacts']
Trying to find Element By xptahBy.xpath: //a[text()='Contacts']
Trying to find Element By xptahBy.xpath: //a[text()='New Contact']
Trying to find Element By xptahBy.xpath: //a[text()='New Contact']
Trying to click on [[ChromeDriver: chrome on XP (153db08041916bb3a8553cd4f2b7d1bb)] -> xpath: //a[text()='New Contact']]
Trying to click on [[ChromeDriver: chrome on XP (153db08041916bb3a8553cd4f2b7d1bb)] -> xpath: //a[text()='New Contact']]
Trying to find Element By xptahBy.name: title
Trying to find Element By xptahBy.name: title
Trying to find Element By xptahBy.xpath: .//option[normalize-space(.) = "Mrs. "]
Trying to find Element By xptahBy.xpath: .//option[normalize-space(.) = "Mrs. "]
Trying to find Element By xptahBy.xpath: .//option[contains(., "Mrs.")]
Trying to find Element By xptahBy.xpath: .//option[contains(., "Mrs.")]
Starting ChromeDriver 75.0.3770.90 (a6dcaf7e3ec6f70a194cc25e8149475c6590e025-refs/branch-heads/3770@{#1003}) on port 40168
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Jul 11, 2019 10:42:45 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
before Navigate to https://www.crmpro.com/index.html
after navigate to https://www.crmpro.com/index.html
Trying to find Element By xptahBy.name: username
Trying to find Element By xptahBy.name: username
Trying to find Element By xptahBy.name: password
Trying to find Element By xptahBy.name: password
Trying to find Element By xptahBy.xpath: //input[@type='submit']
Trying to find Element By xptahBy.xpath: //input[@type='submit']
Trying to click on [[ChromeDriver: chrome on XP (af1301ec9984d9e788a2b543f15c3cae)] -> xpath: //input[@type='submit']]
Exception Occur  org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element <input type="submit" value="Login" class="btn btn-small"> is not clickable at point (1182, 117). Other element would receive the click: <div id="preloader" style="opacity: 0.266944;">...</div>
  (Session info: chrome=75.0.3770.100)
Build info: version: '3.141.59', revision: 'e82be7d358', time: '2018-11-14T08:25:48'
System info: host: 'LAPTOP-BM04L1NK', ip: '192.168.0.104', os.name: 'Windows 8.1', os.arch: 'amd64', os.version: '6.3', java.version: '1.8.0_51'
Driver info: org.openqa.selenium.chrome.ChromeDriver
Capabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 75.0.3770.100, chrome: {chromedriverVersion: 75.0.3770.90 (a6dcaf7e3ec6f..., userDataDir: C:\Users\Sai\AppData\Local\...}, goog:chromeOptions: {debuggerAddress: localhost:54717}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}
Session ID: af1301ec9984d9e788a2b543f15c3cae

===============================================
Suite
Total tests run: 9, Failures: 2, Skips: 2
Configuration Failures: 2, Skips: 0
===============================================

log4j:WARN No appenders could be found for logger (freemarker.cache).
log4j:WARN Please initialize the log4j system properly.

	*/
