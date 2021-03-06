package com.zdxfinfo.sso.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * t_hierarchy2group
 * @author 
 */
public class Hierarchy2group implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 层级组ID
     */
    private Integer hierarchyGroupId;

    /**
     * 层级ID
     */
    private Integer hierarchyId;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHierarchyGroupId() {
        return hierarchyGroupId;
    }

    public void setHierarchyGroupId(Integer hierarchyGroupId) {
        this.hierarchyGroupId = hierarchyGroupId;
    }

    public Integer getHierarchyId() {
        return hierarchyId;
    }

    public void setHierarchyId(Integer hierarchyId) {
        this.hierarchyId = hierarchyId;
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
        Hierarchy2group other = (Hierarchy2group) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHierarchyGroupId() == null ? other.getHierarchyGroupId() == null : this.getHierarchyGroupId().equals(other.getHierarchyGroupId()))
            && (this.getHierarchyId() == null ? other.getHierarchyId() == null : this.getHierarchyId().equals(other.getHierarchyId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHierarchyGroupId() == null) ? 0 : getHierarchyGroupId().hashCode());
        result = prime * result + ((getHierarchyId() == null) ? 0 : getHierarchyId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", hierarchyGroupId=").append(hierarchyGroupId);
        sb.append(", hierarchyId=").append(hierarchyId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}