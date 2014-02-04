EF Web QA Technical Task
=========

I have used JUnit testing framework. JUnit is one of the best Java library for unit testing. With JUnit, you can check that your code works as designed, without the need to set up the complete application

I have selected Selenium Webdriver java API to automate the testing of the web applications, because it was developed to provide support for modern advanced web-app testing problems. It's a good choice when you have to test web pages where elements of a page may change without the page itself being reloaded.


### Test cases

  1. Turn OFF speed update on QA test task controls and verify that the rendering on speed gauge is stopped.

  2. Turn OFF speed update on QA test task controls and verify that the rendering on speed gauge is stopped.
     Turn ON speed update on QA test task controls and verify that the rendering is started again.
  
  3. Turn OFF altitude update on QA test task controls and verify that the rendering on altitude gauge is stopped.

  4. Turn OFF altitude update on QA test task controls and verify that the rendering on altitude gauge is stopped.
     Turn ON altitude update on QA test task controls and verify that the rendering is started again.
  
  5. Turn OFF reconnect on disconnect on QA test task controls.
     Wait until connection is closed them wait for a second.
     Verify that the connection is not estabilished again.

  6. Change to Graph presentation under the gauges and verify that the graph is displayed.
     Change back to Summary presentation and verify that the speed and altitude history data presented. 

### Details

Source code:
  - WebTechTaskTests.java - Contains tests executable as JUnit test.

  - WebTechTaskDriver.java - I created an enhanced Firefox driver to handle this specific application.

Used libraries (available in repository):
  - junit-4.11.jar
  - selenium-java-2.38.0jar

Used IDE: Eclipse (you can import as project)
