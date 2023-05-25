package request_Repository_Package;

import java.io.IOException;
import java.util.ArrayList;

import commonFunctionPackage.utility_CommonFunction;

public class post_req_repository {
	
	public static String base_URI()
	{
		String baseURI="https://reqres.in";
		return baseURI;
	}
	
	public static String post_resource()
	{
		String resource="api/users";
		return resource;
	}
	
	public static String post_req_TC_1() throws IOException
	{
		ArrayList<String> data=utility_CommonFunction.readdataexcels("Post_Test_Data", "post_TC_2");
		String req_name=data.get(1);
		String req_job=data.get(2);
		
		String requestBody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		
		return requestBody;
	}
}
