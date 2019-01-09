package com.zdxfinfo.sso.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * t_institution
 * @author 
 */
public class Institution implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 机构编号
     */
    private String institutionCode;

    /**
     * 关联层级表主键ID
     */
    private Integer hierarchyId;

    /**
     * 机构名
     */
    private String institutionName;
    
    /**
     * 机构自关联ID
     */
    private Integer parentId;

    /**
     * 备注
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
    
    
    private List<Institution> InstitutionList;
    
    

    public List<Institution> getInstitutionList() {
		return InstitutionList;
	}

	public void setInstitutionList(List<Institution> institutionList) {
		InstitutionList = institutionList;
	}

	private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    public Integer getHierarchyId() {
        return hierarchyId;
    }

    public void setHierarchyId(Integer hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }
    
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer ParentId) {
        this.parentId = ParentId;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        Institution other = (Institution) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInstitutionCode() == null ? other.getInstitutionCode() == null : this.getInstitutionCode().equals(other.getInstitutionCode()))
            && (this.getHierarchyId() == null ? other.getHierarchyId() == null : this.getHierarchyId().equals(other.getHierarchyId()))
            && (this.getInstitutionName() == null ? other.getInstitutionName() == null : this.getInstitutionName().equals(other.getInstitutionName()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInstitutionCode() == null) ? 0 : getInstitutionCode().hashCode());
        result = prime * result + ((getHierarchyId() == null) ? 0 : getHierarchyId().hashCode());
        result = prime * result + ((getInstitutionName() == null) ? 0 : getInstitutionName().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
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
        sb.append(", institutionCode=").append(institutionCode);
        sb.append(", hierarchyId=").append(hierarchyId);
        sb.append(", institutionName=").append(institutionName);
        sb.append(", parentId=").append(parentId);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}