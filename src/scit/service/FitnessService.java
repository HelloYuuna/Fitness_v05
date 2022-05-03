package scit.service;

import scit.vo.FitnessVO;

import java.util.List;

/**
 * projectName     :Fitness_v05
 * fileName        :FitnessService
 * author          :yuuna 05/03
 * since           :2022/04/27
 */
public interface FitnessService {

    public void register(FitnessVO vo);

    public FitnessVO findById(String usrId);

    public List<FitnessVO> findAll();

    public void update(FitnessVO vo);

    public int delete(String id);
}
