package com.entity.vo;

import com.entity.FangwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 房屋
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fangwu")
public class FangwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 房东
     */

    @TableField(value = "fangdong_id")
    private Integer fangdongId;


    /**
     * 房屋名称
     */

    @TableField(value = "fangwu_name")
    private String fangwuName;


    /**
     * 房屋编号
     */

    @TableField(value = "fangwu_uuid_number")
    private String fangwuUuidNumber;


    /**
     * 房屋照片
     */

    @TableField(value = "fangwu_photo")
    private String fangwuPhoto;


    /**
     * 房屋地点
     */

    @TableField(value = "fangwu_address")
    private String fangwuAddress;


    /**
     * 房屋信息文件
     */

    @TableField(value = "fangwu_file")
    private String fangwuFile;


    /**
     * 房屋类型
     */

    @TableField(value = "fangwu_types")
    private Integer fangwuTypes;


    /**
     * 房屋状态
     */

    @TableField(value = "fangwu_zhuangtai_types")
    private Integer fangwuZhuangtaiTypes;


    /**
     * 现价/积分
     */

    @TableField(value = "fangwu_new_money")
    private Double fangwuNewMoney;


    /**
     * 房屋介绍
     */

    @TableField(value = "fangwu_content")
    private String fangwuContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "fangwu_delete")
    private Integer fangwuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：房东
	 */
    public Integer getFangdongId() {
        return fangdongId;
    }


    /**
	 * 获取：房东
	 */

    public void setFangdongId(Integer fangdongId) {
        this.fangdongId = fangdongId;
    }
    /**
	 * 设置：房屋名称
	 */
    public String getFangwuName() {
        return fangwuName;
    }


    /**
	 * 获取：房屋名称
	 */

    public void setFangwuName(String fangwuName) {
        this.fangwuName = fangwuName;
    }
    /**
	 * 设置：房屋编号
	 */
    public String getFangwuUuidNumber() {
        return fangwuUuidNumber;
    }


    /**
	 * 获取：房屋编号
	 */

    public void setFangwuUuidNumber(String fangwuUuidNumber) {
        this.fangwuUuidNumber = fangwuUuidNumber;
    }
    /**
	 * 设置：房屋照片
	 */
    public String getFangwuPhoto() {
        return fangwuPhoto;
    }


    /**
	 * 获取：房屋照片
	 */

    public void setFangwuPhoto(String fangwuPhoto) {
        this.fangwuPhoto = fangwuPhoto;
    }
    /**
	 * 设置：房屋地点
	 */
    public String getFangwuAddress() {
        return fangwuAddress;
    }


    /**
	 * 获取：房屋地点
	 */

    public void setFangwuAddress(String fangwuAddress) {
        this.fangwuAddress = fangwuAddress;
    }
    /**
	 * 设置：房屋信息文件
	 */
    public String getFangwuFile() {
        return fangwuFile;
    }


    /**
	 * 获取：房屋信息文件
	 */

    public void setFangwuFile(String fangwuFile) {
        this.fangwuFile = fangwuFile;
    }
    /**
	 * 设置：房屋类型
	 */
    public Integer getFangwuTypes() {
        return fangwuTypes;
    }


    /**
	 * 获取：房屋类型
	 */

    public void setFangwuTypes(Integer fangwuTypes) {
        this.fangwuTypes = fangwuTypes;
    }
    /**
	 * 设置：房屋状态
	 */
    public Integer getFangwuZhuangtaiTypes() {
        return fangwuZhuangtaiTypes;
    }


    /**
	 * 获取：房屋状态
	 */

    public void setFangwuZhuangtaiTypes(Integer fangwuZhuangtaiTypes) {
        this.fangwuZhuangtaiTypes = fangwuZhuangtaiTypes;
    }
    /**
	 * 设置：现价/积分
	 */
    public Double getFangwuNewMoney() {
        return fangwuNewMoney;
    }


    /**
	 * 获取：现价/积分
	 */

    public void setFangwuNewMoney(Double fangwuNewMoney) {
        this.fangwuNewMoney = fangwuNewMoney;
    }
    /**
	 * 设置：房屋介绍
	 */
    public String getFangwuContent() {
        return fangwuContent;
    }


    /**
	 * 获取：房屋介绍
	 */

    public void setFangwuContent(String fangwuContent) {
        this.fangwuContent = fangwuContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getFangwuDelete() {
        return fangwuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setFangwuDelete(Integer fangwuDelete) {
        this.fangwuDelete = fangwuDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
