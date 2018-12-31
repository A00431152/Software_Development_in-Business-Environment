<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleServiceclassProxyid" scope="session" class="com.bshree.mcda5510.service.ServiceclassProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleServiceclassProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleServiceclassProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleServiceclassProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.bshree.mcda5510.service.Serviceclass getServiceclass10mtemp = sampleServiceclassProxyid.getServiceclass();
if(getServiceclass10mtemp == null){
%>
<%=getServiceclass10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        java.lang.String getTrxns15mtemp = sampleServiceclassProxyid.getTrxns();
if(getTrxns15mtemp == null){
%>
<%=getTrxns15mtemp %>
<%
}else{
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getTrxns15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
}
break;
case 18:
        gotMethod = true;
        String ID_1id=  request.getParameter("ID21");
        int ID_1idTemp  = Integer.parseInt(ID_1id);
        java.lang.String deleteTrxns18mtemp = sampleServiceclassProxyid.deleteTrxns(ID_1idTemp);
if(deleteTrxns18mtemp == null){
%>
<%=deleteTrxns18mtemp %>
<%
}else{
        String tempResultreturnp19 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteTrxns18mtemp));
        %>
        <%= tempResultreturnp19 %>
        <%
}
break;
case 23:
        gotMethod = true;
        String id_2id=  request.getParameter("id26");
            java.lang.String id_2idTemp = null;
        if(!id_2id.equals("")){
         id_2idTemp  = id_2id;
        }
        String nameOnCard_3id=  request.getParameter("nameOnCard28");
            java.lang.String nameOnCard_3idTemp = null;
        if(!nameOnCard_3id.equals("")){
         nameOnCard_3idTemp  = nameOnCard_3id;
        }
        String unitprice_4id=  request.getParameter("unitprice30");
            java.lang.String unitprice_4idTemp = null;
        if(!unitprice_4id.equals("")){
         unitprice_4idTemp  = unitprice_4id;
        }
        String quantity_5id=  request.getParameter("quantity32");
            java.lang.String quantity_5idTemp = null;
        if(!quantity_5id.equals("")){
         quantity_5idTemp  = quantity_5id;
        }
        String totalprice_6id=  request.getParameter("totalprice34");
            java.lang.String totalprice_6idTemp = null;
        if(!totalprice_6id.equals("")){
         totalprice_6idTemp  = totalprice_6id;
        }
        String cardNumber_7id=  request.getParameter("cardNumber36");
            java.lang.String cardNumber_7idTemp = null;
        if(!cardNumber_7id.equals("")){
         cardNumber_7idTemp  = cardNumber_7id;
        }
        String expDate_8id=  request.getParameter("expDate38");
            java.lang.String expDate_8idTemp = null;
        if(!expDate_8id.equals("")){
         expDate_8idTemp  = expDate_8id;
        }
        java.lang.String updateTrxns23mtemp = sampleServiceclassProxyid.updateTrxns(id_2idTemp,nameOnCard_3idTemp,unitprice_4idTemp,quantity_5idTemp,totalprice_6idTemp,cardNumber_7idTemp,expDate_8idTemp);
if(updateTrxns23mtemp == null){
%>
<%=updateTrxns23mtemp %>
<%
}else{
        String tempResultreturnp24 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateTrxns23mtemp));
        %>
        <%= tempResultreturnp24 %>
        <%
}
break;
case 40:
        gotMethod = true;
        String ID_9id=  request.getParameter("ID43");
        int ID_9idTemp  = Integer.parseInt(ID_9id);
        java.lang.String getoneTrxns40mtemp = sampleServiceclassProxyid.getoneTrxns(ID_9idTemp);
if(getoneTrxns40mtemp == null){
%>
<%=getoneTrxns40mtemp %>
<%
}else{
        String tempResultreturnp41 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getoneTrxns40mtemp));
        %>
        <%= tempResultreturnp41 %>
        <%
}
break;
case 45:
        gotMethod = true;
        String ID_10id=  request.getParameter("ID48");
        int ID_10idTemp  = Integer.parseInt(ID_10id);
        String nameOnCard_11id=  request.getParameter("nameOnCard50");
            java.lang.String nameOnCard_11idTemp = null;
        if(!nameOnCard_11id.equals("")){
         nameOnCard_11idTemp  = nameOnCard_11id;
        }
        String unitprice_12id=  request.getParameter("unitprice52");
        double unitprice_12idTemp  = Double.parseDouble(unitprice_12id);
        String quantity_13id=  request.getParameter("quantity54");
        int quantity_13idTemp  = Integer.parseInt(quantity_13id);
        String totalPrice_14id=  request.getParameter("totalPrice56");
        double totalPrice_14idTemp  = Double.parseDouble(totalPrice_14id);
        String cardNumber_15id=  request.getParameter("cardNumber58");
            java.lang.String cardNumber_15idTemp = null;
        if(!cardNumber_15id.equals("")){
         cardNumber_15idTemp  = cardNumber_15id;
        }
        String expDate_16id=  request.getParameter("expDate60");
            java.lang.String expDate_16idTemp = null;
        if(!expDate_16id.equals("")){
         expDate_16idTemp  = expDate_16id;
        }
        java.lang.String insertTrxns45mtemp = sampleServiceclassProxyid.insertTrxns(ID_10idTemp,nameOnCard_11idTemp,unitprice_12idTemp,quantity_13idTemp,totalPrice_14idTemp,cardNumber_15idTemp,expDate_16idTemp);
if(insertTrxns45mtemp == null){
%>
<%=insertTrxns45mtemp %>
<%
}else{
        String tempResultreturnp46 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(insertTrxns45mtemp));
        %>
        <%= tempResultreturnp46 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>