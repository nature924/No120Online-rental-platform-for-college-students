package com.entity.vo;

import com.entity.BaoxiuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 报修
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("baoxiu")
public class BaoxiuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


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
     * 报修编号
     */

    @TableField(value = "baoxiu_uuid_number")
    private String baoxiuUuidNumber;


    /**
     * 报修标题
     */

    @TableField(value = "baoxiu_address")
    private String baoxiuAddress;


    /**
     * 报修位置
     */

    @TableField(value = "baoxiu_name")
    private String baoxiuName;


    /**
     * 报修图片
     */

    @TableField(value = "baoxiu_photo")
    private String baoxiuPhoto;


    /**
     * 报修类型
     */

    @TableField(value = "baoxiu_types")
    private Integer baoxiuTypes;


    /**
     * 报修内容
     */

    @TableField(value = "baoxiu_content")
    private String baoxiuContent;


    /**
     * 申请状态
     */

    @TableField(value = "baoxiu_yesno_types")
    private Integer baoxiuYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "baoxiu_yesno_text")
    private String baoxiuYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "baoxiu_shenhe_time")
    private Date baoxiuShenheTime;


    /**
     * 报修时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 报修状态
     */

    @TableField(value = "baoxiu_zhuangtai_types")
    private Integer baoxiuZhuangtaiTypes;


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
	 * 设置：报修编号
	 */
    public String getBaoxiuUuidNumber() {
        return baoxiuUuidNumber;
    }


    /**
	 * 获取：报修编号
	 */

    public void setBaoxiuUuidNumber(String baoxiuUuidNumber) {
        this.baoxiuUuidNumber = baoxiuUuidNumber;
    }
    /**
	 * 设置：报修标题
	 */
    public String getBaoxiuAddress() {
        return baoxiuAddress;
    }


    /**
	 * 获取：报修标题
	 */

    public void setBaoxiuAddress(String baoxiuAddress) {
        this.baoxiuAddress = baoxiuAddress;
    }
    /**
	 * 设置：报修位置
	 */
    public String getBaoxiuName() {
        return baoxiuName;
    }


    /**
	 * 获取：报修位置
	 */

    public void setBaoxiuName(String baoxiuName) {
        this.baoxiuName = baoxiuName;
    }
    /**
	 * 设置：报修图片
	 */
    public String getBaoxiuPhoto() {
        return baoxiuPhoto;
    }


    /**
	 * 获取：报修图片
	 */

    public void setBaoxiuPhoto(String baoxiuPhoto) {
        this.baoxiuPhoto = baoxiuPhoto;
    }
    /**
	 * 设置：报修类型
	 */
    public Integer getBaoxiuTypes() {
        return baoxiuTypes;
    }


    /**
	 * 获取：报修类型
	 */

    public void setBaoxiuTypes(Integer baoxiuTypes) {
        this.baoxiuTypes = baoxiuTypes;
    }
    /**
	 * 设置：报修内容
	 */
    public String getBaoxiuContent() {
        return baoxiuContent;
    }


    /**
	 * 获取：报修内容
	 */

    public void setBaoxiuContent(String baoxiuContent) {
        this.baoxiuContent = baoxiuContent;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getBaoxiuYesnoTypes() {
        return baoxiuYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setBaoxiuYesnoTypes(Integer baoxiuYesnoTypes) {
        this.baoxiuYesnoTypes = baoxiuYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getBaoxiuYesnoText() {
        return baoxiuYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setBaoxiuYesnoText(String baoxiuYesnoText) {
        this.baoxiuYesnoText = baoxiuYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getBaoxiuShenheTime() {
        return baoxiuShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setBaoxiuShenheTime(Date baoxiuShenheTime) {
        this.baoxiuShenheTime = baoxiuShenheTime;
    }
    /**
	 * 设置：报修时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：报修时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：报修状态
	 */
    public Integer getBaoxiuZhuangtaiTypes() {
        return baoxiuZhuangtaiTypes;
    }


    /**
	 * 获取：报修状态
	 */

    public void setBaoxiuZhuangtaiTypes(Integer baoxiuZhuangtaiTypes) {
        this.baoxiuZhuangtaiTypes = baoxiuZhuangtaiTypes;
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
