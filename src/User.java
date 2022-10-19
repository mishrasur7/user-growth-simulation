
/*
User class with two fields, constructor and a single get method.
Every time when the User class is instantiated the constructor will be 
invoked and userId will be incremented automatically 
*/
public class User {

	private static int numberOfUsers = 0;
	private int userId;

	public User() {
		numberOfUsers++;
		userId = numberOfUsers;
	}

	public int getUserId() {
		return userId;
	}
}
