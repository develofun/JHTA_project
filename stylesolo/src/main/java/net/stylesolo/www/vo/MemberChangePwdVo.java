package net.stylesolo.www.vo;

public class MemberChangePwdVo {
	private String id;
	private String pwd;
	private String changepwd;
	
	public MemberChangePwdVo() {}

	public MemberChangePwdVo(String id, String pwd, String changepwd) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.changepwd = changepwd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getchangepwd() {
		return changepwd;
	}

	public void setchangepwd(String changepwd) {
		this.changepwd = changepwd;
	}
}
