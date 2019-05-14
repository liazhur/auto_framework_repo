# auto_framework_repo
Maven Java Automation Framework with Selenium WebDriver, TesNG, Allure Reporting, Log4j logging

1) Download test framework: 
git clone https://github.com/liazhur/auto_framework_repo.git 
2) Be sure that you have required browser versions, maven and java (java8). 
During implementation were used: - firefox v66.0.5 or google chrome v74.0.3729.131
3) Framework currently supports 2 types of WebDriver (ChromeDriver and FirefoxDriver). 
To change WebDriver type change BROWSER value to 'firefox' or 'chrome' in store-automation.properties file  
4) To run test navigate inside auto_framework_repo directory, then run 'mvn clean test' 
Notice: Be sure that maven was added to the Environment Path 
5) Allure reporting tool is used, so you may find reports inside ExtentReports directory after test run is complete
