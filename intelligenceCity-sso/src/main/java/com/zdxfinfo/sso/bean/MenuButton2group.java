package com.zdxfinfo.sso.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * t_menu_button2group
 * @author 
 */
public class MenuButton2group implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 菜单组主键ID
     */
    private Integer menuGroupId;

    /**
     * 菜单按钮表主键ID
     */
    private Integer menuButtonId;

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

    public Integer getMenuGroupId() {
        return menuGroupId;
    }

    public void setMenuGroupId(Integer menuGroupId) {
        this.menuGroupId = menuGroupId;
    }

    public Integer getMenuButtonId() {
        return menuButtonId;
    }

    public void setMenuButtonId(Integer menuButtonId) {
        this.menuButtonId = menuButtonId;
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
        MenuButton2group other = (MenuButton2group) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMenuGroupId() == null ? other.getMenuGroupId() == null : this.getMenuGroupId().equals(other.getMenuGroupId()))
            && (this.getMenuButtonId() == null ? other.getMenuButtonId() == null : this.getMenuButtonId().equals(other.getMenuButtonId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMenuGroupId() == null) ? 0 : getMenuGroupId().hashCode());
        result = prime * result + ((getMenuButtonId() == null) ? 0 : getMenuButtonId().hashCode());
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
        sb.append(", menuGroupId=").append(menuGroupId);
        sb.append(", menuButtonId=").append(menuButtonId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}