package KAT;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 수강 예정인 강의 수 입력
        int lectureNum = DataIO.setLectureNum();
        Lecture[] lectureArchive = new Lecture[lectureNum];

        //강의 및 분반 정보 입력
        for (int i = 0; i < lectureNum; i++) {
            lectureArchive[i] = DataIO.setLectureData(i);
        }

        // 테스트용 출력 코드
        /* System.out.println("====================\n        결과\n===================="); */
        /* KAT.DataIO.printLectureInfo(lectureArchive); */

        // 공강 요일 입력
        String freeDay = DataIO.setFreeDay();

        /* 점심시간 확보 기능 추가 예정 */

        // 시간표 메모리 생성
        TT_gen table = new TT_gen();

        // 시간표 조합
        table.lectureCombination(lectureArchive, 0, lectureNum, freeDay);

        // 시간표 출력
        table.printTable();
    }
}