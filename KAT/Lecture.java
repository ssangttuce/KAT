package KAT;

class Lecture {
    private String name;
    private int divisionNum;
    protected Division[] division;
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDivisionNum() {
		return divisionNum;
	}
	public void setDivisionNum(int divisionNum) {
		this.divisionNum = divisionNum;
	}
	
	public void print_name() {
		System.out.print(getName());
	}
	
}