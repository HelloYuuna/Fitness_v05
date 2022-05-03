package scit.ui;

import scit.service.FitnessServiceImpl;
import scit.vo.FitnessVO;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

/**
<<<<<<< HEAD
 * projectName     :Fitness_v04
 * fileName        :FitnessUI
 * author          :yuuna
=======
 * projectName     :Fitness_v05
 * fileName        :FitnessUI
 * author          :yuuna 05/03
>>>>>>> 109d2cf (220503)
 * since           :2022/04/27
 */
public class FitnessUI {
    FitnessServiceImpl service = new FitnessServiceImpl();
    Scanner sc = new Scanner(in);

    public FitnessUI(){
        select();

    }

    /**
     * 메뉴 선택
     */
    public void select(){
        String select;

        while(true){
            menu();
            select = sc.next();
            switch(select){
                case "1": input(); break;
                case "2": output(); break;
                case "3": search(); break;
                case "4": delete(); break;
                case "5": update(); break;
                case "0":
                    out.println("시스템을 종료해!");
                    service.setFIle();
                    return;
                default: err.println("잘못된 선택이야!");
            }
        }
    }

    /**
     * 메뉴 호출
     */
    public void menu(){
        out.println("----------------------------");
        out.println("\t회원 관리 프로그램");
        out.println("----------------------------");
        out.println("\t 1. 회원  가입");
        out.println("\t 2. 전체  출력");
        out.println("\t 3. 회원  검색");
        out.println("\t 4. 회원  삭제");
        out.println("\t 5. 회원  수정");
        out.println("\t 0. 이거  종료");
        out.println("----------------------------");
        out.print("\t 선택> ");
    }


    /**
     *  회원가입
     */
    public void input(){
        String usrId;
        String usrName;
        double height;
        double weight;

        out.println("\n\t[ 신규 회원 등록 ]");

        while(true)
        {
            out.print("회원 아아디: ");
            usrId = sc.next();


            /* 중복 usrId CHECK */
            FitnessVO fitness = service.findById(usrId);

            if(fitness != null)
            {
                out.println("이미 존재하는 아이디야! 다시 입력해줘!");
//                continue;											//같은 아이디있으면 반복문으로 돌아감

            } else {
                out.print("회원 이름: ");
                usrName = sc.next();

                out.print("키: ");
                height = sc.nextDouble();

                out.print("몸무게: ");
                weight = sc.nextDouble();

                fitness = new FitnessVO(usrId, usrName, height, weight);
                service.regist(fitness);
                out.println("\t\t[ 회원가입 완료! ]\n");

                return;
            }
        }



    }

    /**
     * 전체 출력
     */
    public void output(){
        List<FitnessVO> list = service.findAll();
        if(list.isEmpty()) {
            out.println("등록된 회원이 없어! 우선 가입부터 하자!");
            out.println();
            return;
        }

        out.println("\n\t[ 전체 회원 리스트 ]");
        for(FitnessVO tmp : list)
        {
            out.println(tmp);
        }

        out.println();
    }


    /**
     * 특정 회원 검색
     */
    public void search(){
        String usrId;

        /* 아무도 없다면? */
        List<FitnessVO> list = service.findAll();
        if(list == null)
        {
            out.println("우선 가입부터 하자!");
            return;
        }

        while(true) {
            out.print("찾는 회원의 아이디가 뭐야? >");
            usrId = sc.next();

            FitnessVO fitness = service.findById(usrId);
            if(fitness == null)
            {
                out.println("존재하지 않는 회원이야!");
                continue;
            }

            out.println("\n너가 찾는 회원이야!");
            out.println(fitness);

            out.println();
            return;
        }
    }

    public void delete(){
        String usrId;

        /* 아무도 없다면? */
        List<FitnessVO> list = service.findAll();
        if(list.isEmpty())
        {
            out.println("우선 가입부터 하자!");
            return;
        }

        out.print("탈퇴할 회원의 아이디가 뭐야? >");
        usrId = sc.next();

        FitnessVO fitness = service.findById(usrId);
        if(fitness == null)
        {
            out.println("존재하지 않는 회원이야!");
<<<<<<< HEAD
=======
            return;
>>>>>>> 109d2cf (220503)
        }

        out.println("\n" + fitness);
        out.print("이 회원 정말 탈퇴해?(y/n) >");
        String answer = sc.next();

        if(!answer.equals("y")){
            out.println("탈퇴 취소할께!");
            return;
        }

        int num = service.delete(usrId);
        if(num == 1)
        {
            out.println("정상적으로 탈퇴되었어!");
        }
    }

    public void update(){
        String usrId;
        double weight;
        double height;

        /* 아무도 없다면? */
        List<FitnessVO> list = service.findAll();
        if(list.isEmpty())
        {
            out.println("우선 가입부터 하자!");
            return;
        }

        /* 회원 조회 */
        out.print("수정할 회원의 아이디가 뭐야? >");
        usrId = sc.next();

        /* 아이디유무 체크 */
        FitnessVO fitness = service.findById(usrId);
        if(fitness == null)
        {
            out.println("존재하지 않는 회원이야!");
<<<<<<< HEAD
            return;
=======
            return;                                     //TODO Return "Null"
>>>>>>> 109d2cf (220503)
        }

        out.println("이 회원을 수정할꺼야!");
        out.println(fitness + "\n");

        out.print("새롭게 수정할 키를 알려줘! >");
        height = sc.nextDouble();

        out.print("새롭게 수정할 몸무게를 알려줘! >");
        weight = sc.nextDouble();

        fitness.setHeight(height);
        fitness.setWeight(weight);
        service.update(fitness);

        out.println(fitness);
        out.println("\t\t[ 회원수정 완료! ]\n");

    }

}
