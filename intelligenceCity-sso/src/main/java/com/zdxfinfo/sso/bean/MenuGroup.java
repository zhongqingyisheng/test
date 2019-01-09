package com.zdxfinfo.sso.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * t_menu_group
 * @author 
 */
public class MenuGroup implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 菜单组编号
     */
    private Integer menuGroupCode;

    /**
     * 菜单组组名
     */
    private String menuGroupName;

    /**
     * 备注
     */
    private String remark;
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	private String name;
    private String buttonName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
    public List<MenuButton2group> getMenuButton2group() {
		return MenuButton2group;
	}

	public void setMenuButton2group(List<MenuButton2group> menuButton2group) {
		MenuButton2group = menuButton2group;
	}

	private List<MenuButton2group> MenuButton2group;
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenuGroupCode() {
        return menuGroupCode;
    }

    public void setMenuGroupCode(Integer menuGroupCode) {
        this.menuGroupCode = menuGroupCode;
    }

    public String getMenuGroupName() {
        return menuGroupName;
    }

    public void setMenuGroupName(String menuGroupName) {
        this.menuGroupName = menuGroupName;
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
        MenuGroup other = (MenuGroup) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMenuGroupCode() == null ? other.getMenuGroupCode() == null : this.getMenuGroupCode().equals(other.getMenuGroupCode()))
            && (this.getMenuGroupName() == null ? other.getMenuGroupName() == null : this.getMenuGroupName().equals(other.getMenuGroupName()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMenuGroupCode() == null) ? 0 : getMenuGroupCode().hashCode());
        result = prime * result + ((getMenuGroupName() == null) ? 0 : getMenuGroupName().hashCode());
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
        sb.append(", menuGroupCode=").append(menuGroupCode);
        sb.append(", menuGroupName=").append(menuGroupName);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}