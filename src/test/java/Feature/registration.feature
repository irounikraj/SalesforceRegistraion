Feature: Verifying registraion page 
Scenario: Verifying form with valid data 
	Given user has launched the url 
	When  has entered valid first name 
	And User has entered valid last name 
	And  user has entered valid email 
	And user has entered valid company name 
	And user has entered valid phone number 
	And user has selected jobtitle from dropdown 
	And user has selected company size 
	And User has selected country 
	And user has checked Main Services Agreement 
	Then user has clicked on start ny free trial button 
	Then validate successful registration 
	Then close  the page