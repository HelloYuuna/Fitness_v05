package scit.service;

import scit.vo.FitnessVO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
<<<<<<< HEAD
 * projectName     :intelli-worksapce
 * fileName        :FitnessServiceImpl
 * author          :yuuna
=======
 * projectName     :Fitness_v05
 * fileName        :FitnessServiceImpl
 * author          :yuuna 05/03
>>>>>>> 109d2cf (220503)
 * since           :2022/04/28
 */
public class FitnessServiceImpl implements FitnessService {

    List<FitnessVO> list = new ArrayList<>();					//실데이터가 담겨있는 List Collection

    public FitnessServiceImpl(){
        getFile();
    }

    @Override
    public int regist(FitnessVO vo) {
        list.add(vo);											//현재로서는 arrayList에 담는 양이 작기때문에 데이터를 못담는 경우는 없기에 대부분 성공 return 1
        return 1;
    }

    @Override
    public FitnessVO findById(String usrId) {
<<<<<<< HEAD
        FitnessVO fitness = null;
=======
>>>>>>> 109d2cf (220503)

        int num = getListPosition(usrId);
        if(num == -1)
        {
            return null;
        }

<<<<<<< HEAD
        fitness = list.get(num);

        return fitness;
=======
        return list.get(num);
>>>>>>> 109d2cf (220503)
    }

    @Override
    public List<FitnessVO> findAll() {


        return list;
    }

    @Override
    public int update(FitnessVO vo) {
<<<<<<< HEAD

        for(int i = 0; i < list.size(); i++)
        {
            if(vo.getUsrId().equals(list.get(i).getUsrId()))
            {

                return 1;
            }
=======
//        for(int i = 0; i < list.size(); i++)
//        {
//            if(vo.getUsrId().equals(list.get(i).getUsrId()))
//            {
//                list.set(i,vo);
//                return 1;
//            }
//        }
        int num = getListPosition(vo.getUsrId());

        if(num != -1) {
            list.set(num, vo);
            return 1;
>>>>>>> 109d2cf (220503)
        }

        return 0;
    }

    @Override
    public int delete(String id) {
<<<<<<< HEAD
        int num = getListPosition(id);

        if(num != -1)
        {
            list.remove(num);
            return 1;
        }
=======
//        int num = getListPosition(id);
//
//        if(num != -1) {
//            list.remove(num);
//            return 1;
//        }

        /* removeIf 사용 : return boolean */
        boolean res = list.removeIf(n -> n.getUsrId().equals(id));
//            if(n.getUsrId().equals(id)) { return true; }
//            return false;
//        });

        if(res) { return 1; }

>>>>>>> 109d2cf (220503)

        return 0;
    }

<<<<<<< HEAD
    public int getListPosition(String id) {
=======
    /**
     * 리스트의 위치값 찾기 :
     * 수정과 삭제에 이용
     * @param usrId usrId from UI
     * @return position, default -1
     */
    private int getListPosition(String usrId) {
>>>>>>> 109d2cf (220503)
        int no = -1;

        for(int i = 0; i < list.size(); i++)
        {
<<<<<<< HEAD
            if(id.equals(list.get(i).getUsrId()))
=======
            if(usrId.equals(list.get(i).getUsrId()))
>>>>>>> 109d2cf (220503)
            {
                return i;
            }
        }

<<<<<<< HEAD

=======
>>>>>>> 109d2cf (220503)
        return no;
    }

    /**
     * file
     * 프로그램 로딩되자마자 파일 로드 > 생성자에서 호출
     */
    @SuppressWarnings("unchecked")
    private void getFile() {
        File file = null;
        ObjectInputStream ois = null;

        try
        {
            file = new File("fitness.dat");

            if(!file.exists())
            {
                /* 이미 파일 존재하면 생성하지 않도록 리턴 */
                return;
            }

            /* 파일이 존재하지 않는다면 create */
            ois = new ObjectInputStream(new FileInputStream(file));
            list = (List<FitnessVO>) ois.readObject();

            ois.close();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * fileSet:
     * arrayList 에 담긴 데이터를 종료시 모두 저장
     * 저장시 해당 object 가 직렬화 되어있는지
     */
    public void setFIle() {
        File file = null;
        ObjectOutputStream oos = null;

        try {
            file = new File("fitness.dat");
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(list);

            oos.close();

        } catch(IOException e) {
            e.printStackTrace();			//오류를 화면에 찍어줌
        }


    }
}
