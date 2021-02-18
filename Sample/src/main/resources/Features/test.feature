@Test
Feature: Validation of hotel booking

Scenario Outline:
	Given the user initiates webdriver and launch booking site
	When the user enters "<hotel_name>" Hotel details to search
		And the user clicks hotel from the list
		And the user selects Flex rate and proceeds with booking
	Then the user verifies hotel rate text
#	Then user closed the browser
	
Examples:
	|hotel_name|
	|London|
	|Manchester|
	|Leeds|
	
	
