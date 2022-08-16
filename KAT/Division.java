package KAT;

class Division {
	private String name;
    private String professor;
    private int day;
    private String time;
    
    
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

	public void print_div() {
		System.out.println("  강의명: " + getName() + "\t교수: " + getProfessor() + "\t요일: " + getDay() + "\t시간: " + getTime());
	}
}