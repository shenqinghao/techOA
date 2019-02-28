package cn.edu.tju.controller.contract;

import javax.validation.Valid;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.edu.tju.base.util.TokenUtil;
import cn.edu.tju.base.util.Unicode;
import cn.edu.tju.controller.contract.vo.ContractAndTechVo;
import cn.edu.tju.service.business.contract.ContractAndTechService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/contract")
@Api(description = "业务模块-合同与科技对接相关接口")
public class ContractAndTechController {
	@Autowired
	private TokenUtil tokenUtil;
	
	@Autowired
	ContractAndTechService contractAndTechService;
	
	@ApiOperation(value = "合同与科技对接")
	@RequestMapping(value = "doPost", method = RequestMethod.POST)
	public ContractAndTechVo doPost(@RequestBody @Valid String id) {
		HttpPost httpPost = null;
		JSONObject response = null;
		try {
			HttpClient client = HttpClients.createDefault();
			httpPost = new HttpPost("http://127.0.0.1:9090/tech/ContractCommServlet");
			//httpPost = new HttpPost("http://127.0.0.1:8080/tjuoa/contract/query");
			//设置请求头,并不是中文乱码的原因
			httpPost.setHeader("Accept","application/json, text/plain, */*");
            httpPost.setHeader("Cache-Control","no-cache");
            httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
			//获取要传送的内容
			ContractAndTechVo contractAndTechVo = contractAndTechService.queryContractByTech(id);
			System.out.println(contractAndTechVo.getId());
			System.out.println(contractAndTechVo.toString());
			ObjectMapper om = new ObjectMapper();
			String jsonContractAndTechVoUnicode = om.writeValueAsString(contractAndTechVo);
			System.out.println(jsonContractAndTechVoUnicode);
			String jsonContractAndTechVo = Unicode.chinaToUnicode(jsonContractAndTechVoUnicode);
			System.out.println(jsonContractAndTechVo);
			//封装传送
			StringEntity s = new StringEntity(jsonContractAndTechVo);
			s.setContentEncoding("UTF-8");
			s.setContentType("application/json");
			httpPost.setEntity(s);
			HttpResponse res = client.execute(httpPost);
			System.out.println(res.getStatusLine().getStatusCode());
			if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String result = EntityUtils.toString(res.getEntity());// 返回json格式
				if(!result.equals("")) {
					System.out.println(result);
	                response = JSONObject.parseObject(result);
				}
				return contractAndTechVo;
			}else {
				return null;
			}
		}catch(Exception e){
			  throw new RuntimeException(e);
		}
		
	}
}
