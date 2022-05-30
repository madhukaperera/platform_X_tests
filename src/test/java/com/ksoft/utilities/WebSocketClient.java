package com.ksoft.utilities;

import com.ksoft.stepDefs.ExecReport;
import com.ksoft.stepDefs.Order;
import gherkin.deps.com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import javax.websocket.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import static io.restassured.RestAssured.given;


@ClientEndpoint
public class WebSocketClient
{
    Session session = null;
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    static PropertyFileReader prop = new PropertyFileReader();
    static PostMessages postMessages = new PostMessages();
    static ExecReport execReport = new ExecReport();

    public WebSocketClient()
    {
        try {
            URI uri = new URI(prop.getProperty("WS_ORD_OUTPUT_SERVICE"));
            ContainerProvider.getWebSocketContainer().connectToServer(this, uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (DeploymentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public WebSocketClient(List<Order> contraOrders) throws URISyntaxException, MalformedURLException, IOException
    {
           postMessages.postOrders(contraOrders);
    }

    @OnOpen
    public void processOpen (Session session)
    {
        this.session = session;
    }

    @OnMessage
    public void processMessage (String message) throws IOException, InterruptedException {
        String json = new Gson().toJson(message);
        execReport.setReceivedExecReport(json);



    }

    public void sendMessage (String message) throws IOException {
        session.getBasicRemote().sendText(message);
    }
}

