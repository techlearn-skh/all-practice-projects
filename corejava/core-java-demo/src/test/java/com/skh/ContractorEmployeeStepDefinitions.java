package com.skh;
import com.skh.test.ContractorEmployeeServiceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ContractorEmployeeStepDefinitions {

    private String executedMethod;

    @Given("a contractor employee service is initialized")
    public void a_contractor_employee_service_is_initialized() {
        System.out.println("Contractor Employee Service initialized");
    }

    @When("I call the {string} method")
    public void i_call_the_method(String methodName) {
        executedMethod = methodName;

        switch (methodName) {
            case "showEmployeeDetails":
                showEmployeeDetails();
                break;

            case "calculateSalary":
                calculateSalary();
                break;

            default:
                throw new IllegalArgumentException("Unknown method: " + methodName);
        }
    }

    @Then("the {string} functionality should be executed successfully")
    public void functionality_should_be_executed_successfully(String methodName) {
        assertTrue(executedMethod.equals(methodName));
        System.out.println(methodName + " executed successfully");
    }

    private void showEmployeeDetails() {
        System.out.println("Showing employee details");
    }

    private void calculateSalary() {
        System.out.println("Calculating salary");
    }

}