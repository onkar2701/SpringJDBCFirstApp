package in.onkar;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class TestClass {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		JdbcTemplate jd = ac.getBean("jdObj",JdbcTemplate.class);
		
		System.out.println("Enter details of Student:");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id of Student");
		int id = sc.nextInt();
		
		System.out.println("Enter Name of Student");
		String name = sc.next();
		
		System.out.println("Enter Fees of Student");
		double fees = sc.nextDouble();
		
		String sql = "INSERT INTO JDBC VALUES(?,?,?)";
				
		int count = jd.update(sql,id,name,fees);
		
		System.out.println(" Student record inserted");	
		
		
		String sql1 = "UPDATE JDBC SET NAME =? WHERE ID =?";
		int updateCount = jd.update(sql1,"Dummy",505);
		System.out.println("No of rows updated : " + updateCount);
		
		
		String sql3 = "DELETE FROM JDBC WHERE FEES = ? ";
		int deleteCount = jd.update(sql3,6662.22);
		System.out.println("No of rows deleted are : " + deleteCount);
		sc.close();
		
	}

}
