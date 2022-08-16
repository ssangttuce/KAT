package KAT;

import java.util.Scanner;

class DataIO {
    static Scanner scanner = new Scanner(System.in);

    public static int setLectureNum() {
        System.out.print("과목 수: ");
        return scanner.nextInt();
    }

    public static Lecture setLectureData(int num) {
        Lecture lecture = new Lecture();

        System.out.println("과목" + (num + 1));
        System.out.print("과목명: ");
        lecture.setName(scanner.next());
        System.out.print("분반 수: ");
        lecture.setDivisionNum(scanner.nextInt());

        lecture.division = new Division[lecture.getDivisionNum()];

        for (int i = 0; i < lecture.getDivisionNum(); i++) {
            lecture.division[i] = setDivisionData(i);
        }

        return lecture;
    }

    public static Division setDivisionData(int num) {
        Division division = new Division();
 
        System.out.println("분반" + (num + 1));
        System.out.print("교수: ");
        division.setProfessor(scanner.next());
        System.out.print("요일: ");
        division.setDay(scanner.nextInt());
        System.out.print("시간: ");
        division.setTime(scanner.next());

        return division;
    }

    public static void printLectureInfo(Lecture[] archive) {
        for (int i = 0; i < archive.length; i++) {
            System.out.println("과목" + (i + 1));
            System.out.println("과목명: " + archive[i].getName());
            System.out.println("분반 수: " + archive[i].getDivisionNum());
            for (int j = 0; j < archive[i].division.length; j++) {
                System.out.println();
                System.out.println("  분반" + (j + 1));
                System.out.println("  교수: " + archive[i].division[j].getProfessor());
                System.out.println("  요일: " + archive[i].division[j].getDay());
                System.out.println("  시간: " + archive[i].division[j].getTime());
            }
            System.out.println();
        }
    }

    public static String setFreeDay() {
        System.out.print("공강인 요일을 선택하시겠습니까? Y/N ");
        String answer = scanner.next();
        if (answer.charAt(0) == 'Y') {
            System.out.print("공강 요일: ");
            return scanner.next();
        }
        else {
            return null;
        }
    }
}