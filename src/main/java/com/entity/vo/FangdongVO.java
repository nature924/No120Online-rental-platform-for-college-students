package com.entity.vo;

import com.entity.FangdongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 房东
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fangdong")
public class FangdongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 房东编号
     */

    @TableField(value = "fangdong_uuid_number")
    private String fangdongUuidNumber;


    /**
     * 房东姓名
     */

    @TableField(value = "fangdong_name")
    private String fangdongName;


    /**
     * 房东手机号
     */

    @TableField(value = "fangdong_phone")
    private String fangdongPhone;


    /**
     * 房东身份证号
     */

    @TableField(value = "fangdong_id_number")
    private String fangdongIdNumber;


    /**
     * 房东头像
     */

    @TableField(value = "fangdong_photo")
    private String fangdongPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 房东邮箱
     */

    @TableField(value = "fangdong_email")
    private String fangdongEmail;


    /**
     * 余额
     */

    @TableField(value = "new_money")
    private Double newMoney;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：房东编号
	 */
    public String getFangdongUuidNumber() {
        return fangdongUuidNumber;
    }


    /**
	 * 获取：房东编号
	 */

    public void setFangdongUuidNumber(String fangdongUuidNumber) {
        this.fangdongUuidNumber = fangdongUuidNumber;
    }
    /**
	 * 设置：房东姓名
	 */
    public String getFangdongName() {
        return fangdongName;
    }


    /**
	 * 获取：房东姓名
	 */

    public void setFangdongName(String fangdongName) {
        this.fangdongName = fangdongName;
    }
    /**
	 * 设置：房东手机号
	 */
    public String getFangdongPhone() {
        return fangdongPhone;
    }


    /**
	 * 获取：房东手机号
	 */

    public void setFangdongPhone(String fangdongPhone) {
        this.fangdongPhone = fangdongPhone;
    }
    /**
	 * 设置：房东身份证号
	 */
    public String getFangdongIdNumber() {
        return fangdongIdNumber;
    }


    /**
	 * 获取：房东身份证号
	 */

    public void setFangdongIdNumber(String fangdongIdNumber) {
        this.fangdongIdNumber = fangdongIdNumber;
    }
    /**
	 * 设置：房东头像
	 */
    public String getFangdongPhoto() {
        return fangdongPhoto;
    }


    /**
	 * 获取：房东头像
	 */

    public void setFangdongPhoto(String fangdongPhoto) {
        this.fangdongPhoto = fangdongPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：房东邮箱
	 */
    public String getFangdongEmail() {
        return fangdongEmail;
    }


    /**
	 * 获取：房东邮箱
	 */

    public void setFangdongEmail(String fangdongEmail) {
        this.fangdongEmail = fangdongEmail;
    }
    /**
	 * 设置：余额
	 */
    public Double getNewMoney() {
        return newMoney;
    }


    /**
	 * 获取：余额
	 */

    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
