package KAT;

import java.util.ArrayList;
import java.util.Arrays;

class Timetable implements Cloneable{

	protected int creditSum;
	protected int[][] schedule = {
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0}};
	protected ArrayList<lecture_info> coursesTaken = new ArrayList<lecture_info>();
	
	protected void clear() {
		this.creditSum = 0;
		Arrays.fill(schedule, 0);
		this.coursesTaken.clear();;
	}
	
	protected void add(lecture_info lecture) {
		this.coursesTaken.add(lecture);
		for(int i = (int)lecture.getTime().charAt(0)-49; i <= (int)lecture.getTime().charAt(lecture.getTime().length()-1)-49; i++) {
			this.schedule[lecture.getDay()][i] = 1;
		}
		this.creditSum += lecture.getTime().length();
	}
	
	protected void remove() {
		this.coursesTaken.remove(coursesTaken.size()-1);
		for(int i = (int)lecture.getTime().charAt(0)-49; i <= (int)lecture.getTime().charAt(lecture.getTime().length()-1)-49; i++) {
			this.schedule[lecture.getDay()][i] = 1;
		}
		this.creditSum += lecture.getTime().length();
	}
	
	protected boolean canRegistration(lecture_info lecture) {
		for(lecture_info check: coursesTaken) {
			if(check.getName().equals(lecture.getName())) {
				return false;
			}
		}
		for(int i = 0; i < lecture.getTime().length(); i++){
			if(schedule[lecture.getDay()][((int)lecture.getTime().charAt(i))-49] != 0) {
				return false;
			}
		}return true;
	}
	
	@Override
	protected Timetable clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Timetable)super.clone();
	}
	
}
