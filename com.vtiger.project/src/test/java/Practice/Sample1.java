package Practice;

import java.util.Date;

public class Sample1 {
public static void main(String[] args) {
	Date date = new Date();
	String systemDateTime = date.toString();
	String[] today = systemDateTime.split(" ");
	String day = today[0];
	String month = today[1];
	String DaTe = today[2];
	String year = today[5];
	
	String conCatDate=day+" "+month+" "+DaTe+" "+year;
	System.out.println(conCatDate);
}
}
