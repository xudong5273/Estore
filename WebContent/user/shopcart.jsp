<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
<!--文件头开始-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<base href="<%=basePath%>">
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="description" content="杰普电子商务门户">
		<title>杰普电子商务门户</title>
		<LINK href="css/main.css" rel=stylesheet>
		<script language = "JavaScript" src = "js/main.js"></script>
	</head>
	<body onLoad="MM_preloadImages('images/index_on.gif','images/reg_on.gif','images/order_on.gif','images/top/topxmas/jp_on.gif','images/top/topxmas/download_on.gif','images/top/topxmas/bbs_on.gif','images/top/topxmas/designwz_on.gif')" topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
	<jsp:include page="../head.jsp"></jsp:include>
<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href=index.jsp>杰普电子商务门户</a> →
					<img border="0" src="images/dog.gif" width="19" height="18">
					购物清单
                </td>
                </tr>
		</table>
              <br>

		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>产品名称</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>价格</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>数量</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>合计</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>操作</b></font></td>
		</tr>
		<%int i=1; %>
        <c:forEach items="${sessionScope.cart.orderlines}" var="orderline">
		<tr>
			<form method="post" action="user/updateProductSer" name="f1">
			<input type="hidden" name="productid" value="${orderline.product.productid}">
			<input type="hidden" name="number" value="${orderline.amount}">
			<td class=tablebody2 valign=middle align=center width=""><%=i++ %></td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="productDetailSer?product_id=${orderline.product.productid}">${orderline.product.name}</a></td>
			<td class=tablebody2 valign=middle align=center width="">${orderline.product.baseprice}</td>
			<td class=tablebody1 valign=middle align=center width="">
			<input name="num" type="text" size="4" value="${orderline.amount}"></input>
			</td>
			<td class=tablebody2 valign=middle align=left width="">&nbsp;&nbsp;￥${orderline.amount*orderline.product.baseprice}</td>
			<td class=tablebody1 valign=middle align=center width="">
			<input type="button" value="取消" onclick="javascript:window.location.href='user/removeProductSer?product_id=${orderline.product.productid}';"> <input type="submit" value="保存修改"></td>
			</form>
		</tr>
          </c:forEach>          
		<tr>
			<td class=tablebody1 valign=middle align=center colspan="4">　</td>
			<td class=tablebody1 valign=middle align=left width="">&nbsp;&nbsp;<font color="#ff0000"><b>￥${sessionScope.cart.totalPrice}</b></font></td>
			<td class=tablebody1 valign=middle align=center width="">　</td>
		</tr>
		<tr>
			<td class=tablebody2 valign=middle align=center colspan="6"><input type="button" value="提交订单" onclick="javascript:window.location='user/confirmOrder.jsp';"> <input type="button" value="继续购物" onclick="javascript:window.location='index.jsp';"> <input type="button" value="清空购物车" onclick="javascript:window.location='removeAllProduct.action';"></td>
		</tr>
                </table><br>
<!--文件尾开始-->
		<jsp:include page="../foot.jsp"></jsp:include>
	</body>
</html>







