package com.zdxfinfo.sso.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * t_role
 * @author 
 */
public class Role implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 业务子系统主键ID
     */
    private Integer subsystemId;

    /**
     * 机构组主键ID
     */
    private Integer institutionGroupId;

    /**
     * 层级组主键ID
     */
    private Integer hierarchyGroupId;

    /**
     * 菜单组主键ID
     */
    private Integer menuGroupId;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色备注说明
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 机构组
     */
    private List<InstitutionGroup> institutionGroupList;

    /**
     * 层级组
     */
    private List<HierarchyGroup> hierarchyGroupList;

    /**
     * 菜单组
     */
    private List<MenuGroup> menuGroupList;

    /**
     * 业务子系统
     */
    private List<Subsystem> subsystemList;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubsystemId() {
        return subsystemId;
    }

    public void setSubsystemId(Integer subsystemId) {
        this.subsystemId = subsystemId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public Integer getInstitutionGroupId() {
        return institutionGroupId;
    }

    public void setInstitutionGroupId(Integer institutionGroupId) {
        this.institutionGroupId = institutionGroupId;
    }

    public Integer getHierarchyGroupId() {
        return hierarchyGroupId;
    }

    public void setHierarchyGroupId(Integer hierarchyGroupId) {
        this.hierarchyGroupId = hierarchyGroupId;
    }

    public Integer getMenuGroupId() {
        return menuGroupId;
    }

    public void setMenuGroupId(Integer menuGroupId) {
        this.menuGroupId = menuGroupId;
    }

    public List<InstitutionGroup> getInstitutionGroupList() {
        return institutionGroupList;
    }

    public void setInstitutionGroupList(List<InstitutionGroup> institutionGroupList) {
        this.institutionGroupList = institutionGroupList;
    }

    public List<HierarchyGroup> getHierarchyGroupList() {
        return hierarchyGroupList;
    }

    public void setHierarchyGroupList(List<HierarchyGroup> hierarchyGroupList) {
        this.hierarchyGroupList = hierarchyGroupList;
    }

    public List<MenuGroup> getMenuGroupList() {
        return menuGroupList;
    }

    public void setMenuGroupList(List<MenuGroup> menuGroupList) {
        this.menuGroupList = menuGroupList;
    }

    public List<Subsystem> getSubsystemList() {
        return subsystemList;
    }

    public void setSubsystemList(List<Subsystem> subsystemList) {
        this.subsystemList = subsystemList;
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
        Role other = (Role) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSubsystemId() == null ? other.getSubsystemId() == null : this.getSubsystemId().equals(other.getSubsystemId()))
            && (this.getInstitutionGroupId()==null? other.getInstitutionGroupId() == null : this.getInstitutionGroupId().equals(other.getInstitutionGroupId()))
            && (this.getHierarchyGroupId() == null ? other.getHierarchyGroupId() == null : this.getHierarchyGroupId().equals(other.getHierarchyGroupId()))
            && (this.getMenuGroupId() == null ? other.getMenuGroupId() == null : this.getMenuGroupId().equals(other.getMenuGroupId()))
            && (this.getRoleName() == null ? other.getRoleName() == null : this.getRoleName().equals(other.getRoleName()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSubsystemId() == null) ? 0 : getSubsystemId().hashCode());
        result = prime * result + ((getInstitutionGroupId() == null) ? 0 : getInstitutionGroupId().hashCode());
        result = prime * result + ((getHierarchyGroupId() == null) ? 0 : getHierarchyGroupId().hashCode());
        result = prime * result + ((getMenuGroupId() == null) ? 0 : getMenuGroupId().hashCode());
        result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
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
        sb.append(", subsystemId=").append(subsystemId);
        sb.append(", institutionGroupId=").append(institutionGroupId);
        sb.append(", hierarchyGroupId=").append(hierarchyGroupId);
        sb.append(", menuGroupId=").append(menuGroupId);
        sb.append(", roleName=").append(roleName);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}