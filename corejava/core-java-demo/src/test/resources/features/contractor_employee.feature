Feature: Contractor Employee Service
  As a HR manager
  I want to manage contractor employee details
  So that I can properly handle contractor-related operations

  Background:
    Given a contractor employee service is initialized

  Scenario: Show employee details
    When I call showEmployeeDetails method
    Then the show employee details functionality should be executed
    And appropriate message should be printed

  Scenario: Calculate salary for contractor
    When I call calculateSalary method
    Then the calculateSalary functionality should be executed
    And appropriate salary calculation message should be printed

  Scenario Outline: Execute multiple contractor operations
    When I call the "<method>" method
    Then the "<method>" functionality should be executed successfully

    Examples:
      | method           |
      | showEmployeeDetails |
      | calculateSalary  |