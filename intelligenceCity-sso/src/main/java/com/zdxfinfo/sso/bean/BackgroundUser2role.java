package com.zdxfinfo.sso.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * t_background_user2role
 * @author 
 */
public class BackgroundUser2role implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 关联到业务子系统ID
     */
    private Integer subsystemId;

    /**
     * 后台用户表主键ID
     */
    private Integer backgroundUserid;

    /**
     * 角色表主键ID
     */
    private Integer roleId;

    /**
     * 创建时间
     */
    private Date createTime;
    
    //角色表信息
    private List<Role> roles;
    
    //系统表信息
    private List<Subsystem> subsystems;
    
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

    public Integer getBackgroundUserid() {
        return backgroundUserid;
    }

    public void setBackgroundUserid(Integer backgroundUserid) {
        this.backgroundUserid = backgroundUserid;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
        BackgroundUser2role other = (BackgroundUser2role) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSubsystemId() == null ? other.getSubsystemId() == null : this.getSubsystemId().equals(other.getSubsystemId()))
            && (this.getBackgroundUserid() == null ? other.getBackgroundUserid() == null : this.getBackgroundUserid().equals(other.getBackgroundUserid()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSubsystemId() == null) ? 0 : getSubsystemId().hashCode());
        result = prime * result + ((getBackgroundUserid() == null) ? 0 : getBackgroundUserid().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
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
        sb.append(", backgroundUserid=").append(backgroundUserid);
        sb.append(", roleId=").append(roleId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Subsystem> getSubsystems() {
		return subsystems;
	}

	public void setSubsystems(List<Subsystem> subsystems) {
		this.subsystems = subsystems;
	}
	
}