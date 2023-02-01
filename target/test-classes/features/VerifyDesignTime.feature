Feature: Verify Design Time Page 
@Regression
Scenario: Verify DesignTime is Opened 
	Given user is logged into RunTime of AgileApps 
	When user clicks on the configuration icon 
	Then user is navigated to designtime in newtab
	And Logout from the Application