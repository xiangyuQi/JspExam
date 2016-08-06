package com.hand.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hand.entity.Film;
import com.hand.entity.Language;
import com.hand.service.FilmService;
import com.hand.service.LanguageService;


public class FilmAction {
	private FilmService service = new FilmService();
	private LanguageService service2 = new LanguageService();
	public void addFilm(Film t){
		service.insert(t);
	}

	public Film getActor(String sno){
		Film a = service.getByID(sno);
		if(a!=null){
			return a;
		}else{
			System.out.println("查询不到结果");
			return null;
		}
	}

	public void remove(Film t){
		if( service.delete(t)>0){
			System.out.println("删除成功");
		}
		else
			System.out.println("ID不存在 删除失败");

	}

	public List<Film> getAll(){
		return service.getAll();
	}

	public List<Film> listPage( HttpServletRequest request){
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
		List<Film> films =service.listPage(pageNo, pageSize);
		for(int i =0;i<films.size();i++){
			Language l = service2.getByID(films.get(i).getLanguage().getLanguageId().toString());
			films.get(i).setLanguage(l);
		}
		return films;
	}
}
