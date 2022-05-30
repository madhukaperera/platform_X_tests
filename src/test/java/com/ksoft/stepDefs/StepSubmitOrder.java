package com.ksoft.stepDefs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import com.ksoft.utilities.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import com.ksoft.stepDefs.ExecReport;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class StepSubmitOrder
{
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    PropertyFileReader  fileReader = new PropertyFileReader();
    PostMessages postMessages = new PostMessages();
    DeleteMessages deleteMessages = new DeleteMessages();
    WebSocketClient webSocketClient = new WebSocketClient();

    @Given("^orderbook contains below orders$")
    public void orderbookContainsBelowOrders(List<Order> orders) throws Throwable {
         new WebSocketClient();
         postMessages.postOrders(orders);
    }

	@When("^user submits contra orders$")
	public void userSubmitsContraOrders(List<Order> contraOrders) throws Throwable {

        //new WebSocketClient(contraOrders);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String message = null;
		while (true)
		{
			message = bufferedReader.readLine();
			webSocketClient.sendMessage(message);
		}

	}

    @Then("^receives execution reports$")
    public void receivesExecutionReports(List<ExecutionReport> executionReports) throws Throwable
    {
        //ExecReport.getProcessedExecReport();
        System.out.println("@StepDef::"+ ExecReport.getProcessedExecReport());
    }

    @When("^user cancels order$")
    public void userCancelsOrder(List<CancelOrder> cancelOrders) throws Throwable {
       new WebSocketClient();
       deleteMessages.postCancelOrders(cancelOrders);
    }

    @When("^commodity instrument is in regular trading session$")
    public void commodityInstrumentIsInRegularTradingSession() throws Throwable {

    }
}
