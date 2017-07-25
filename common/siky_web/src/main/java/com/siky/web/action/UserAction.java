package com.siky.web.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.siky.domain.User;


/**
 * 用户管理
 */
@Namespace("/")
@ParentPackage("struts-default")
@Controller
@Scope("prototype")
public class UserAction extends CommonAction<User> {
	//属性驱动，接收页面输入的验证码
	private String validateCode;

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	
	/**
	 * 基于shiro框架完成当前用户的认证操作
	 */
	@Action(value = "userAction_login", results = {
			@Result(name = "success", type = "redirect", location = "/index.html") ,
			@Result(name = "login", type = "redirect", location = "/login.jsp") })
	public String login(){
		
			return SUCCESS;
		
	}
	

	
}
