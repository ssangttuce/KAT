package KAT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ui {
	static Scanner scanner = new Scanner(System.in);
	
	static String name = null;
	static String professor = null;
	static int day = 9999;
	static String time = null;
	
	private static void reset() {
		name = null;
		professor = null;
		day = 9999; 
		time = null;
	}
	
	private static boolean isStrEmpty(String str) {        
		return str == null || str.trim().isEmpty();    
	}
	
	private static String input(String str, String field) {
		
		String buf = null;
		do {
        	System.out.print(str+": ");
            buf = scanner.next();
            if(isStrEmpty(buf)) {
            	System.out.println(str+"을(를) 입력해 주세요.");
            	continue;
            }
            if(buf.equals("o")) {
            	 if(!isStrEmpty(field)) {
            		 break;
            	 }
            	 else
            	 {
            		 System.out.println("이전 "+str+" 정보가 없습니다.");
            		 continue;
            	 }
            }
            field = buf;
        }while(isStrEmpty(field));
		return field;
	}
	
    private static void insert(lecture_classification subject_list) {
    	System.out.println("'x'를 입력하면 강의 정보 입력을 중단합니다.");
    	while(true) {
    		
            name = input("강의명", name);
            if(name.equals("x")) {System.out.println("강의 정보 입력을 중단합니다.");
        	reset();
        	break;}
            
            professor = input("교수", professor);
            if(professor.equals("x")) {System.out.println("강의 정보 입력을 중단합니다.");
            	reset();
            	break;}
            
            do {
            	System.out.println("[월 화 수 목 금]");
                System.out.println("[0 1 2 3 4 ]");
                System.out.println("요일: ");
                day = scanner.nextInt();
                if((day >= 0 && day <= 4)) {
                	break;
                }System.out.println("정해진 범위에서 선택해 주세요.");
            }while( day != 120 );
            if(day == 120) {System.out.println("강의 정보 입력을 중단합니다.");
            	break;}
            
            System.out.println("연속된 숫자를 입력해주세요.ex) 123, 45");
            time = input("시간", time); 
            if(time.equals("x")) {System.out.println("강의 정보 입력을 중단합니다.");
            	reset();
            	break;}
            
            subject_list.classification(new lecture_info(name, professor, day, time));
    	}
    }
    
    private static void delete() {
    	int delSub, delLec;
    	while(true) {
    		if(lecture_classification.subject.size() != 0) {
        		System.out.println("삭제할 과목을 선택해주세요.");
            	for(int i = 0; i < lecture_classification.subject.size(); i++) {
            		System.out.print(i+1 + ". ");
            		System.out.println(lecture_classification.name(i));
            		System.out.println();
            	}
            	delSub = scanner.nextInt()-1;
            	if(delSub >= lecture_classification.subject.size()) {
            		continue;
            	}
            	
            	for(int i = 0; i < lecture_classification.subject.get(delSub).size(); i++) {
            		System.out.print(i+1 + ". ");
            		lecture_classification.subject.get(delSub).get(i).print_lecture();
            		System.out.println();
            	}
            	delLec = scanner.nextInt()-1;
            	if(delLec >= lecture_classification.subject.size()) {
            		continue;
            	}
            	break;
    		}
    		else {
        		System.out.println("등록된 강의가 없습니다.");return;
    		}	
    	}
        	lecture_classification.del(delSub, delLec);
    	
    }
    protected static String setFreeDay() {
    	String buf;
        System.out.print("공강인 요일을 선택하시겠습니까? Y/N ");
        String answer = scanner.next();
        if (answer.charAt(0) == 'Y') {
            while(true) {
            	System.out.print("공강 요일: ");
                buf = scanner.next();
                if(Arrays.asList(TT_gen.week).contains(buf)) {
                	System.out.print("공강 요일: "+buf);
                	return buf;
                }
                else
                	System.out.println("다시 입력하세요.");
            }
        }
        else {
            return null;
        }
    }
    
    public static void menu(lecture_classification subject_list, TT_gen tt) throws CloneNotSupportedException {
    	int key;
    	while(true) {
    		System.out.println("***********************");
        	System.out.println("*경기대 시간표 생성 프로그램 KAT*");
        	System.out.println("**********메뉴***********");
        	System.out.println("*****1. 강의 추가하기*******");
        	System.out.println("*****2. 강의 삭제하기*******");
        	System.out.println("*****3. 강의 목록 출력******");
        	System.out.println("*****4. 시간표 생성하기******");
        	System.out.println("*****5. 종료*************");
        	System.out.println("***********************");
        	
        	key = scanner.nextInt();
        	
        	switch (key) {
			case 1 -> insert(subject_list);
			case 2 -> delete();
			case 3 -> {
				for(ArrayList<lecture_info> l: lecture_classification.subject) {System.out.println();
					for(lecture_info r: l) {
						r.print_lecture();System.out.println();
					}
				}System.out.println();
			}
			case 4 -> {
				tt.FreedayReserved(setFreeDay());
				TT_gen.TT.clear();
				tt.lectureCombination(0, lecture_classification.subject.size());
				TT_gen.printTable();
			}
			case 5 -> lecture_classification.print_subjectList();
			default->
				throw new IllegalArgumentException("Unexpected value: " + key);
			}
    	}
    }
}
