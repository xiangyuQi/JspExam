package com.hand.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entity.Film;
import com.hand.entity.Language;
import com.hand.service.FilmService;
import com.hand.service.LanguageService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


public class FilmAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request ;
	private HttpServletResponse response;
	private FilmService service = new FilmService();
	
    public FilmAction() {
        super();
    }
    void add()  throws ServletException, IOException {
    	String title = request.getParameter("title");
		String description = request.getParameter("description");
		String languageId = request.getParameter("languageId");
		Film f = new Film();
		f.setTitle(title);
		f.setDescription(description);
		Language l = new Language();
		l.setLanguageId(Byte.parseByte(languageId));
		f.setLanguage(l);
		RequestDispatcher rd = null;
		if(service.insert(f)>0){
			request.setAttribute("msg","添加成功！");
		}else{
			request.setAttribute("msg", "添加失败，请检查");
		}
		rd = request.getRequestDispatcher("/filmAdd.jsp");
		rd.forward(request, response);
    }
    
    void list() throws ServletException, IOException{
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
		request.setAttribute("films", films);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/filmList.jsp");
		rd.forward(request, response);
    }
    
  	void  del() throws ServletException, IOException{
  		String filmId = request.getParameter("filmId");
		Film f = new Film();
		f.setFilmId(Short.parseShort(filmId));
		if(service.delete(f)>0){
			request.setAttribute("msg", "删除成功");
		}else{
			request.setAttribute("msg", "有外键关联，删除失败！");
		}
		String pageNo = request.getParameter("pageNo");
		RequestDispatcher rs = request.getRequestDispatcher("/FilmAction/list?pageNo="+pageNo);
		rs.forward(request, response);
    }

  	void putHtml() throws IOException{
  		 Configuration cfg = new Configuration(); 
  		cfg.setServletContextForTemplateLoading(
				getServletContext(), "WEB-INF/templates");
		
		String filmId = request.getParameter("filmId");
		Film f = service.getByID(filmId);
		String pageNo = request.getParameter("pageNo");
		//创建数据模型
		Map root = new HashMap();
		
		root.put("filmId", filmId);
		root.put("pageNo", pageNo);
		root.put("title", f.getTitle());
		root.put("description", f.getDescription());
		root.put("languageId",f.getLanguage().getLanguageId());
		List<Language> languages = new LanguageService().getAll();
		root.put("languages", languages);
		
		//加载模板文件
	    Template t1 = cfg.getTemplate("Modify.ftl");
	    //显示生成的数据
	    File file = new File(request.getSession().getServletContext().getRealPath("") +"/filmModify.html");
//	    if(file.exists()){
//	    	System.out.print("文件存在");
//	    }
	   
	   BufferedOutputStream fo = new BufferedOutputStream
			   				(new FileOutputStream(file));
	    Writer out = new OutputStreamWriter(fo);
	   // System.out.print(file.getAbsolutePath());
	    try {
			t1.process(root, out);
			out.flush();
		} catch (TemplateException e) {
		}finally {
			out.close();
			fo.close();
		}
  	}
  	
  	void modify()  throws ServletException, IOException{
  		String filmId = request.getParameter("filmId");
  		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String languageId = request.getParameter("languageId");
//		System.out.println(filmId);
//		System.out.println(title);
//		System.out.println(description);
//		System.out.println(languageId);
		if(title ==null || description==null||languageId==null){
			putHtml();
			response.sendRedirect("/filmModify.html");
		}else{
			Film f = service.getByID(filmId);
			f.setTitle(title);
			f.setDescription(description);
			f.getLanguage().setLanguageId(Byte.parseByte((languageId)));
			service.update(f);
			request.setAttribute("msg", "修改成功！");
			String pageNo = request.getParameter("pageNo");
			RequestDispatcher rs = request.getRequestDispatcher("/FilmAction/list?pageNo="+pageNo);
			rs.forward(request, response);
		}
  	}
  	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		this.response = response;
		String path = request.getServletPath() ;
		if(path.endsWith("add")){
			add();
		}else if(path.endsWith("list")){
			list();
		}else if(path.endsWith("delete")){
			del();
		}else if(path.endsWith("modify")){
			modify();
		}
	}

}