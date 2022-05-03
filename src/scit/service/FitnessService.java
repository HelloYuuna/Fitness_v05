package scit.service;

import scit.vo.FitnessVO;

import java.util.List;

/**
 * projectName     :Fitness_v04
 * fileName        :FitnessService
 * author          :yuuna
 * since           :2022/04/27
 */
public interface FitnessService {

    public int regist(FitnessVO vo);

    public FitnessVO findById(String usrId);

    public List<FitnessVO> findAll();

    public int update(FitnessVO vo);

    public int delete(String id);
}
