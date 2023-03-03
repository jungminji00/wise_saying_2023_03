package com.ll;
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num_m=0;
        int once_num=0;
        int d=1;
        String command;
        String wiseSaying;
        String author;
        List<WiseSaying> ws=new ArrayList<>();

        System.out.println("== 명언 앱 ==");
        System.out.print("명령) ");
        command=sc.nextLine().trim();

        while(!command.equals("종료")){
            if(command.equals("등록")){
                System.out.print("명언 : ");
                wiseSaying=sc.nextLine();

                System.out.print("작가 : ");
                author=sc.nextLine();

                ws.add(new WiseSaying(++once_num,wiseSaying,author));
                ++num_m;
                System.out.println(once_num+"번 명언이 등록되었습니다.");
            }else if(command.equals("목록")){
                if(num_m>0){
                    for(int i=0;i<num_m;i++){
                        System.out.println(ws.get(i).num + " / " + ws.get(i).wiseSaying+ " / "+ws.get(i).author);
                    }
                }
            }else if(command.equals("삭제")) {
                int id;
                System.out.print("?id=");
                id = sc.nextInt();
                try {
                    WiseSaying a = ws.get(id - d);
                    int pos = a.num;
                    if (pos != -1) {
                        ws.remove(id - d);
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                }
                if (id - d > -1) {
                    System.out.println(id + "번 명언이 삭제되었습니다.");
                    d++;
                    num_m--;
                }
            }else if(command.equals("수정")) {
                int id;
                System.out.print("?id=");
                id = sc.nextInt();
                sc.nextLine();
                String tmp_ws;
                String tmp_au ;

                WiseSaying a = ws.get(id - 1);
                int pos = a.num;

                if (pos>0) {
                    tmp_ws = ws.get(id-1).wiseSaying;
                    tmp_au = ws.get(id-1).author;

                    System.out.println("명언(기존): "+tmp_ws);
                    System.out.print("명언: ");
                    tmp_ws = sc.nextLine().trim();

                    System.out.println("작가(기존): "+tmp_au);
                    System.out.print("작가: ");
                    tmp_au = sc.nextLine().trim();

                    WiseSaying tmpclass=new WiseSaying(id,tmp_ws,tmp_au);
                    ws.set(id - 1,tmpclass);
                }
            }
            System.out.print("명령) ");
            command = sc.nextLine().trim();
        }
    }
}
class WiseSaying{
    String wiseSaying;
    String author;
    int num;

    WiseSaying(int num,String wiseSaying, String author) {
        this.num=num;
        this.wiseSaying=wiseSaying;
        this.author=author;
    }
}