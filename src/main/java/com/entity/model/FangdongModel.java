package com.entity.model;

import com.entity.FangdongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 房东
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangdongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 房东编号
     */
    private String fangdongUuidNumber;


    /**
     * 房东姓名
     */
    private String fangdongName;


    /**
     * 房东手机号
     */
    private String fangdongPhone;


    /**
     * 房东身份证号
     */
    private String fangdongIdNumber;


    /**
     * 房东头像
     */
    private String fangdongPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 房东邮箱
     */
    private String fangdongEmail;


    /**
     * 余额
     */
    private Double newMoney;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：房东编号
	 */
    public String getFangdongUuidNumber() {
        return fangdongUuidNumber;
    }


    /**
	 * 设置：房东编号
	 */
    public void setFangdongUuidNumber(String fangdongUuidNumber) {
        this.fangdongUuidNumber = fangdongUuidNumber;
    }
    /**
	 * 获取：房东姓名
	 */
    public String getFangdongName() {
        return fangdongName;
    }


    /**
	 * 设置：房东姓名
	 */
    public void setFangdongName(String fangdongName) {
        this.fangdongName = fangdongName;
    }
    /**
	 * 获取：房东手机号
	 */
    public String getFangdongPhone() {
        return fangdongPhone;
    }


    /**
	 * 设置：房东手机号
	 */
    public void setFangdongPhone(String fangdongPhone) {
        this.fangdongPhone = fangdongPhone;
    }
    /**
	 * 获取：房东身份证号
	 */
    public String getFangdongIdNumber() {
        return fangdongIdNumber;
    }


    /**
	 * 设置：房东身份证号
	 */
    public void setFangdongIdNumber(String fangdongIdNumber) {
        this.fangdongIdNumber = fangdongIdNumber;
    }
    /**
	 * 获取：房东头像
	 */
    public String getFangdongPhoto() {
        return fangdongPhoto;
    }


    /**
	 * 设置：房东头像
	 */
    public void setFangdongPhoto(String fangdongPhoto) {
        this.fangdongPhoto = fangdongPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：房东邮箱
	 */
    public String getFangdongEmail() {
        return fangdongEmail;
    }


    /**
	 * 设置：房东邮箱
	 */
    public void setFangdongEmail(String fangdongEmail) {
        this.fangdongEmail = fangdongEmail;
    }
    /**
	 * 获取：余额
	 */
    public Double getNewMoney() {
        return newMoney;
    }


    /**
	 * 设置：余额
	 */
    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
