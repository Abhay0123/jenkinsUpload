package Demo;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TrelloAPI {
// i am going to test all the end-points of the Trello.
// i want to create the baseurl bcz it is common to all the end-points

public static String baseurl ="https://api.trello.com";
public static String key ="a9eb326972b70013fd473e3f9c983555";
public static String token ="ATTA6d6e7deb608147de643fc5a855c4309c87c8a0a0b34a1ac6ce9643568fcac7b5795AAD1D";
public static String id;


@Test(priority=1)
public void CreateBoard(){
       // Rest:- assured we work with the below aspect
       // given: request - contains body, headers:- authorisation-content-type, queryparameter
	   // when: resource/board (this will have only resource)
	   // then: response- assertion - string format -- jsonpath()
	   // this is to pass my baseurl
	   // restAssured is a class which takes baseURI		
	   RestAssured.baseURI = baseurl;
	
	   // i have to use pre-condition
	   Response  response = given().queryParam("name", "new board")
	   .queryParam("key", key)
	   .queryParam("token", token)
	   .header("Content-Type", "application/json")
	   //when used for post -action
	   .when()
	   .post("/1/boards")
	
	   .then()
	   .assertThat().statusCode(200).contentType(ContentType.JSON)
	   .extract().response();
	   //This below code will get the response in the string format and store in the json format variable
	   String jsonresponse  = response.asString();
	   // This should print entire response
	   System.out.println(jsonresponse);
	   // the below code convert my entire response into Json object
	   JsonPath js = new JsonPath(jsonresponse);
	   // This is to fetch the specific id
	   id  = js.get("id");
	   System.out.println("board id"+" "+id);
	}

    @Test(priority=2)
    public void getBoard() {
    	  RestAssured.baseURI = baseurl;
    	  Response  response = given()
    	 .queryParam("key", key)
    	 .queryParam("token",token)		 
     	 .header("Content-Type", "application/json")                           
 	     .when()
	     .get("/1/boards/" + id + "/")
	     .then()
	     .assertThat().statusCode(200).contentType(ContentType.JSON)
	     .extract().response();
    	  String jsonresponse  = response.asString();
   	      System.out.println(jsonresponse);
    	  JsonPath js = new JsonPath(jsonresponse);
    	  System.out.println(js);
    	  System.out.println("get the board by using id");
   	   
    }
    
@Test(priority=3)
public void updatetBoard() {
	  RestAssured.baseURI = baseurl;
	  Response  response = given().queryParam("name", "board updated")
	 .queryParam("desc","learn update board of trello")
	 .queryParam("key", key)
	 .queryParam("token", token)
	 .header("Content-Type", "application/json")                           
	 .when()
     .put("/1/boards/" +id)
     .then()
     .assertThat().statusCode(200).contentType(ContentType.JSON)
     .extract().response();
	  String jsonresponse  = response.asString();
	  System.out.println(jsonresponse);
	  JsonPath js = new JsonPath(jsonresponse);
	  System.out.println(js);
	  System.out.println("Update the board by name and desc");
	   
} 

@Test(enabled=false)      
public void deleteBoard() {
	  RestAssured.baseURI = baseurl;
	  Response  response = given()
	 .queryParam("key", key)
	 .queryParam("token",token)
	 .when()
	 .delete("1/boards/"+id+"/").then().contentType(ContentType.JSON)
	 .extract().response();
	  String jsonresponse  = response.asString();
	  System.out.println(jsonresponse);
	  System.out.println("Board is deleted");
}


}
