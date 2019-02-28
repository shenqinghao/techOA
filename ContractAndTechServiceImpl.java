package cn.edu.tju.service.business.contract.impl;

import static cn.edu.tju.base.util.AssertThrowUtil.$;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.tju.controller.contract.vo.ContractAndTechVo;
import cn.edu.tju.controller.contract.vo.QueryContractEntity;
import cn.edu.tju.dao.business.contract.ContractFormDao;
import cn.edu.tju.model.business.contract.ContractForm;
import cn.edu.tju.service.business.contract.ContractAndTechService;
import cn.edu.tju.service.business.contract.ContractFormRService;
import cn.edu.tju.service.business.contract.ContractPartiesService;
import cn.edu.tju.service.user.UserService;

@Service
public class ContractAndTechServiceImpl implements ContractAndTechService{
	
	@Autowired
	ContractFormRService contractFormRService;
	
	@Autowired
	UserService userService;

	@Override
	public ContractAndTechVo queryContractByTech(String id) {
		
		$("合同ID不能为空", id);
		ContractAndTechVo contractAndTechVo = new ContractAndTechVo();
		QueryContractEntity queryContractEntity = contractFormRService.query(id);
		String workNum = userService.selectByPrimaryKey(queryContractEntity.getDirectorUserId()).getWorkNum();
		/**
		 * 状态4表示已办结
		 */
		if(queryContractEntity.getStatus()==4) {
			BeanUtils.copyProperties(queryContractEntity, contractAndTechVo);
			contractAndTechVo.setWorkNum(workNum);
			return contractAndTechVo;
		}else {
			return null;
		}
		
	}

	
}
