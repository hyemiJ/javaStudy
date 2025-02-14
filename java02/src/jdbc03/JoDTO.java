package jdbc03;

import jdbc02.StudentDTO;

public class JoDTO extends StudentDTO {
	private int jno;
	private String jname;
	private int captain;
	private String project;
	private String slogan;
	
	
	//생성자
	public JoDTO() {
		super();
	}
		
	public JoDTO(int jno, String jname, int captain, String project, String slogan) {
		super();
		this.jno = jno;
		this.jname = jname;
		this.captain = captain;
		this.project = project;
		this.slogan = slogan;
	}
	
	//setter
	public int getJno() {
		return jno;
	}

	public void setJno(int jno) {
		this.jno = jno;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public int getCaptain() {
		return captain;
	}

	public void setCaptain(int captain) {
		this.captain = captain;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	@Override
	public String toString() {
		return "JoDTO [jno=" + jno + ", jname=" + jname + ", captain=" + captain +
				", name = "+getName() +", age = "+getAge()+", project=" + project + ", slogan="
				+ slogan + "]";
	}

	

	
	
	
}
