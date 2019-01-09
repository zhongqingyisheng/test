package com.zdxfinfo.sso.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * t_button
 * @author 
 */
public class Button implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 定义按钮编号
     */
    private String buttonNumber;

    /**
     * 按钮名称
     */
    private String buttonName;

    /**
     * 按钮状态
     */
    private Boolean status;

    /**
     * 备注
     */
    private String remark;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getButtonNumber() {
        return buttonNumber;
    }

    public void setButtonNumber(String buttonNumber) {
        this.buttonNumber = buttonNumber;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        Button other = (Button) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getButtonNumber() == null ? other.getButtonNumber() == null : this.getButtonNumber().equals(other.getButtonNumber()))
            && (this.getButtonName() == null ? other.getButtonName() == null : this.getButtonName().equals(other.getButtonName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getButtonNumber() == null) ? 0 : getButtonNumber().hashCode());
        result = prime * result + ((getButtonName() == null) ? 0 : getButtonName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", buttonNumber=").append(buttonNumber);
        sb.append(", buttonName=").append(buttonName);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}