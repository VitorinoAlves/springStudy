Feature: the version can be retrieved

  @studentAPI
  Scenario: Request all the students
    Given there are valid students in the database
    When I request the all the students using the API
    Then the request should return a code 200 with the list of all students

  @studentAPI
  Scenario: Create a new student
    Given I have a valid request body to create a new student
    When I sent this request body in a POST request
    Then the new student should be created in the database
    And the request should return a code 201

  @Smoke @Smoke2
  Scenario: client makes call to GET /version
    Given I can request an API
    When I request the API
    Then the API return the valid data

  @Smoke2
  Scenario: client makes call to GET /version second
    Given I can request an API
    When I request the API
    Then the API return the valid data