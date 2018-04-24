import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class SimpleGetTest {

    @Test
    public void GetWeatherDetails() {
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "/Hyderabad");

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        assertEquals("Incorrect status code returned", 200, statusCode);
        // Now let us print the body of the message to see what response
        // we have recieved from the server

        Headers allHeaders = response.getHeaders();
        String contentType = response.header("Content-Type");
        assertEquals("content type doesn't match", contentType, "application/json");

        String serverType = response.header("Server");
        assertEquals("server doesn't match", serverType, "nginx/1.12.2");

        String contentEncoding = response.header("Content-Encoding");
        assertEquals("server doesn't match", contentEncoding, "gzip");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
        assertTrue(responseBody.contains("Hyderabad"));

        JsonPath jsonPathEvaluator = response.jsonPath();
        assertEquals("City doesn't match", "Hyderabad", jsonPathEvaluator.get("City"));

    }

    @Test
    public void GetWeatherDetailsIncorrectName() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        RequestSpecification httpRequest = RestAssured.given();

        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        Response response = httpRequest.request(Method.GET, "/123456789789789");

        // Now let us print the body of the message to see what response
        // we have recieved from the server
        String responseBody = response.getBody().asString();
        int statusCode = response.getStatusCode();
        System.out.println("Response Body is =>  " + responseBody);
        System.out.println(statusCode);
        assertEquals("Incorrect status code returned", 400, statusCode);

    }


}