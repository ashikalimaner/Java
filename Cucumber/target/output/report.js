$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/jmanera/Documents/Document/Java work/Cucumber/features/Myapplication.feature");
formatter.feature({
  "line": 2,
  "name": "Test Facebook Smoke Scenario",
  "description": "",
  "id": "test-facebook-smoke-scenario",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@FacebookTesting"
    }
  ]
});
formatter.background({
  "line": 6,
  "name": "Test login with valid credentials",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "Open chrome and start application",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I enter valid  \"8788948300\" and \"ashikalimaner\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "user should be able to login successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "BackGround.given()"
});
formatter.result({
  "duration": 17975968257,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "8788948300",
      "offset": 16
    },
    {
      "val": "ashikalimaner",
      "offset": 33
    }
  ],
  "location": "BackGround.i_enter_valid_and(String,String)"
});
formatter.result({
  "duration": 763499766,
  "status": "passed"
});
formatter.match({
  "location": "BackGround.then()"
});
formatter.result({
  "duration": 7004880492,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Search and Find friend on facebook",
  "description": "",
  "id": "test-facebook-smoke-scenario;search-and-find-friend-on-facebook",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@FriendRequest"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "Enter search in Search Box",
  "rows": [
    {
      "cells": [
        "ashikali"
      ],
      "line": 14
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "click search",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "I should get my friend in the list and send him friend request",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginDefination.enter_in_Search_Box(DataTable)"
});
formatter.result({
  "duration": 8329420483,
  "status": "passed"
});
formatter.match({
  "location": "LoginDefination.when1()"
});
formatter.result({
  "duration": 3165790165,
  "status": "passed"
});
formatter.match({
  "location": "LoginDefination.then1()"
});
formatter.result({
  "duration": 8748560649,
  "status": "passed"
});
});