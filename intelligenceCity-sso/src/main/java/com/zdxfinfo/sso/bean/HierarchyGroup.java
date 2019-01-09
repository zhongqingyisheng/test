package com.zdxfinfo.sso.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * t_hierarchy_group
 * @author 
 */
public class HierarchyGroup implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 层级组编号
     */
    private String hierarchyGroupCode;

    /**
     * 层级组名
     */
    private String hierarchyGroupName;

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
    
    /**
     * 层级组下所有层级
     */
    private List<Hierarchy> hierarchys;
    
    private List<Hierarchy2group> hierarchysGroups;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHierarchyGroupCode() {
        return hierarchyGroupCode;
    }

    public void setHierarchyGroupCode(String hierarchyGroupCode) {
        this.hierarchyGroupCode = hierarchyGroupCode;
    }

    public String getHierarchyGroupName() {
        return hierarchyGroupName;
    }

    public void setHierarchyGroupName(String hierarchyGroupName) {
        this.hierarchyGroupName = hierarchyGroupName;
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
    
    public List<Hierarchy> getHierarchys() {
		return hierarchys;
	}

	public void setHierarchys(List<Hierarchy> hierarchys) {
		this.hierarchys = hierarchys;
	}
	
	public List<Hierarchy2group> getHierarchysGroups() {
		return hierarchysGroups;
	}

	public void setHierarchysGroups(List<Hierarchy2group> hierarchysGroups) {
		this.hierarchysGroups = hierarchysGroups;
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
        HierarchyGroup other = (HierarchyGroup) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHierarchyGroupCode() == null ? other.getHierarchyGroupCode() == null : this.getHierarchyGroupCode().equals(other.getHierarchyGroupCode()))
            && (this.getHierarchyGroupName() == null ? other.getHierarchyGroupName() == null : this.getHierarchyGroupName().equals(other.getHierarchyGroupName()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHierarchyGroupCode() == null) ? 0 : getHierarchyGroupCode().hashCode());
        result = prime * result + ((getHierarchyGroupName() == null) ? 0 : getHierarchyGroupName().hashCode());
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
        sb.append(", hierarchyGroupCode=").append(hierarchyGroupCode);
        sb.append(", hierarchyGroupName=").append(hierarchyGroupName);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}