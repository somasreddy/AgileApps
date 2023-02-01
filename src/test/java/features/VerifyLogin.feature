Feature: Verify Login Page 
@smokeTest
Scenario Outline: Verify Login Scenarios 

	Given User opened the browser and navigated to loginPage of AgileApps 
	When User enters the <username> and <password> 
	And User clicks on Login button 
	Then I verify that the homePage is <status> opened 
	
	Examples: 
		| username  		  | password       | status |
		| sovv 				  | 123456 		   | true  	|
		| sovv 				  | apps1          | false  |
		| vvos 				  | soma@agileapp1 | false  |
#		| sovv@softwareag.com | 123456 		   | true   |
