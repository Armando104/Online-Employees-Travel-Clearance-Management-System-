<%@page import="pack.Degree_Application"%>
<%@page import="java.util.Date"%>
<%@page import="pack.Application"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.DataInputStream"%>
<%
try{
    Degree_Application pp=new Degree_Application();
    int GetppID=(Integer)session.getAttribute("appID");
    String contentType = request.getContentType();
    System.out.println("Content type is :: " + contentType);
    if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {
        DataInputStream in = new DataInputStream(request.getInputStream());
        int formDataLength = request.getContentLength();

        byte dataBytes[] = new byte[formDataLength];
        int byteRead = 0;
        int totalBytesRead = 0;
        while (totalBytesRead < formDataLength) {
            byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
            totalBytesRead += byteRead;
        }

        String file = new String(dataBytes);

        String saveFile = file.substring(file.indexOf("filename=\"") + 10);
        saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
        saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1, saveFile.indexOf("\""));
        int lastIndex = contentType.lastIndexOf("=");
        String boundary = contentType.substring(lastIndex + 1, contentType.length());

        int pos;
        pos = file.indexOf("filename=\"");
        pos = file.indexOf("\n", pos) + 1;
        pos = file.indexOf("\n", pos) + 1;

        pos = file.indexOf("\n", pos) + 1;
        int boundaryLocation = file.indexOf(boundary, pos) - 4;
        int startPos = ((file.substring(0, pos)).getBytes()).length;
        int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
        File fdest = new File("C:\\Users\\OWNER\\Desktop\\Pics");
                if (fdest.exists()) {
                } else {
                    fdest.mkdir();
                }
                FileOutputStream fileOut1 = new FileOutputStream(fdest + "\\" + GetppID+ "!"  + saveFile);
                fileOut1.write(dataBytes, startPos, (endPos - startPos));
                fileOut1.flush();
                fileOut1.close();
                pp.setDegree(GetppID+ "!"  + saveFile);
                pp.setApp_id(GetppID);
                pp.setId(Degree_Application.getMaxID());
                pp.setRec_date(new Date());
               // pp.setStatus("In Process");
                if(pp.insert()){
                    out.println("true");
                }
                String msg="Record saved successfully!";
                request.setAttribute("ok", msg);
        
    } else {
        out.println("Not a file ");
    }

}catch(Exception e){
     out.println(e.toString());
}
%>
<jsp:forward page="ApplicantForm.jsp"/>