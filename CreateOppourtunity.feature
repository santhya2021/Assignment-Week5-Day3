Feature: Login to Salesforce Application

Scenario: Login to Positive Data

Given Launch Browser and load the sales url an maximize screen
And Enter the username as 'hari.radhakrishnan@qeagle.com'
And Enter the password as 'Leaf@1234'
And click on LoginButton
And click on App Launcher
And click on View All
When click on Sales
And click on Opportunities
And click on New Button
And Enter the opportunities name as Salesforce Automation By Santhya
And Enter Date as '4/26/2023'
And Enter stage as Need Analysis
And click on save button
Then verify opportunity created successfully
 