package KAT;

class lecture_info {
	private String name;
    private String professor;
    private int day;
    private String time;
    
    
    public lecture_info(String name, int day, String time) {
    	this.name = name;
    	this.professor = "-";
    	this.day = day;
    	this.time = time;
    }
    public lecture_info(String name, String professor, int day, String time) {
    	this.name = name;
    	this.professor = professor;
    	this.day = day;
    	this.time = time;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	public void print_lecture() {
		System.out.print(" 과목명: " + getName() + "\s교수: " + getProfessor() + "\s요일: " + getDay() + "\s시간: " + getTime());
	}
}