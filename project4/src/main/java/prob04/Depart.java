package prob04;

public class Depart extends Employee{
	String department;
	
	public Depart(String name, int salary, String department) {
		super(name, salary);	//이렇게 부모 생성자 불러서 세팅하자
		this.department=department;
	}
	
	@Override
	public void getInformation() {
		System.out.println( "이름: " + getName() + " 연봉:" + getSalary()+ " 부서:"+ department );
	}
}
