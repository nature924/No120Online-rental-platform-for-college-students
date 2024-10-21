package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FangwuCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 房屋收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("fangwu_collection")
public class FangwuCollectionView extends FangwuCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String fangwuCollectionValue;

	//级联表 房屋
					 
		/**
		* 房屋 的 房东
		*/
		@ColumnInfo(comment="房东",type="int(11)")
		private Integer fangwuFangdongId;
		/**
		* 房屋名称
		*/

		@ColumnInfo(comment="房屋名称",type="varchar(200)")
		private String fangwuName;
		/**
		* 房屋编号
		*/

		@ColumnInfo(comment="房屋编号",type="varchar(200)")
		private String fangwuUuidNumber;
		/**
		* 房屋照片
		*/

		@ColumnInfo(comment="房屋照片",type="varchar(200)")
		private String fangwuPhoto;
		/**
		* 房屋地点
		*/

		@ColumnInfo(comment="房屋地点",type="varchar(200)")
		private String fangwuAddress;
		/**
		* 房屋信息文件
		*/

		@ColumnInfo(comment="房屋信息文件",type="varchar(200)")
		private String fangwuFile;
		/**
		* 房屋类型
		*/
		@ColumnInfo(comment="房屋类型",type="int(11)")
		private Integer fangwuTypes;
			/**
			* 房屋类型的值
			*/
			@ColumnInfo(comment="房屋类型的字典表值",type="varchar(200)")
			private String fangwuValue;
		/**
		* 房屋状态
		*/
		@ColumnInfo(comment="房屋状态",type="int(11)")
		private Integer fangwuZhuangtaiTypes;
			/**
			* 房屋状态的值
			*/
			@ColumnInfo(comment="房屋状态的字典表值",type="varchar(200)")
			private String fangwuZhuangtaiValue;
		/**
		* 现价/积分
		*/
		@ColumnInfo(comment="现价/积分",type="decimal(10,2)")
		private Double fangwuNewMoney;
		/**
		* 房屋介绍
		*/

		@ColumnInfo(comment="房屋介绍",type="longtext")
		private String fangwuContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer fangwuDelete;
	//级联表 用户
		/**
		* 用户编号
		*/

		@ColumnInfo(comment="用户编号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;



	public FangwuCollectionView() {

	}

	public FangwuCollectionView(FangwuCollectionEntity fangwuCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, fangwuCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getFangwuCollectionValue() {
		return fangwuCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setFangwuCollectionValue(String fangwuCollectionValue) {
		this.fangwuCollectionValue = fangwuCollectionValue;
	}


	//级联表的get和set 房屋
		/**
		* 获取：房屋 的 房东
		*/
		public Integer getFangwuFangdongId() {
			return fangwuFangdongId;
		}
		/**
		* 设置：房屋 的 房东
		*/
		public void setFangwuFangdongId(Integer fangwuFangdongId) {
			this.fangwuFangdongId = fangwuFangdongId;
		}

		/**
		* 获取： 房屋名称
		*/
		public String getFangwuName() {
			return fangwuName;
		}
		/**
		* 设置： 房屋名称
		*/
		public void setFangwuName(String fangwuName) {
			this.fangwuName = fangwuName;
		}

		/**
		* 获取： 房屋编号
		*/
		public String getFangwuUuidNumber() {
			return fangwuUuidNumber;
		}
		/**
		* 设置： 房屋编号
		*/
		public void setFangwuUuidNumber(String fangwuUuidNumber) {
			this.fangwuUuidNumber = fangwuUuidNumber;
		}

		/**
		* 获取： 房屋照片
		*/
		public String getFangwuPhoto() {
			return fangwuPhoto;
		}
		/**
		* 设置： 房屋照片
		*/
		public void setFangwuPhoto(String fangwuPhoto) {
			this.fangwuPhoto = fangwuPhoto;
		}

		/**
		* 获取： 房屋地点
		*/
		public String getFangwuAddress() {
			return fangwuAddress;
		}
		/**
		* 设置： 房屋地点
		*/
		public void setFangwuAddress(String fangwuAddress) {
			this.fangwuAddress = fangwuAddress;
		}

		/**
		* 获取： 房屋信息文件
		*/
		public String getFangwuFile() {
			return fangwuFile;
		}
		/**
		* 设置： 房屋信息文件
		*/
		public void setFangwuFile(String fangwuFile) {
			this.fangwuFile = fangwuFile;
		}
		/**
		* 获取： 房屋类型
		*/
		public Integer getFangwuTypes() {
			return fangwuTypes;
		}
		/**
		* 设置： 房屋类型
		*/
		public void setFangwuTypes(Integer fangwuTypes) {
			this.fangwuTypes = fangwuTypes;
		}


			/**
			* 获取： 房屋类型的值
			*/
			public String getFangwuValue() {
				return fangwuValue;
			}
			/**
			* 设置： 房屋类型的值
			*/
			public void setFangwuValue(String fangwuValue) {
				this.fangwuValue = fangwuValue;
			}
		/**
		* 获取： 房屋状态
		*/
		public Integer getFangwuZhuangtaiTypes() {
			return fangwuZhuangtaiTypes;
		}
		/**
		* 设置： 房屋状态
		*/
		public void setFangwuZhuangtaiTypes(Integer fangwuZhuangtaiTypes) {
			this.fangwuZhuangtaiTypes = fangwuZhuangtaiTypes;
		}


			/**
			* 获取： 房屋状态的值
			*/
			public String getFangwuZhuangtaiValue() {
				return fangwuZhuangtaiValue;
			}
			/**
			* 设置： 房屋状态的值
			*/
			public void setFangwuZhuangtaiValue(String fangwuZhuangtaiValue) {
				this.fangwuZhuangtaiValue = fangwuZhuangtaiValue;
			}

		/**
		* 获取： 现价/积分
		*/
		public Double getFangwuNewMoney() {
			return fangwuNewMoney;
		}
		/**
		* 设置： 现价/积分
		*/
		public void setFangwuNewMoney(Double fangwuNewMoney) {
			this.fangwuNewMoney = fangwuNewMoney;
		}

		/**
		* 获取： 房屋介绍
		*/
		public String getFangwuContent() {
			return fangwuContent;
		}
		/**
		* 设置： 房屋介绍
		*/
		public void setFangwuContent(String fangwuContent) {
			this.fangwuContent = fangwuContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getFangwuDelete() {
			return fangwuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setFangwuDelete(Integer fangwuDelete) {
			this.fangwuDelete = fangwuDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户编号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 用户编号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}


	@Override
	public String toString() {
		return "FangwuCollectionView{" +
			", fangwuCollectionValue=" + fangwuCollectionValue +
			", fangwuName=" + fangwuName +
			", fangwuUuidNumber=" + fangwuUuidNumber +
			", fangwuPhoto=" + fangwuPhoto +
			", fangwuAddress=" + fangwuAddress +
			", fangwuFile=" + fangwuFile +
			", fangwuNewMoney=" + fangwuNewMoney +
			", fangwuContent=" + fangwuContent +
			", fangwuDelete=" + fangwuDelete +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
