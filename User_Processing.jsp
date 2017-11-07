 

<%@page import="pack.*"%>
<jsp:useBean id="p" scope="request" class="pack.User">
    
    <jsp:setProperty name="p" property="*"  />
</jsp:useBean>

<%
    User pp=User.getUser(p.getUsername());
    
    if(pp!=null){
       p.setMsg("<h3 style=color:red>Username Already Exist</h3>");
    
    }else{
    p.setUser_status("unlocked");
    if(p.insert()){
    p.setMsg("<h3 style=color:green>User Successfully Created</h3>");
    
    }else{
    
    p.setMsg("<h3 style=color:red>User Not Created</h3>");
    
    }
    }
    
    
    %>
    <jsp:forward page="User_List.jsp"/>