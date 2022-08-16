package KAT;

import java.util.ArrayList;

class Timetable implements Cloneable{
	protected int creditSum;
	protected int[][] schedule = {
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0}};
	protected ArrayList<Division> div;
	
	protected void add(Division division) {
		this.div.add(division);
		for(int i = (int)division.getTime().charAt(0)-48; i < (int)division.getTime().charAt(division.getTime().length()-1)-48; i++) {
			this.schedule[division.getDay()][i-1] = 1;
		}
		this.creditSum += division.getTime().length();
	}
	
	protected boolean canRegistration(Division division) {
		for(int i = 0; i < division.getTime().length(); i++){
			if(schedule[division.getDay()][(int)division.getTime().charAt(i)-48] == 0) {
				return true;
			}
		}return false;
	}
	
	@Override
	protected Timetable clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Timetable)super.clone();
	}
	
}
