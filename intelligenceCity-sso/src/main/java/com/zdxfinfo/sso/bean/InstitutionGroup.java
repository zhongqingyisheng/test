package com.zdxfinfo.sso.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * t_institution_group
 * @author 
 */
public class InstitutionGroup implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 机构组编号
     */
    private String institutionGroupCode;

    /**
     * 机构组名
     */
    private String institutionGroupName;
    
    /**
     * 备注信息
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    
    public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	private List<Institution2group> list;

    public List<Institution2group> getList() {
		return list;
	}

	public void setList(List<Institution2group> list) {
		this.list = list;
	}

	private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstitutionGroupCode() {
        return institutionGroupCode;
    }

    public void setInstitutionGroupCode(String institutionGroupCode) {
        this.institutionGroupCode = institutionGroupCode;
    }
    
    
    public String getInstitutionGroupName() {
        return institutionGroupCode;
    }

    public void setInstitutionGroupName(String institutionGroupName) {
        this.institutionGroupName = institutionGroupName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
 

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        InstitutionGroup other = (InstitutionGroup) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInstitutionGroupCode() == null ? other.getInstitutionGroupCode() == null : this.getInstitutionGroupCode().equals(other.getInstitutionGroupCode()))
            && (this.getInstitutionGroupName() == null ? other.getInstitutionGroupName() == null : this.getInstitutionGroupName().equals(other.getInstitutionGroupName()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInstitutionGroupCode() == null) ? 0 : getInstitutionGroupCode().hashCode());
        result = prime * result + ((getInstitutionGroupName() == null) ? 0 : getInstitutionGroupName().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", institutionGroupCode=").append(institutionGroupCode);
        sb.append(", institutionGroupName=").append(institutionGroupName);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}