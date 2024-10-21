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
 * 房屋租赁
 *
 * @author 
 * @email
 */
@TableName("fangwu_yuyue")
public class FangwuYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangwuYuyueEntity() {

	}

	public FangwuYuyueEntity(T t) {
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
     * 报名编号
     */
    @ColumnInfo(comment="报名编号",type="varchar(200)")
    @TableField(value = "fangwu_yuyue_uuid_number")

    private String fangwuYuyueUuidNumber;


    /**
     * 房屋
     */
    @ColumnInfo(comment="房屋",type="int(11)")
    @TableField(value = "fangwu_id")

    private Integer fangwuId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 报名理由
     */
    @ColumnInfo(comment="报名理由",type="longtext")
    @TableField(value = "fangwu_yuyue_text")

    private String fangwuYuyueText;


    /**
     * 学生证
     */
    @ColumnInfo(comment="学生证",type="varchar(200)")
    @TableField(value = "fangwu_yuyue_file")

    private String fangwuYuyueFile;


    /**
     * 房屋租赁时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="房屋租赁时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "fangwu_yuyue_yesno_types")

    private Integer fangwuYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "fangwu_yuyue_yesno_text")

    private String fangwuYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "fangwu_yuyue_shenhe_time")

    private Date fangwuYuyueShenheTime;


    /**
     * 创建时间  listShow
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
	 * 获取：报名编号
	 */
    public String getFangwuYuyueUuidNumber() {
        return fangwuYuyueUuidNumber;
    }
    /**
	 * 设置：报名编号
	 */

    public void setFangwuYuyueUuidNumber(String fangwuYuyueUuidNumber) {
        this.fangwuYuyueUuidNumber = fangwuYuyueUuidNumber;
    }
    /**
	 * 获取：房屋
	 */
    public Integer getFangwuId() {
        return fangwuId;
    }
    /**
	 * 设置：房屋
	 */

    public void setFangwuId(Integer fangwuId) {
        this.fangwuId = fangwuId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：报名理由
	 */
    public String getFangwuYuyueText() {
        return fangwuYuyueText;
    }
    /**
	 * 设置：报名理由
	 */

    public void setFangwuYuyueText(String fangwuYuyueText) {
        this.fangwuYuyueText = fangwuYuyueText;
    }
    /**
	 * 获取：学生证
	 */
    public String getFangwuYuyueFile() {
        return fangwuYuyueFile;
    }
    /**
	 * 设置：学生证
	 */

    public void setFangwuYuyueFile(String fangwuYuyueFile) {
        this.fangwuYuyueFile = fangwuYuyueFile;
    }
    /**
	 * 获取：房屋租赁时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：房屋租赁时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getFangwuYuyueYesnoTypes() {
        return fangwuYuyueYesnoTypes;
    }
    /**
	 * 设置：报名状态
	 */

    public void setFangwuYuyueYesnoTypes(Integer fangwuYuyueYesnoTypes) {
        this.fangwuYuyueYesnoTypes = fangwuYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getFangwuYuyueYesnoText() {
        return fangwuYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setFangwuYuyueYesnoText(String fangwuYuyueYesnoText) {
        this.fangwuYuyueYesnoText = fangwuYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getFangwuYuyueShenheTime() {
        return fangwuYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setFangwuYuyueShenheTime(Date fangwuYuyueShenheTime) {
        this.fangwuYuyueShenheTime = fangwuYuyueShenheTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "FangwuYuyue{" +
            ", id=" + id +
            ", fangwuYuyueUuidNumber=" + fangwuYuyueUuidNumber +
            ", fangwuId=" + fangwuId +
            ", yonghuId=" + yonghuId +
            ", fangwuYuyueText=" + fangwuYuyueText +
            ", fangwuYuyueFile=" + fangwuYuyueFile +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", fangwuYuyueYesnoTypes=" + fangwuYuyueYesnoTypes +
            ", fangwuYuyueYesnoText=" + fangwuYuyueYesnoText +
            ", fangwuYuyueShenheTime=" + DateUtil.convertString(fangwuYuyueShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
