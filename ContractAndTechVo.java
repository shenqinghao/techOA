package cn.edu.tju.controller.contract.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import cn.edu.tju.model.common.Attachment;
import io.swagger.annotations.ApiModelProperty;

public class ContractAndTechVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6948574145131882430L;
	
	 /**
     * 合同ID
     */
    @ApiModelProperty(value="合同ID")
    private String id;

    /**
     * 合同类型ID
     */
    @ApiModelProperty(value="合同类型ID")
    private String typeId;
    
	 /**
     * 合同名称
     */
    @ApiModelProperty(value="合同名称")
    private String name;
    
    /**
     * 合同金额(万元)
     */
    @ApiModelProperty(value="合同金额(万元)")
    private BigDecimal contractAmount;
    
    /**
     * 合同有效期开始时间
     */
    @ApiModelProperty(value="合同有效期开始时间")
    private String periodOfValidityStart;

    /**
     * 合同有效期结束时间
     */
    @ApiModelProperty(value="合同有效期结束时间")
    private String periodOfValidityEnd;
    
    /**
     * 合同摘要
     */
    @ApiModelProperty(value="合同摘要")
    private String contractDigest;
    
    /**
     * 合同关键词(多个以逗号拼串)
     */
    @ApiModelProperty(value="合同关键词(多个以逗号拼串)")
    private String keyword;
    
    /**
     * 负责人ID
     */
    @ApiModelProperty(value="负责人ID")
    private String directorUserId;
    
    /**
     * 负责人名字
     */
    @ApiModelProperty(value="负责人名字")
    private String directorUserName;
    
    /**
     * 登陆号
     */
    @ApiModelProperty(value="登陆号")
    private String workNum;
    
    /**
     * 经办人名字
     */
    @ApiModelProperty(value="经办人名字")
    private String handleUserName;
   
	/**
     * 合同文本
     */
    @ApiModelProperty(value="合同文本")
    private String textDocId;

    /**
     * 合同文本 :附件信息
     */
    @ApiModelProperty(value="合同文本 :附件信息列表")
  	List<Attachment> textDocAttachList = new ArrayList<Attachment>();
 
  	
    /**
     * 附件信息(多个附件拼串)
     */
    @ApiModelProperty(value="附件信息(多个附件拼串)")
    private String attachmentId;

    /**
     * 其它附件 :附件信息
     */
    @ApiModelProperty(value="其它附件 :附件信息列表")
  	List<Attachment> otherAttachList = new ArrayList<Attachment>();
 
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
    
    public String getWorkNum() {
		return workNum;
	}

	public void setWorkNum(String workNum) {
		this.workNum = workNum;
	}
    
    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    
    public String getHandleUserName() {
		return handleUserName;
	}

	public void setHandleUserName(String handleUserName) {
		this.handleUserName = handleUserName;
	}

    public BigDecimal getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(BigDecimal contractAmount) {
        this.contractAmount = contractAmount;
    }

    public String getContractDigest() {
        return contractDigest;
    }

    public void setContractDigest(String contractDigest) {
        this.contractDigest = contractDigest == null ? null : contractDigest.trim();
    }

    public String getPeriodOfValidityStart() {
        return periodOfValidityStart;
    }

    public void setPeriodOfValidityStart(String periodOfValidityStart) {
        this.periodOfValidityStart = periodOfValidityStart;
    }

    public String getPeriodOfValidityEnd() {
        return periodOfValidityEnd;
    }

    public void setPeriodOfValidityEnd(String periodOfValidityEnd) {
        this.periodOfValidityEnd = periodOfValidityEnd;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }
    public String getDirectorUserId() {
		return directorUserId;
	}
	public void setDirectorUserId(String directorUserId) {
		this.directorUserId = directorUserId;
	}
    public String getDirectorUserName() {
        return directorUserName;
    }

    public void setDirectorUserName(String directorUserName) {
        this.directorUserName = directorUserName == null ? null : directorUserName.trim();
    }
    public String getTextDocId() {
		return textDocId;
	}
	public void setTextDocId(String textDocId) {
		this.textDocId = textDocId;
	}
	public String getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}
	public List<Attachment> getTextDocAttachList() {
		return textDocAttachList;
	}
	public void setTextDocAttachList(List<Attachment> textDocAttachList) {
		this.textDocAttachList = textDocAttachList;
	}
	public List<Attachment> getOtherAttachList() {
		return otherAttachList;
	}
	public void setOtherAttachList(List<Attachment> otherAttachList) {
		this.otherAttachList = otherAttachList;
	}

}
