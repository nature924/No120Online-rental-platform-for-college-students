package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ForumEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 租房论坛
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("forum")
public class ForumView extends ForumEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 帖子状态的值
	*/
	@ColumnInfo(comment="帖子状态的字典表值",type="varchar(200)")
	private String forumStateValue;

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
//		/**
//		* 余额
//		*/
//		@ColumnInfo(comment="余额",type="decimal(10,2)")
//		private Double newMoney;
	//级联表 管理员
		/**
		* 儿童名
		*/
		@ColumnInfo(comment="儿童名",type="varchar(100)")
		private String uusername;
		/**
		* 密码
		*/
		@ColumnInfo(comment="密码",type="varchar(100)")
		private String upassword;
		/**
		* 角色
		*/
		@ColumnInfo(comment="角色",type="varchar(100)")
		private String urole;
		/**
		* 新增时间
		*/
		@ColumnInfo(comment="新增时间",type="timestamp")
		private Date uaddtime;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public ForumView() {

	}

	public ForumView(ForumEntity forumEntity) {
		try {
			BeanUtils.copyProperties(this, forumEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 帖子状态的值
	*/
	public String getForumStateValue() {
		return forumStateValue;
	}
	/**
	* 设置： 帖子状态的值
	*/
	public void setForumStateValue(String forumStateValue) {
		this.forumStateValue = forumStateValue;
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
//		*/
//		public Double getNewMoney() {
//			return newMoney;
//		}
//		/**
//		* 设置： 余额
//		*/
//		public void setNewMoney(Double newMoney) {
//			this.newMoney = newMoney;
//		}
//	//级联表的get和set 用户

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
	//级联表的get和set 管理员
		/**
		* 获取： 儿童名
		*/
		public String getUusername() {
			return uusername;
		}
		/**
		* 设置： 儿童名
		*/
		public void setUusername(String uusername) {
			this.uusername = uusername;
		}
		/**
		* 获取： 密码
		*/
		public String getUpassword() {
			return upassword;
		}
		/**
		* 设置： 密码
		*/
		public void setUpassword(String upassword) {
			this.upassword = upassword;
		}
		/**
		* 获取： 角色
		*/
		public String getUrole() {
			return urole;
		}
		/**
		* 设置： 角色
		*/
		public void setUrole(String urole) {
			this.urole = urole;
		}
		/**
		* 获取： 新增时间
		*/
		public Date getUaddtime() {
			return uaddtime;
		}
		/**
		* 设置： 新增时间
		*/
		public void setUaddtime(Date uaddtime) {
			this.uaddtime = uaddtime;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "ForumView{" +
			", forumStateValue=" + forumStateValue +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
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
