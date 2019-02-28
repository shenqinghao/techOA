package cn.edu.tju.service.business.contract;

import java.util.List;

import cn.edu.tju.controller.contract.vo.ContractAndTechVo;

/**
 * 

* <p>Title: ContractAndTechService</p>  

* <p>Description: 科技部对接合同</p>  

* @author shenqinghao  

* @date 2018年12月28日
 */
public interface ContractAndTechService {
	
	ContractAndTechVo queryContractByTech(String id);
}
