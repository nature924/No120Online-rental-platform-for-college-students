package com.entity.vo;

import com.entity.FangwuYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 房屋租赁
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fangwu_yuyue")
public class FangwuYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "fangwu_yuyue_uuid_number")
    private String fangwuYuyueUuidNumber;


    /**
     * 房屋
     */

    @TableField(value = "fangwu_id")
    private Integer fangwuId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 报名理由
     */

    @TableField(value = "fangwu_yuyue_text")
    private String fangwuYuyueText;


    /**
     * 学生证
     */

    @TableField(value = "fangwu_yuyue_file")
    private String fangwuYuyueFile;


    /**
     * 房屋租赁时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 报名状态
     */

    @TableField(value = "fangwu_yuyue_yesno_types")
    private Integer fangwuYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "fangwu_yuyue_yesno_text")
    private String fangwuYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fangwu_yuyue_shenhe_time")
    private Date fangwuYuyueShenheTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：报名编号
	 */
    public String getFangwuYuyueUuidNumber() {
        return fangwuYuyueUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setFangwuYuyueUuidNumber(String fangwuYuyueUuidNumber) {
        this.fangwuYuyueUuidNumber = fangwuYuyueUuidNumber;
    }
    /**
	 * 设置：房屋
	 */
    public Integer getFangwuId() {
        return fangwuId;
    }


    /**
	 * 获取：房屋
	 */

    public void setFangwuId(Integer fangwuId) {
        this.fangwuId = fangwuId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：报名理由
	 */
    public String getFangwuYuyueText() {
        return fangwuYuyueText;
    }


    /**
	 * 获取：报名理由
	 */

    public void setFangwuYuyueText(String fangwuYuyueText) {
        this.fangwuYuyueText = fangwuYuyueText;
    }
    /**
	 * 设置：学生证
	 */
    public String getFangwuYuyueFile() {
        return fangwuYuyueFile;
    }


    /**
	 * 获取：学生证
	 */

    public void setFangwuYuyueFile(String fangwuYuyueFile) {
        this.fangwuYuyueFile = fangwuYuyueFile;
    }
    /**
	 * 设置：房屋租赁时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：房屋租赁时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getFangwuYuyueYesnoTypes() {
        return fangwuYuyueYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setFangwuYuyueYesnoTypes(Integer fangwuYuyueYesnoTypes) {
        this.fangwuYuyueYesnoTypes = fangwuYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getFangwuYuyueYesnoText() {
        return fangwuYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setFangwuYuyueYesnoText(String fangwuYuyueYesnoText) {
        this.fangwuYuyueYesnoText = fangwuYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getFangwuYuyueShenheTime() {
        return fangwuYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setFangwuYuyueShenheTime(Date fangwuYuyueShenheTime) {
        this.fangwuYuyueShenheTime = fangwuYuyueShenheTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
