package testClassPackage;

import java.io.IOException;
import java.time.LocalDate;

import org.testng.Assert;

import commonFunctionPackage.API_Common_Function;
import commonFunctionPackage.utility_CommonFunction;
import request_Repository_Package.post_req_repository;
import io.restassured.path.json.*;
//import java.time.LocalDateTime;

public class post_TC_1 {
	public static void execute() throws IOException
	{
		for(int i=0; i<5; i++)
		{
			int statusCode=API_Common_Function.res_statusCode(post_req_repository.base_URI(), 
					post_req_repository.post_req_TC_1(),post_req_repository.post_resource());
			
			System.out.println(statusCode);
			
			if(statusCode==201)
			{
				String responseBody=API_Common_Function.response_Body(post_req_repository.base_URI(),
						 post_req_repository.post_req_TC_1(),post_req_repository.post_resource());
				
				System.out.println(responseBody);
				
				post_TC_1.validator(responseBody, statusCode);
				utility_CommonFunction.evidenceFilecreator("post_TC_1", post_req_repository.post_req_TC_1(),responseBody);
				break;
				
			}
			
			else
			{
				System.out.println("correct status code is not found hence retrying the API");
				
			}
		}
	}
	
	
	
	
	
	public static void validator(String responseBody, int statusCode) throws IOException
	{
		JsonPath jsp=new JsonPath(responseBody);
		String res_name=jsp.getString("name");
		String res_job=jsp.getString("job");
		String res_id=jsp.getString("id");
		String res_createdAt=jsp.getString("createdAt");
		
		
		//parse req body
		JsonPath jspreq=new JsonPath(post_req_repository.post_req_TC_1());
		String req_name=jspreq.getString("name");
		String req_job=jspreq.getString("job");
		
		Assert.assertEquals(statusCode, 201);
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);
		Assert.assertNotNull(res_id);
		String currentDate=LocalDate.now().toString();
	    Assert.assertEquals(res_createdAt.substring(0,10), currentDate);

	    
	}
}
