package com.ksoft.utilities;

import com.ksoft.stepDefs.CancelOrder;
import com.ksoft.stepDefs.Order;
import gherkin.deps.com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import javax.websocket.Session;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import static io.restassured.RestAssured.given;

public class DeleteMessages
{

    Session session = null;
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    static PropertyFileReader prop = new PropertyFileReader();

    public void postCancelOrders (List<CancelOrder> cancelRequest) throws MalformedURLException, URISyntaxException
    {
        URI uri = new URI(prop.getProperty("HTTP_DELETE_ORDER_SERVICE"));
        URL url = uri.toURL();
        //System.out.println(url);

        for (CancelOrder cancelOrderList : cancelRequest) {
            String json = new Gson().toJson(cancelOrderList);
            System.out.println("Order Successfully Cancelled--------/"+json+"\n");
            response = given().contentType(ContentType.JSON).body(json).when().delete(url);
            //System.out.println("OrderID received as---------/" + response.jsonPath().get("id"));
        }
    }
}
