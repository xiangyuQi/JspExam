package com.hand.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hand.entity.Actor;
import com.hand.service.ActorService;


public class ActorAction {
	private ActorService service = new ActorService();

	public void addActor(Actor t){
		service.insert(t);
	}

	public Actor getActor(String sno){
		Actor a = service.getByID(sno);
		if(a!=null){
			return a;
		}else{
			System.out.println("查询不到结果");
			return null;
		}
	}

	public void remove(Actor t){
		if( service.delete(t)>0){
			System.out.println("删除成功");
		}
		else
			System.out.println("ID不存在 删除失败");

	}

	public List<Actor> getAll(){
		return service.getAll();
	}

	public List<Actor> listPage( HttpServletRequest request){
		String SpageNo = request.getParameter("pageNo");
		int pageSize = 10;
		int all = service.getAll().size();
		int pageTotal = all/pageSize+1;
		if(all % pageSize  == 0)pageTotal -=1;
		if(SpageNo ==null){
			SpageNo = "1";
		}
		int pageNo = Integer.parseInt(SpageNo);
		if(pageNo<1) pageNo = 1;
		if(pageNo>pageTotal) pageNo = pageTotal;
		request.setAttribute("pageTotal",pageTotal);
		request.setAttribute("pageNo",pageNo);
		return service.listPage(pageNo, pageSize);
	}
}
