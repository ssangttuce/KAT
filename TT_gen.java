package KAT;

import java.util.ArrayList;
import java.util.Arrays;

class TT_gen {
	protected static final String[] week = {"월","화","수","목","금"};
	protected static int freeday;
	protected static Timetable tableBuffer = new Timetable();
	protected static ArrayList<Timetable> TT = new ArrayList<Timetable>();
    
	public void FreedayReserved(String free) {
		freeday = Arrays.asList(week).indexOf(free);
		for(Timetable t: TT) {
			if(free == null) {
				break;
			}
			for(int i = 0; i < 9; i++) {
				t.schedule[freeday][i] = 1;
			}
		}
	}

    protected void lectureCombination(int depth, int lectureNum) throws CloneNotSupportedException {
        if (depth == lectureNum) {
            TT.add(tableBuffer.clone());
            
            return;
        }
        for (int i = 0; i < lecture_classification.subject.get(depth).size(); i++) {
	        if (tableBuffer.canRegistration(lecture_classification.subject.get(depth).get(i))) {
	        	tableBuffer.add(lecture_classification.subject.get(depth).get(i));
	        	lectureCombination(depth + 1, lectureNum);
	        }
        }
    }

    protected static void printTable() {
    	int j = 0;
    	for (Timetable t:TT) {
    		System.out.println("=========시간표 *" + (++j) + "* ============");
    		for(int k = 0; k < 9; k++) {
    			System.out.print("\t| ");
        		for(int i = 0; i < 5; i++) {
        			System.out.print(t.schedule[i][k]+" ");
        		}System.out.println("|");
        	}System.out.println("------------------------------");
    		for (int i = 0; i < t.coursesTaken.size(); i++) {
                System.out.println("  강의(" + (i + 1) + ")");
                t.coursesTaken.get(i).print_lecture();
                System.out.println(); 
            }
            System.out.println("==============================");
        }
        
    }
}