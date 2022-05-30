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
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class PostMessages
{
    Session session = null;
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    static PropertyFileReader prop = new PropertyFileReader();

    public void postOrders (List<Order> orderToSubmit) throws MalformedURLException, URISyntaxException {

        URI uri = new URI(prop.getProperty("HTTP_POST_ORDER_SERVICE"));
        URL url = uri.toURL();
        //System.out.println(url);

        for (Order orderList : orderToSubmit) {
            String json = new Gson().toJson(orderList);
            System.out.println("Order Successfully Submitted--------/"+json+"\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            response = given().contentType(ContentType.JSON).body(json).when().post(url);
            //System.out.println("OrderID received as---------/" + response.jsonPath().get("id"));
        }
    }
}
