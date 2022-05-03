package scit.service;

import scit.vo.FitnessVO;

import java.util.List;

/**
<<<<<<< HEAD
 * projectName     :Fitness_v04
 * fileName        :FitnessService
 * author          :yuuna
=======
 * projectName     :Fitness_v05
 * fileName        :FitnessService
 * author          :yuuna 05/03
>>>>>>> 109d2cf (220503)
 * since           :2022/04/27
 */
public interface FitnessService {

    public int register(FitnessVO vo);

    public FitnessVO findById(String usrId);

    public List<FitnessVO> findAll();

    public int update(FitnessVO vo);

    public int delete(String id);
}
