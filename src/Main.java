import java.util.ArrayList;
//------------------------------------------------EMPLOYEE--------------------------------------------------------------
abstract class Employee{
    private String name;
    private int id;
    public Employee(String name,int id)
    {
        this.name=name;
        this.id=id;
    }
    public int getId()
    {
        return id;
    }
    public abstract double calculateSalary();
//    If you print any object, Java compiler internally invokes the toString() method on the object.
//    So overriding the toString() method, returns the desired output, it can be the state of an object etc.
//    depending on your implementation.
    @Override
    public String toString()
    {
        return "Employee[name="+name+",id="+id+",salary="+calculateSalary()+"]";
    }
}
//------------------------------------------FULL TIME EMPLOYEE----------------------------------------------------------
class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(String name,int id,double monthlySalary)
    {
        super(name,id);
        this.monthlySalary=monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}
//------------------------------------------PART TIME EMPLOYEE----------------------------------------------------------
class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;
    public PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate)
    {
        super(name, id);
        this.hourlyRate=hourlyRate;
        this.hoursWorked=hoursWorked;
    }
    @Override
    public double calculateSalary()
    {
        return hoursWorked*hourlyRate;
    }
}
//---------------------------------------------PAY ROLL SYSTEM----------------------------------------------------------
class PayrollSystem{
//    By using ArrayList<Employee>, you ensure that the employeeList can hold any object
//    that is an instance of the Employee class or its subclasses.

    private ArrayList<Employee> employeeList;
    public PayrollSystem()
    {
        employeeList=new ArrayList<>();
    }
//    -------------1.method to add employee-----------------
    public void addEmployee(Employee employee)
    {
        employeeList.add(employee);
    }
//   --------------2.method to remove employee--------------
    public void removeEmployee(int id)
    {
        Employee employeeToRemove=null;
        for (Employee employee:employeeList)
        {
            if (employee.getId()==id)
            {
                employeeToRemove=employee;
                break;
            }
        }
        if (employeeToRemove!=null)
        {
            employeeList.remove(employeeToRemove);
        }
    }
//    -------------3.method to display employee----------------
//    System.out.println(employee): Calls the toString() method of the employee object implicitly.
//    This is because println calls the toString() method of the object it receives to get its string representation.
    public void displayEmployees()
    {
        for (Employee employee:employeeList)
        {
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem=new PayrollSystem();
        FullTimeEmployee employee1=new FullTimeEmployee("Wasim",1,70000.0);
        PartTimeEmployee employee2=new PartTimeEmployee("Barik",2,40,100);

        payrollSystem.addEmployee(employee1);
        payrollSystem.addEmployee(employee2);

        System.out.println("-------INITIAL EMPLOYEES DETAILS--------");
        payrollSystem.displayEmployees();
        payrollSystem.removeEmployee(2);
        System.out.println();
        System.out.println("----------REMAINING EMPLOYEES-----------");
        payrollSystem.displayEmployees();
    }
}