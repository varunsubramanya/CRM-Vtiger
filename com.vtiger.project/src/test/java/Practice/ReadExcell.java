package Practice;


import com.vtiger.genericUtility.ExcellUtility;

public class ReadExcell {
	
	public static void main(String[] args) throws Throwable {
		
		ExcellUtility eu=new ExcellUtility();
		
		String un = eu.getExcelValue("Login",1,0);
		System.out.println(un);
		String pwd = eu.getExcelValue("Login",1,1);
		System.out.println(pwd);
		String data = eu.getExcelValue("TestData",1,2);
		System.out.println(data);
		
		
	}

}
