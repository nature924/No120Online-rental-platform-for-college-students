package com.entity.model;

import com.entity.BaoxiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 报修
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BaoxiuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 房屋
     */
    private Integer fangwuId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 报修编号
     */
    private String baoxiuUuidNumber;


    /**
     * 报修标题
     */
    private String baoxiuAddress;


    /**
     * 报修位置
     */
    private String baoxiuName;


    /**
     * 报修图片
     */
    private String baoxiuPhoto;


    /**
     * 报修类型
     */
    private Integer baoxiuTypes;


    /**
     * 报修内容
     */
    private String baoxiuContent;


    /**
     * 申请状态
     */
    private Integer baoxiuYesnoTypes;


    /**
     * 审核意见
     */
    private String baoxiuYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date baoxiuShenheTime;


    /**
     * 报修时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 报修状态
     */
    private Integer baoxiuZhuangtaiTypes;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：报修编号
	 */
    public String getBaoxiuUuidNumber() {
        return baoxiuUuidNumber;
    }


    /**
	 * 设置：报修编号
	 */
    public void setBaoxiuUuidNumber(String baoxiuUuidNumber) {
        this.baoxiuUuidNumber = baoxiuUuidNumber;
    }
    /**
	 * 获取：报修标题
	 */
    public String getBaoxiuAddress() {
        return baoxiuAddress;
    }


    /**
	 * 设置：报修标题
	 */
    public void setBaoxiuAddress(String baoxiuAddress) {
        this.baoxiuAddress = baoxiuAddress;
    }
    /**
	 * 获取：报修位置
	 */
    public String getBaoxiuName() {
        return baoxiuName;
    }


    /**
	 * 设置：报修位置
	 */
    public void setBaoxiuName(String baoxiuName) {
        this.baoxiuName = baoxiuName;
    }
    /**
	 * 获取：报修图片
	 */
    public String getBaoxiuPhoto() {
        return baoxiuPhoto;
    }


    /**
	 * 设置：报修图片
	 */
    public void setBaoxiuPhoto(String baoxiuPhoto) {
        this.baoxiuPhoto = baoxiuPhoto;
    }
    /**
	 * 获取：报修类型
	 */
    public Integer getBaoxiuTypes() {
        return baoxiuTypes;
    }


    /**
	 * 设置：报修类型
	 */
    public void setBaoxiuTypes(Integer baoxiuTypes) {
        this.baoxiuTypes = baoxiuTypes;
    }
    /**
	 * 获取：报修内容
	 */
    public String getBaoxiuContent() {
        return baoxiuContent;
    }


    /**
	 * 设置：报修内容
	 */
    public void setBaoxiuContent(String baoxiuContent) {
        this.baoxiuContent = baoxiuContent;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getBaoxiuYesnoTypes() {
        return baoxiuYesnoTypes;
    }


    /**
	 * 设置：申请状态
	 */
    public void setBaoxiuYesnoTypes(Integer baoxiuYesnoTypes) {
        this.baoxiuYesnoTypes = baoxiuYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getBaoxiuYesnoText() {
        return baoxiuYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setBaoxiuYesnoText(String baoxiuYesnoText) {
        this.baoxiuYesnoText = baoxiuYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getBaoxiuShenheTime() {
        return baoxiuShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setBaoxiuShenheTime(Date baoxiuShenheTime) {
        this.baoxiuShenheTime = baoxiuShenheTime;
    }
    /**
	 * 获取：报修时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：报修时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：报修状态
	 */
    public Integer getBaoxiuZhuangtaiTypes() {
        return baoxiuZhuangtaiTypes;
    }


    /**
	 * 设置：报修状态
	 */
    public void setBaoxiuZhuangtaiTypes(Integer baoxiuZhuangtaiTypes) {
        this.baoxiuZhuangtaiTypes = baoxiuZhuangtaiTypes;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
