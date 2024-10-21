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
 * 房屋
 *
 * @author 
 * @email
 */
@TableName("fangwu")
public class FangwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangwuEntity() {

	}

	public FangwuEntity(T t) {
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
     * 房东
     */
    @ColumnInfo(comment="房东",type="int(11)")
    @TableField(value = "fangdong_id")

    private Integer fangdongId;


    /**
     * 房屋名称
     */
    @ColumnInfo(comment="房屋名称",type="varchar(200)")
    @TableField(value = "fangwu_name")

    private String fangwuName;


    /**
     * 房屋编号
     */
    @ColumnInfo(comment="房屋编号",type="varchar(200)")
    @TableField(value = "fangwu_uuid_number")

    private String fangwuUuidNumber;


    /**
     * 房屋照片
     */
    @ColumnInfo(comment="房屋照片",type="varchar(200)")
    @TableField(value = "fangwu_photo")

    private String fangwuPhoto;


    /**
     * 房屋地点
     */
    @ColumnInfo(comment="房屋地点",type="varchar(200)")
    @TableField(value = "fangwu_address")

    private String fangwuAddress;


    /**
     * 房屋信息文件
     */
    @ColumnInfo(comment="房屋信息文件",type="varchar(200)")
    @TableField(value = "fangwu_file")

    private String fangwuFile;


    /**
     * 房屋类型
     */
    @ColumnInfo(comment="房屋类型",type="int(11)")
    @TableField(value = "fangwu_types")

    private Integer fangwuTypes;


    /**
     * 房屋状态
     */
    @ColumnInfo(comment="房屋状态",type="int(11)")
    @TableField(value = "fangwu_zhuangtai_types")

    private Integer fangwuZhuangtaiTypes;


    /**
     * 现价/积分
     */
    @ColumnInfo(comment="现价/积分",type="decimal(10,2)")
    @TableField(value = "fangwu_new_money")

    private Double fangwuNewMoney;


    /**
     * 房屋介绍
     */
    @ColumnInfo(comment="房屋介绍",type="longtext")
    @TableField(value = "fangwu_content")

    private String fangwuContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "fangwu_delete")

    private Integer fangwuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：房东
	 */
    public Integer getFangdongId() {
        return fangdongId;
    }
    /**
	 * 设置：房东
	 */

    public void setFangdongId(Integer fangdongId) {
        this.fangdongId = fangdongId;
    }
    /**
	 * 获取：房屋名称
	 */
    public String getFangwuName() {
        return fangwuName;
    }
    /**
	 * 设置：房屋名称
	 */

    public void setFangwuName(String fangwuName) {
        this.fangwuName = fangwuName;
    }
    /**
	 * 获取：房屋编号
	 */
    public String getFangwuUuidNumber() {
        return fangwuUuidNumber;
    }
    /**
	 * 设置：房屋编号
	 */

    public void setFangwuUuidNumber(String fangwuUuidNumber) {
        this.fangwuUuidNumber = fangwuUuidNumber;
    }
    /**
	 * 获取：房屋照片
	 */
    public String getFangwuPhoto() {
        return fangwuPhoto;
    }
    /**
	 * 设置：房屋照片
	 */

    public void setFangwuPhoto(String fangwuPhoto) {
        this.fangwuPhoto = fangwuPhoto;
    }
    /**
	 * 获取：房屋地点
	 */
    public String getFangwuAddress() {
        return fangwuAddress;
    }
    /**
	 * 设置：房屋地点
	 */

    public void setFangwuAddress(String fangwuAddress) {
        this.fangwuAddress = fangwuAddress;
    }
    /**
	 * 获取：房屋信息文件
	 */
    public String getFangwuFile() {
        return fangwuFile;
    }
    /**
	 * 设置：房屋信息文件
	 */

    public void setFangwuFile(String fangwuFile) {
        this.fangwuFile = fangwuFile;
    }
    /**
	 * 获取：房屋类型
	 */
    public Integer getFangwuTypes() {
        return fangwuTypes;
    }
    /**
	 * 设置：房屋类型
	 */

    public void setFangwuTypes(Integer fangwuTypes) {
        this.fangwuTypes = fangwuTypes;
    }
    /**
	 * 获取：房屋状态
	 */
    public Integer getFangwuZhuangtaiTypes() {
        return fangwuZhuangtaiTypes;
    }
    /**
	 * 设置：房屋状态
	 */

    public void setFangwuZhuangtaiTypes(Integer fangwuZhuangtaiTypes) {
        this.fangwuZhuangtaiTypes = fangwuZhuangtaiTypes;
    }
    /**
	 * 获取：现价/积分
	 */
    public Double getFangwuNewMoney() {
        return fangwuNewMoney;
    }
    /**
	 * 设置：现价/积分
	 */

    public void setFangwuNewMoney(Double fangwuNewMoney) {
        this.fangwuNewMoney = fangwuNewMoney;
    }
    /**
	 * 获取：房屋介绍
	 */
    public String getFangwuContent() {
        return fangwuContent;
    }
    /**
	 * 设置：房屋介绍
	 */

    public void setFangwuContent(String fangwuContent) {
        this.fangwuContent = fangwuContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getFangwuDelete() {
        return fangwuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setFangwuDelete(Integer fangwuDelete) {
        this.fangwuDelete = fangwuDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Fangwu{" +
            ", id=" + id +
            ", fangdongId=" + fangdongId +
            ", fangwuName=" + fangwuName +
            ", fangwuUuidNumber=" + fangwuUuidNumber +
            ", fangwuPhoto=" + fangwuPhoto +
            ", fangwuAddress=" + fangwuAddress +
            ", fangwuFile=" + fangwuFile +
            ", fangwuTypes=" + fangwuTypes +
            ", fangwuZhuangtaiTypes=" + fangwuZhuangtaiTypes +
            ", fangwuNewMoney=" + fangwuNewMoney +
            ", fangwuContent=" + fangwuContent +
            ", fangwuDelete=" + fangwuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
