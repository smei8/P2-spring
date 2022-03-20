import com.ers.expensesys2.service.UserServiceImpl;

public class Test {

	public static void main(String[] args) {
		
		UserServiceImpl userSerivce = new UserServiceImpl();
		
		userSerivce.fetchAllAccounts();
	}

}
