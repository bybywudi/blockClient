import Utils.DownLoadUtils;

import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/BlockServlet")
public class BlockServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String userid = request.getParameter("userid");
        String blockid = request.getParameter("blockid");

        if(userid == null || userid.trim() == "" || blockid == null || blockid.trim() == ""){
            request.setAttribute("message", "不合法的输入");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        try {
            Integer.parseInt(userid);
            Integer.parseInt(blockid);
        }catch (Exception e){
            request.setAttribute("message", "不合法的输入");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        HttpURLConnection connection = null;
        try{
            URL u = new URL("http://39.106.194.129:8080/block/BlockServlet"+"?userid="+userid+"&blockid="+blockid);
            connection = (HttpURLConnection)u.openConnection();
            connection.setConnectTimeout(200);
            //connection.setReadTimeout(2000);

            connection.setRequestMethod("GET");

            int code = connection.getResponseCode();

            if(code == 200){
                DownLoadUtils.downAndReadFile("http://39.106.194.129:8080/upfiles/block/blocks.xml");
                request.setAttribute("message", "增加区块成功！已为你自动同步");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }
            if(code == 207){
                DownLoadUtils.downAndReadFile("http://39.106.194.129:8080/upfiles/block/blocks.xml");
                request.setAttribute("message", "抱歉！该区块已被别人抢先添加！已为你自动同步");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }

        }catch(MalformedURLException e){
            //e.printStackTrace();
        }catch(IOException e){
            //e.printStackTrace();
        }finally{
            if(connection != null){
                connection.disconnect();
            }
        }
    }


}
