import com.lin.dao.EmployeeDao;
import com.lin.pojo.Employee;
import com.lin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
        @org.junit.Test
        public void test(){
            Employee employee=new Employee();
            employee.setName("小刘");
            ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
            EmployeeService employeeService= (EmployeeService) context.getBean("employeeService");
            EmployeeDao employeeDao= (EmployeeDao) context.getBean("employeeDao");
            System.out.print("你好！"+employeeService.get(1));
        }
}
