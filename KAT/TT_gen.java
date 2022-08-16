package KAT;

import java.util.ArrayList;

class TT_gen {
	static final String[] week = {"월","화","수","목","금"};
	static Timetable tableBuffer;
	static ArrayList<Timetable> TT;
    

    void lectureCombination(Lecture[] lectureArchive, int depth, int lectureNum, String freeDay) throws CloneNotSupportedException {
        if (depth == lectureNum) {
            TT.add(tableBuffer.clone());
            return;
        }

        for (int i = 0; i < lectureArchive[depth].getDivisionNum(); i++) {
            boolean isReserved = false;
            
            if (week[lectureArchive[depth].division[i].getDay()].equals(freeDay)) {
                isReserved = true;
            }
            
            else {
                for (int j = 0; j < depth; j++) {//depth가 0이면 그냥 패스
                    if (tableBuffer.canRegistration(lectureArchive[depth].division[i])) {
                        isReserved = true;
                        break;
                    }
                }
            }

            if (!isReserved) {
                tableBuffer.add(lectureArchive[depth].division[i]);
                lectureCombination(lectureArchive, depth + 1, lectureNum, freeDay);
            }
        }
    }

    void printTable() {
    	int j = 0;
    	for (Timetable t:TT) {
    		System.out.println("시간표 *" + (j++) + "*");
    		for (int i = 0; i < t.div.size(); i++) {
                System.out.println("  강의(" + (i + 1) + ")");
                t.div.get(i).print_div();       
            }
            System.out.println("=======================================================");
        }
        
    }
}