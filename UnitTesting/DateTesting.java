import java.sql.Date;


public class DateTesting {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		java.util.Date d=new java.text.SimpleDateFormat("dd/mm/yyyy").parse("25/10/2019");
		java.util.Date d1=new java.text.SimpleDateFormat("dd/mm/yyyy").parse("25/11/2019");
		
		System.out.println("d="+d.getTime());
		System.out.println("d1="+d.getTime());
	}
	}


