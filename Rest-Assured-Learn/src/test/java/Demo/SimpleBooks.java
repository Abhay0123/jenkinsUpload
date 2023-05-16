//package Demo;
//import static io.restassured.RestAssured.given;
//import org.testng.annotations.Test;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//
//public class SimpleBooks {
//	
//	public static String baseurl ="https://simple-books-api.glitch.me";
//	public static String token;
//	public static String bookId;
//	public static String order_id;
//	@Test(priority  = 0)
//	public void createBoard(){
//		    String RequestBody= "{\r\n"
//		   		+ "				   \"clientName\": \"Abhay21\",\r\n"
//		   		+ "				   \"clientEmail\": \"Pathak21@example.com\"\r\n"
//		   		+ "}";
//		   
//		   RestAssured.baseURI = baseurl;
//		   Response  response = given()
//		   .header("Content-Type", "application/json")
//		   //when used for post -action
//		   .body(RequestBody)
//		   .when()
//		   .post("/api-clients/")
//		    
//		   .then()
//		   .assertThat().statusCode(201).contentType(ContentType.JSON)
//		   .extract().response();
//		 
//		   String jsonresponse  = response.asString();
//		   System.out.println(jsonresponse);
//		   
//		   JsonPath js = new JsonPath(jsonresponse);
//		   // This is to fetch the specific id
//		   token = js.get("accessToken");
//		   System.out.println(token);
//	}
//	
//      @Test(priority = 1)
//	  public void orderBook() {
//		  String RequestBody = "{\r\n"
//		  		+ "  \"bookId\": 1,\r\n"
//		  		+ "  \"customerName\": \"John\"\r\n"
//		  		+ "}";
//		    
//		  //  RestAssured.baseURI = baseurl;
//		    Response  response = given()
//		   .header("Content-Type", "application/json")
//		   .header("Authorisation","Bearer "+token)
//		    
//		   //when used for post -action
//		   .body(RequestBody)
//		   .when()
//		   .post("/orders")
//		    
//		   .then()
//		  // .assertThat().statusCode(201).contentType(ContentType.JSON)
//		   .extract().response();
//		    
//		   String jsonresponse  = response.asString();
//		   System.out.println(jsonresponse);
//		   
//		   JsonPath js = new JsonPath(jsonresponse);
//		   order_id = js.get("order_id");
//		   System.out.println(order_id);
//		  }
//	
//}
