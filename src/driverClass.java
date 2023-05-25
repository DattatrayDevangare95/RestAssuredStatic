import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import commonFunctionPackage.utility_CommonFunction;
//import testClassPackage.post_TC_1;
import testClassPackage.post_TC_1;

public class driverClass {
	public static void main(String[] args) throws IOException
	{
	post_TC_1.execute();
//		
//		ArrayList<String> testcaseRun=utility_CommonFunction.readdataexcels("Test_Runner", "TestCaseNameToExecute");
//		int count=testcaseRun.size();
//		System.out.println(count);
//		
//		for(int i=1; i<count; i++)
//		{
//			String testCaseName=testcaseRun.get(i);
//			
//			Class<?> testClassName=Class.forName("testClassPackage."+testCaseName);
//			
//			Method executeMethod=testClassName.getDeclaredMethod("execute");
//			
//			executeMethod.setAccessible(true);
//
//			Object instanceOfTestClass=testClassName.getDeclaredConstructor().newInstance();
//			
//			executeMethod.invoke(instanceOfTestClass);
//		}
	}

}
