package com.entity.model;

import com.entity.FangwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 房屋
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 房东
     */
    private Integer fangdongId;


    /**
     * 房屋名称
     */
    private String fangwuName;


    /**
     * 房屋编号
     */
    private String fangwuUuidNumber;


    /**
     * 房屋照片
     */
    private String fangwuPhoto;


    /**
     * 房屋地点
     */
    private String fangwuAddress;


    /**
     * 房屋信息文件
     */
    private String fangwuFile;


    /**
     * 房屋类型
     */
    private Integer fangwuTypes;


    /**
     * 房屋状态
     */
    private Integer fangwuZhuangtaiTypes;


    /**
     * 现价/积分
     */
    private Double fangwuNewMoney;


    /**
     * 房屋介绍
     */
    private String fangwuContent;


    /**
     * 逻辑删除
     */
    private Integer fangwuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
