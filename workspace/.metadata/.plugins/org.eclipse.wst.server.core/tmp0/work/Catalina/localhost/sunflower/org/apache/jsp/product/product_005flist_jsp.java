/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.30
 * Generated at: 2020-05-07 02:33:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.plantshop.product.*;
import java.sql.*;
import java.util.*;
import java.text.*;

public final class product_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/product/../module/bottom.jsp", Long.valueOf(1587045541885L));
    _jspx_dependants.put("/product/../module/top.jsp", Long.valueOf(1588731276364L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("java.text");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.plantshop.product");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>언제나 함께 썬플라워</title>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.0/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link href=\"./css/product_main.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"./css/product_list.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
 
request.setCharacterEncoding("utf-8"); 

//검색 처리 부분
String condition = ""; // 조건식의 초기값은 공백값으로 설정
String pname = "";
String category = "";

// 1. pname(상품이름)으로 검색
if(request.getParameter("pname") != null && !request.getParameter("pname").equals("")) {
	pname = request.getParameter("pname");
	condition = " where pname like '%" + pname + "%' order by id";
}

// 2. category(상품분류)로 검색
if(request.getParameter("category") != null && !request.getParameter("category").equals("")) {
	category = request.getParameter("category");
	condition = " where category='" + category + "' order by id"; // 카테고리는 문자이고 정해저 있어서 =과 홀따옴표를 사용
}

String pageNum = request.getParameter("pageNum"); // 넘어오는 페이지 번호 // 넘어오다 빠질 수 있으므로 int로 받지않음.

if(pageNum == null) { // 처음페이지를 열었을 때 아무페이지도 없을 때를 위해 작성.
	pageNum = "1"; // 처음 페이지
}

      out.write("\r\n");
      out.write("<div id=\"container\">        \r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/sunflower/module/etc.css\">\r\n");
      out.write("<script src=\"/sunflower/module/etc.js\"></script>\r\n");
      out.write("<header>\r\n");
      out.write("\t<div class=\"top_login\">\r\n");
 
request.setCharacterEncoding("utf-8"); 

String login_name = (String)session.getAttribute("login_name");
String login_id = (String)session.getAttribute("login_id");

session.setAttribute("login_id", login_id);

if(session.getAttribute("login_id") == null) { // 로그인이 되지 않은 상태

      out.write("\r\n");
      out.write("\t<div id=\"login\">\r\n");
      out.write("\t\t<a href=\"/sunflower/member/loginForm.jsp\">로그인</a>\r\n");
      out.write("\t\t<a href=\"/sunflower/member/joinForm.jsp\">회원가입</a>\r\n");
      out.write("\t\t<a href=\"/sunflower/cart/cart_list.jsp\">장바구니</a>\r\n");
      out.write("\t\t<a href=\"/sunflower/freeboard/freeboard_list.jsp\">고객센터</a>\r\n");
      out.write("\t</div>\r\n");
} else {
      out.write("\t<!-- 로그인이 된 상태 -->\r\n");
      out.write("\t<div id=\"login\">\r\n");
      out.write("\t\t<!-- admin이면 버튼이 나타남 -->\r\n");
      out.write("\t\t");
 if(login_id.equals("admin") == true) { login_name = "관리자"; 
      out.write("\r\n");
      out.write("\t\t\t<a href=\"/sunflower/product/product_list.jsp\">관리자 모드</a>\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t<a>");
      out.print(login_name );
      out.write("님</a>\r\n");
      out.write("\t\t<a href=\"/sunflower/member/logout.jsp\">로그아웃</a>\r\n");
      out.write("\t\t<a href=\"/sunflower/member/select.jsp\">개인정보 조회</a>\r\n");
      out.write("\t\t<a href=\"/sunflower/cart/cart_list.jsp\">장바구니</a>\r\n");
      out.write("\t\t<a href=\"/sunflower/freeboard/freeboard_list.jsp\">고객센터</a>\r\n");
      out.write("\t</div>\r\n");
} 
      out.write("                   \r\n");
      out.write("\t</div>    \r\n");
      out.write("\t      <div id=\"total_menu\">\r\n");
      out.write("\t\t<div id=\"logo\">\r\n");
      out.write("\t\t\t<img class=\"imgbtn\" src=\"/sunflower/image/logo.png\" onclick=\"location.href='/sunflower/index.jsp'\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<nav id=\"title_menu\">\r\n");
      out.write("\t\t\t<form action=\"/sunflower/shop_list.jsp\" method=\"post\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"searchPname\" name=\"searchPname\" placeholder=\"상품명 검색\">\r\n");
      out.write("\t\t\t\t<input type=\"image\" src=\"/sunflower/image/search.png\" height=\"30px\">\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</nav>\t\r\n");
      out.write("\t\t<nav id=\"submenu_nav\">\r\n");
      out.write("\t\t\t<div id=\"submenu_item\">\r\n");
      out.write("\t\t\t\t<a href=\"/sunflower/shop_list.jsp\">전체 상품</a>\r\n");
      out.write("\t\t\t\t<a href=\"/sunflower/shop_list_item.jsp?item=new\">새로운 상품</a>\r\n");
      out.write("\t\t\t\t<a href=\"/sunflower/shop_list_item.jsp?item=best\">인기 상품</a>\r\n");
      out.write("\t\t\t\t<a href=\"/sunflower/shop_list_item.jsp?item=mditem\">추천 상품</a>\r\n");
      out.write("\t\t\t\t<a href=\"/sunflower/shop_list_item.jsp?item=sale\">할인 상품</a>\r\n");
      out.write("\t\t\t\t<a href=\"/sunflower/shop_list.jsp?category=11\">공기정화 식물</a>\r\n");
      out.write("\t\t\t\t<a href=\"/sunflower/shop_list.jsp?category=22\">인테리어 식물</a>\r\n");
      out.write("\t\t\t\t<div id=\"detail_menu\" class=\"detail_menu1\">\r\n");
      out.write("\t\t\t\t\t<a id=\"detail_title\" href=\"/sunflower/shop_list.jsp?category=33\">꽃선물</a>\r\n");
      out.write("\t\t\t\t\t<div id=\"detail_bar\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/sunflower/shop_list.jsp?category=331\">꽃다발</a><br>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/sunflower/shop_list.jsp?category=332\">꽃바구니</a><br>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/sunflower/shop_list.jsp?category=333\">꽃상자</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"detail_menu\" class=\"detail_menu2\">\r\n");
      out.write("\t\t\t\t\t<a id=\"detail_title\" href=\"/sunflower/shop_list.jsp?category=44\">소품샵</a>\r\n");
      out.write("\t\t\t\t\t<div id=\"detail_bar\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/sunflower/shop_list.jsp?category=441\">화병</a><br>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/sunflower/shop_list.jsp?category=442\">꽃가위</a><br>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/sunflower/shop_list.jsp?category=443\">굿즈</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t</div>\r\n");
      out.write("</header>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t<section>\r\n");
      out.write("\t\t<div id=\"content\">\r\n");
      out.write("\t\t   \t<h2>상품 목록</h2>\r\n");
      out.write("\t\t\t\t<form name=\"search_form\" action=\"product_list.jsp\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t<table class=\"search_table\">\r\n");
      out.write("\t\t\t\t\t\t<tr class=\"first_row\">\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"50%\" class=\"first_col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"pname\" placeholder=\"상품명 검색\"> <input type=\"submit\" value=\"검색\">\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"50%\" class=\"second_col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"button\" value=\"주문 정보 확인\" onclick=\"location='../order/order_list_admin.jsp'\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"button\" value=\"고객 정보 확인\" onclick=\"location='../member/selectAll.jsp'\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"item_upload\" type=\"button\" value=\"상 품 등 록\" onclick=\"location='product_write.jsp?pageNum=");
      out.print(pageNum );
      out.write("&category=");
      out.print(category );
      out.write("&pname=");
      out.print(pname );
      out.write("'\">\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr class=\"second_row\">\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"product_list.jsp\"><div class=\"category\">전체</div></a>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"product_list.jsp?category=11\"><div class=\"category\">공기정화 식물</div></a>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"product_list.jsp?category=22\"><div class=\"category\">인테리어 식물</div></a>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"product_list.jsp?category=331\"><div class=\"category\">꽃다발</div></a>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"product_list.jsp?category=332\"><div class=\"category\">꽃바구니</div></a><br>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"product_list.jsp?category=333\"><div class=\"category\">꽃상자</div></a>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"product_list.jsp?category=441\"><div class=\"category\">화병</div></a>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"product_list.jsp?category=442\"><div class=\"category\">꽃가위</div></a>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"product_list.jsp?category=443\"><div class=\"category\">굿즈</div></a>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t");

			//페이징 처리 부분
			//페이지 - 한 화면, 로우 - 상품의 수
			int pageSize = 10; // 화면에서 표시할 상품의 갯수
			
			int currentPage = Integer.parseInt(pageNum); // 현재 페이지 번호
			int startRow = (currentPage - 1) * pageSize + 1; // // 현재 페이지에서 보여줄 첫번째 글 [ex. (3 - 1) * 3 + 1 = 7 ]
			int endRow = currentPage * pageSize; // 3 * 3 = 9 // 이게 맞지.
			int totalRow = 0; // 전체 글 수
			
			int id = 0;
			NumberFormat nf = NumberFormat.getInstance();
			String price_nf = null; // 포맷 설정한 정가 ex) 45,000
			String downprice_nf = null; // 포맷 설정한 판매가 ex) 45,000
			String stock_nf = null; // 포맷 설정한 재고량 ex) 1,111 // 1000개 이상 상품
			String category_str = null; // 상품분류가 11 -> "가구"
			
			Connection conn = null;
			Statement stmt = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			
			// 관리자 확인
			String pwd = request.getParameter("pwd");
			String db_pwd = "";
			
			// 페이징 처리 - 전체 게시물 갯수 받기
			ProductDBBean dbPro = ProductDBBean.getInstance();
			totalRow = dbPro.getProductCountCondition(condition);
			
			// 페이징 처리하여 상품 정보 얻기 - 몇 번부터 몇 개
			List<ProductDataBean> productList = dbPro.getProductListCondition(condition, startRow, pageSize);
			
			if(productList.isEmpty()) {
				out.println("<div align='center'><font color='red'><h4>상품이 없습니다.</h4></font></div>");
			} else {
				out.print("<table id='product_table'><tr>");
				out.print("<th width='4%'>번호</th>");
				out.print("<th width='10%'>상품분류</th>");
				out.print("<th width='21%'>상품명</th>");
				out.print("<th width='7%'>상품번호</th>");
				out.print("<th width='9%'>제조사</th>");
				out.print("<th width='9%'>판매시작일</th>");
				out.print("<th width='8%'>정가</th>");
				out.print("<th width='8%'>판매가</th>");
				out.print("<th width='6%'>재고량</th>");
				out.print("<th width='7%'>판매수량</th>");
				out.print("<th width='7%'>판매여부</th>");
				out.print("<th width='5%'>추천</th>");
				out.print("</tr>");
					
				for(int i=0; i<productList.size(); i++) {
					ProductDataBean product = productList.get(i);
					out.print("<tr>");
					out.print("<td class='center'>" + (startRow+i) + "</td>"); // 빙고 - startRow로 번호 계산
					// 상품분류가 11이라면 "가구"로 출력
					switch(product.getCategory()) { // Array 구체화를 해주지않았기 때문에 object타입으로 인식
						case "11": 
							category_str = "공기정화 식물";
							break;
						case "22":
							category_str = "인테리어 식물";
							break;
						case "331":
							category_str = "꽃다발";
							break;
						case "332":
							category_str = "꽃바구니";
							break;
						case "333":
							category_str = "꽃상자";
							break;
						case "441":
							category_str = "화병";
							break;
						case "442":
							category_str = "꽃가위";
							break;
						case "443":
							category_str = "굿즈";
							break;
						default:
							category_str = "기타";
							break;
					}
					out.print("<td class='center'>" + category_str + "</td>");
						
					// 상품명을 클릭했을 때 상품 상세보기로 이동 - category, pname, 페이지 번호를 가지고 이동
					out.print("<td class='left'><a href='product_update.jsp?");
					out.print("pageNum=" + pageNum + "&id=" + product.getId() + "&category=" + category + "&pname=" + pname + "'>");
					out.print(product.getPname() + "</a></td>");
					
					out.print("<td class='center'>" + product.getId() + "</td>");
					out.print("<td class='center'>" + product.getSname() + "</td>");
					out.print("<td class='center'>" + product.getInputdate() + "</td>");
					
					// 정가의 포맷형식을 지정
					price_nf = nf.format(product.getPrice());
					out.print("<td class='right'>" + price_nf  + "</td>");
					
					// 판매가(할인가)의 포맷형식을 지정
					downprice_nf = nf.format(product.getDownprice());
					out.print("<td class='right'>" + downprice_nf  + "</td>");
					
					// 재고량의 포맷형식을 지정
					stock_nf = nf.format(product.getStock());
					out.print("<td class='right'>" + stock_nf + "</td>");
					
					// 판매수량
					out.print("<td class='right'>" + product.getSalecount() + "</td>");
					// 판매 여부
					if(product.getSelling().equals("y")) {
						out.print("<td class='center'><font color='blue'>" + product.getSelling() + "</font></td>");
					} else {
						out.print("<td class='center'><font color='red'>" + product.getSelling() + "</font></td>");
					}
					
					// 추천 상품
					if(product.getMditem().equals("y")){
						out.print("<td class='center'><font color='blue'>" + product.getMditem() + "</font></td>");
					} else {
						out.print("<td class='center'><font color='red'>" + product.getMditem() + "</font></td>");
					}
					
					out.print("</tr>");
				} // end_for
			} // end_else
			out.print("</table>");
			out.print("<div align='right'>전체 상품 수 : " + totalRow + "</div>");
			
			// *** 페이징 처리 ***
			out.println("<div id='paging'>");
			if(totalRow > 0) {
				// int pageCount = (totalRow - 1) / pageSize + 1;           // true : false
				int totalPage = totalRow / pageSize + (totalRow % pageSize == 0 ? 0 : 1); // 전체 페이지 수 // 직관적으로 나머지가 생기면 1을 더해주는 참 좋다~
				int startPage = 1; // 시작페이지
				
				int count = 10; // 표시할 페이지의 수. ex) 3이라면[1][2][3], 
				
				if(currentPage % count != 0) { // 페이지를 보여줄 갯수
					startPage = (int)(currentPage/count)*count + 1;
				} else {	
					startPage = (int)((currentPage/count)-1)*count + 1;
				}
				
				int endPage = startPage + count - 1; // 1, 4 // 1 + 3 - 1 = 3 // 4 + 3 - 1 = 6
				if(endPage > totalPage) endPage = totalPage;
				
				// 이전 페이지 유무 확인 // 이전을 눌렀을 때 count페이지(보여지는 페이지 갯수) 만큼 이전으로 이동
				if(startPage > count) { // 이전을 바꾸고 싶으면 pageNum을 혹은 cuurentPage를 3으로 나눴을때 1이면
					out.println("<a href='product_list.jsp?pageNum=1&category=" + category + "&pname=" + pname + "'>");
					out.println("<div id='pnum' class='page'>&lt&lt</div></a>");
					
					out.println("<a href='product_list.jsp?pageNum=" + (startPage-count) + "&category=" + category + "&pname=" + pname + "'>");
					out.println("<div id='pnum' class='page'>&lt</div></a>");
				} else {
					out.println("<div id='pnum' class='page'>&lt&lt</div>");
					out.println("<div id='pnum' class='page'>&lt</div>");
				}
				
				// 페이지 번호 출력
				for(int i=startPage; i<=endPage; i++) {
					if(i == currentPage) {
						out.println("<div id='pnum' class='spnum'>" + i + "</div>");
					} else {
						out.print("<a href='product_list.jsp?pageNum=" + i + "&category=" + category + "&pname=" + pname +"'>");
						out.println("<div id='pnum'>" + i + "</div></a>");
					}
				}
				
				// 다음을 눌렀을 때 count페이지만큼 다음으로 이동
				if(endPage < totalPage) {
					out.print("<a href='product_list.jsp?pageNum=" + (startPage+count) + "&category=" + category + "&pname=" + pname + "'>");
					out.println("<div id='pnum' class='page'>&gt;</div></a>");
					
					out.print("<a href='product_list.jsp?pageNum=" + totalPage + "&category=" + category + "&pname" + pname);
					out.println("'><div id='pnum' class='page'>&gt;&gt;</div></a>");
				} else {
					out.println("<div id='pnum' class='page'>&gt;</div>");
					out.println("<div id='pnum' class='page'>&gt;&gt;</div>");
				} 
				out.println("&nbsp;<font id='tot_pages' color='blue'>" + currentPage + "/" + totalPage + "</font>");
			}
		
			out.println("</div>");
			
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<footer>\r\n");
      out.write("\t<ul>\r\n");
      out.write("\t\t<li>COMPANY 썬플라워 주식회사 OWNER 조상익 C.P.O 조상익 E-mail npngj95@naver.com CALL CENTER 070-1234-5678</li>\r\n");
      out.write("\t\t<li>MALL ORDER LICENSE 2019-구미원평동-0001 호 [사업자정보확인] BUSINESS LICENSE 111-11-11111\r\n");
      out.write("\t\t<li> ADDRESS (우) 39221 경상북도 구미시 구미중앙로 1길 11</li>\r\n");
      out.write("\t\t<li><p>Copyright The SUNFLOWER All right reserved / design by JO / \r\n");
      out.write("\t\tAgreement / 개인정보취급방침 / Guide</p></li>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<li>고객님은 안전거래를 위해 현금 등으로 결제시 저희 쇼핑몰에서 가입한 PG사의 구매안전서비스를 이용하실 수 있습니다.</li>\r\n");
      out.write("\t\t<li>KG 이니시스 에스크로 (서비스가입사실확인)</li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</footer>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
