package smartfx.project.models;

public class User {
	protected String login;
	protected String password;
	private int id;
	public User(String login,String password) {
		this.login=login;
		this.password=password;
	}
	public User(int id,String login,String password) {
		this.login=login;
		this.password=password;
		this.id=id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static void authenticate() {

	}
}
