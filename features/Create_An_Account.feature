
Feature: Create a new account
  
  Scenario: Create a new account with a new test data
    Given The user is on the landing page of the application
    And The user clicks on Create an Account link
    When The user enters all the new data in the Create New Customer Account Page
    And The user clicks on Create an Account button
    And The user gets a success message
    
    
	@Test
	Scenario Outline: Create a new account with a new test data with Data Driven Approach
			Given The user is on the landing page of the application
	    And The user clicks on Create an Account link
	    When The user enters all the new data "<FirstName>", "<LastName>", "<EmailId>", "<Pwd>", "<ConfirmPwd>" in the Create New Customer Account Page
	    And The user clicks on Create an Account button
	    Then The user gets a success message
	    And Close the application
	    
	    
	    Examples:
	    |FirstName    |LastName    |EmailId            |Pwd            |ConfirmPwd            |
	    | Amit        |Rath        |k30@test.com       |Amit&Test123   | Amit&Test123         | 
	    