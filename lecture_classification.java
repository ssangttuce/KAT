package KAT;

import java.util.ArrayList;

class lecture_classification {
	protected static ArrayList<ArrayList<lecture_info>> subject = new ArrayList<ArrayList<lecture_info>>();
	
	protected void classification(lecture_info lecture) {
		
		int top = 0;
		ArrayList<lecture_info> lecBuf = new ArrayList<lecture_info>();
		lecBuf.add(lecture); 
		if(subject == null || subject.size()==0) {
			subject.add(lecBuf);
			return;
		}
		for(top = 0; top < subject.size(); top++) {
			if(subject.get(top).get(0).getName().equals(lecture.getName())) {
				subject.get(top).add(lecture);break;
			}
		} 
		if(top == subject.size()) {
			subject.add(new ArrayList<lecture_info>());
			subject.get(top).add(lecture);
		}
	}
	
	protected static String name(int index) {
		return subject.get(index).get(0).getName();
	}
	
	protected static int lecNum() {
		int sum = 0;
		for(ArrayList<lecture_info> list: subject) {
			sum += list.size();
		}
		return sum;
	}
	
	protected static void print_subjectList() {
		for(ArrayList<lecture_info> lecture_list: subject) {
			System.out.println("=========== 과목명: "+lecture_list.get(0).getName()+" ==========");
			for(lecture_info prt: lecture_list) {
				prt.print_lecture();System.out.println();
			}
		}System.out.println("==============================");
	}
	
	protected static void del(int sub, int lec) {
		lecture_info delLec;
		delLec = subject.get(sub).remove(lec);
		delLec.print_lecture();
		System.out.println(" :삭제되었습니다.");
	}
}
