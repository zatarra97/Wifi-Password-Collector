
public class Wifi {
	private int id;
	private String name;
	private String pwd;
	
	public Wifi() {
		id = 000;
		name = "No Name";
		pwd = "No Password";
	}
	
	public Wifi(int number, String bssid, String password) {
		id = number;
		name = bssid;
		pwd = password;
	}
	
	public void output () {
		System.out.printf("%-5d %-10s %45s", id , name, pwd);
	}

}
