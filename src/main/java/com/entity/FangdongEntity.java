package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 房东
 *
 * @author 
 * @email
 */
@TableName("fangdong")
public class FangdongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangdongEntity() {

	}

	public FangdongEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 房东编号
     */
    @ColumnInfo(comment="房东编号",type="varchar(200)")
    @TableField(value = "fangdong_uuid_number")

    private String fangdongUuidNumber;


    /**
     * 房东姓名
     */
    @ColumnInfo(comment="房东姓名",type="varchar(200)")
    @TableField(value = "fangdong_name")

    private String fangdongName;


    /**
     * 房东手机号
     */
    @ColumnInfo(comment="房东手机号",type="varchar(200)")
    @TableField(value = "fangdong_phone")

    private String fangdongPhone;


    /**
     * 房东身份证号
     */
    @ColumnInfo(comment="房东身份证号",type="varchar(200)")
    @TableField(value = "fangdong_id_number")

    private String fangdongIdNumber;


    /**
     * 房东头像
     */
    @ColumnInfo(comment="房东头像",type="varchar(200)")
    @TableField(value = "fangdong_photo")

    private String fangdongPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 房东邮箱
     */
    @ColumnInfo(comment="房东邮箱",type="varchar(200)")
    @TableField(value = "fangdong_email")

    private String fangdongEmail;


    /**
     * 余额
     */
    @ColumnInfo(comment="余额",type="decimal(10,2)")
    @TableField(value = "new_money")

    private Double newMoney;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Fangdong{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", fangdongUuidNumber=" + fangdongUuidNumber +
            ", fangdongName=" + fangdongName +
            ", fangdongPhone=" + fangdongPhone +
            ", fangdongIdNumber=" + fangdongIdNumber +
            ", fangdongPhoto=" + fangdongPhoto +
            ", sexTypes=" + sexTypes +
            ", fangdongEmail=" + fangdongEmail +
            ", newMoney=" + newMoney +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
