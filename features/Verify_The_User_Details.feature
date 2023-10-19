
Feature: Verify the user details in the Dashboard Page

Background: Steps common for all scenarios
	Given The user is on the landing page of the application

  @Test
  Scenario Outline: Verify the user details after successful creation of Account 
    
	    And The user clicks on Create an Account link
	    When The user enters all the new data "<FirstName>", "<LastName>", "<EmailId>", "<Pwd>", "<ConfirmPwd>" in the Create New Customer Account Page
	    And The user clicks on Create an Account button
	    Then The user gets a success message
	    And Verify the user Details are displayed correctly "<AccountType>"
 
     Examples:
     
	    |FirstName    |LastName    |EmailId             |Pwd            |ConfirmPwd            |AccountType|
	    | Amit        |Rath        |k108@test.com       |Amit&Test123   | Amit&Test123         | New       |

	@Test
	Scenario Outline: Verify the user details when the user is already registered. 
    Given The user is on the landing page of the application
	    And The user clicks on SignIn link
	    When The user enters "<EmailId>", "<Pwd>" in the Customer Login Page
	    And The user clicks on SignIn button
	    Then The user lands into the Dashboard Page
	    And Verify the user Details are displayed correctly "<AccountType>"
	   
	  Examples:
	  |EmailId    |Pwd         |AccountType|
	  |h3@test.com|Amit&Test123|Existing   |