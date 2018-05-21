package mvc.dto;

public class Writer {
	private String userid;
	private String userpw;
	private String usernick;

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsernick() {
		return usernick;
	}
	public void setUsernick(String usernick) {
		this.usernick = usernick;
	}
	
	@Override
	public String toString() {
		return "Writer [userid="+userid
				+", userpw="+userpw
				+", usernick="+usernick+"]";
	}
}
