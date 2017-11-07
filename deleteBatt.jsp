<%@page import="pack.Battallion"%>
<jsp:useBean id="dd" scope="request" class="pack.Battallion"></jsp:useBean>
<%
String ba=request.getParameter("id");
Battallion bat=Battallion.getBattallion_From_ID(Integer.parseInt(ba));
dd.setBattallionId(bat.getBattallion_id()+"");
dd.setBattallion_name(bat.getBattallion_name());
dd.setLeader(bat.getLeader());
dd.setLocation(bat.getLocation());
dd.setBattallion_members(bat.getBattaion_members()+"");

dd.setOp("Do you want to delete "+dd.getBattallion_name().toUpperCase());
%>
<jsp:forward page="Battallion_Form.jsp"/>