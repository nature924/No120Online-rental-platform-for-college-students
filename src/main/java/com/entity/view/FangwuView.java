package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FangwuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 房屋
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("fangwu")
public class FangwuView extends FangwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 房屋类型的值
	*/
	@ColumnInfo(comment="房屋类型的字典表值",type="varchar(200)")
	private String fangwuValue;
	/**
	* 房屋状态的值
	*/
	@ColumnInfo(comment="房屋状态的字典表值",type="varchar(200)")
	private String fangwuZhuangtaiValue;

	//级联表 房东
		/**
		* 房东编号
		*/

		@ColumnInfo(comment="房东编号",type="varchar(200)")
		private String fangdongUuidNumber;
		/**
		* 房东姓名
		*/

		@ColumnInfo(comment="房东姓名",type="varchar(200)")
		private String fangdongName;
		/**
		* 房东手机号
		*/

		@ColumnInfo(comment="房东手机号",type="varchar(200)")
		private String fangdongPhone;
		/**
		* 房东身份证号
		*/

		@ColumnInfo(comment="房东身份证号",type="varchar(200)")
		private String fangdongIdNumber;
		/**
		* 房东头像
		*/

		@ColumnInfo(comment="房东头像",type="varchar(200)")
		private String fangdongPhoto;
		/**
		* 房东邮箱
		*/

		@ColumnInfo(comment="房东邮箱",type="varchar(200)")
		private String fangdongEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;



	public FangwuView() {

	}

	public FangwuView(FangwuEntity fangwuEntity) {
		try {
			BeanUtils.copyProperties(this, fangwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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
	//当前表的
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


	//级联表的get和set 房东

		/**
		* 获取： 房东编号
		*/
		public String getFangdongUuidNumber() {
			return fangdongUuidNumber;
		}
		/**
		* 设置： 房东编号
		*/
		public void setFangdongUuidNumber(String fangdongUuidNumber) {
			this.fangdongUuidNumber = fangdongUuidNumber;
		}

		/**
		* 获取： 房东姓名
		*/
		public String getFangdongName() {
			return fangdongName;
		}
		/**
		* 设置： 房东姓名
		*/
		public void setFangdongName(String fangdongName) {
			this.fangdongName = fangdongName;
		}

		/**
		* 获取： 房东手机号
		*/
		public String getFangdongPhone() {
			return fangdongPhone;
		}
		/**
		* 设置： 房东手机号
		*/
		public void setFangdongPhone(String fangdongPhone) {
			this.fangdongPhone = fangdongPhone;
		}

		/**
		* 获取： 房东身份证号
		*/
		public String getFangdongIdNumber() {
			return fangdongIdNumber;
		}
		/**
		* 设置： 房东身份证号
		*/
		public void setFangdongIdNumber(String fangdongIdNumber) {
			this.fangdongIdNumber = fangdongIdNumber;
		}

		/**
		* 获取： 房东头像
		*/
		public String getFangdongPhoto() {
			return fangdongPhoto;
		}
		/**
		* 设置： 房东头像
		*/
		public void setFangdongPhoto(String fangdongPhoto) {
			this.fangdongPhoto = fangdongPhoto;
		}

		/**
		* 获取： 房东邮箱
		*/
		public String getFangdongEmail() {
			return fangdongEmail;
		}
		/**
		* 设置： 房东邮箱
		*/
		public void setFangdongEmail(String fangdongEmail) {
			this.fangdongEmail = fangdongEmail;
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
		return "FangwuView{" +
			", fangwuValue=" + fangwuValue +
			", fangwuZhuangtaiValue=" + fangwuZhuangtaiValue +
			", fangdongUuidNumber=" + fangdongUuidNumber +
			", fangdongName=" + fangdongName +
			", fangdongPhone=" + fangdongPhone +
			", fangdongIdNumber=" + fangdongIdNumber +
			", fangdongPhoto=" + fangdongPhoto +
			", fangdongEmail=" + fangdongEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
