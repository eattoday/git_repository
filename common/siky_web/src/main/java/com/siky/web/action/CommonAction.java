package com.siky.web.action;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.data.domain.Page;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
/**
 * 抽取共同的Action
 */
public class CommonAction<T> extends ActionSupport implements ModelDriven<T> {
	
	//模型对象
	private T model;
	
	@Override
	public T getModel() {
		return model;
	}
	
	/**
	 * 在运行期通过反射动态获得泛型类型,通过烦着创建model实例
	 */
	public CommonAction(){
		//参数化类型
		ParameterizedType commonActionType = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得类声明的泛型类型
		Type[] actualTypeArguments = commonActionType.getActualTypeArguments();
		//动态获得实体类的类型
		Class<T> entityClass = (Class<T>) actualTypeArguments[0];
		//通过反射创建model对象
		try {
			model = entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	//通过属性驱动,接受页面datagrid提交的分页参数page rows
	protected int page;
	protected int rows;
	public void setPage(int page){
		this.page=page;
	}
	public void setRows(int rows){
		this.rows=rows;
	}
	
	/**
	 * 将Page<T>对象转为Map,通过json-lib转为json,使用输出流写回到客户端
	 */
	public void page2json(Page<T> page,String[] ex){
		//总记录数
		long total=page.getTotalElements();
		//当前页需要展示的数据
		List<T> list=page.getContent();
		
		//将数据存入map集合
		Map<String,Object> map=new HashMap<>();
		map.put("total",total);
		map.put("rows", list);
		
		//将map对象转为json数据,提供给客户端,由datagrid解析
		JsonConfig config=new JsonConfig();
		config.setExcludes(ex);
		String json = JSONObject.fromObject(map, config).toString();
		
		//通过输出流将json数据写回客户端
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将List通过json-lib转为json，使用输出流写回到客户端
	 */
	public void list2json(List list,String[] ex){
		JsonConfig config = new JsonConfig();
		config.setExcludes(ex);
		String json = JSONArray.fromObject(list,config).toString();
		
		//通过输出流将json数据写回客户端
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}













