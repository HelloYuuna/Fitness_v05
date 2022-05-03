package scit.service;

import scit.vo.FitnessVO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * projectName     :intelli-worksapce
 * fileName        :FitnessServiceImpl
 * author          :yuuna
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
        FitnessVO fitness = null;

        int num = getListPosition(usrId);
        if(num == -1)
        {
            return null;
        }

        fitness = list.get(num);

        return fitness;
    }

    @Override
    public List<FitnessVO> findAll() {


        return list;
    }

    @Override
    public int update(FitnessVO vo) {

        for(int i = 0; i < list.size(); i++)
        {
            if(vo.getUsrId().equals(list.get(i).getUsrId()))
            {

                return 1;
            }
        }

        return 0;
    }

    @Override
    public int delete(String id) {
        int num = getListPosition(id);

        if(num != -1)
        {
            list.remove(num);
            return 1;
        }

        return 0;
    }

    public int getListPosition(String id) {
        int no = -1;

        for(int i = 0; i < list.size(); i++)
        {
            if(id.equals(list.get(i).getUsrId()))
            {
                return i;
            }
        }


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
