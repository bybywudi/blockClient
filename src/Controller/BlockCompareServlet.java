package Controller;

import Dao.UserDaoImpl;
import Domain.ProblemBlock;
import Utils.XmlUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/BlockCompareServlet")
public class BlockCompareServlet extends javax.servlet.http.HttpServlet {


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String hash = request.getParameter("hash");
        String host = request.getParameter("host");
        String index = request.getParameter("index");
        String mid = request.getParameter("mid");
        String qid = request.getParameter("qid");
        String ip = request.getParameter("ip");
        String res = request.getParameter("res");
        UserDaoImpl dao = new UserDaoImpl();

        ProblemBlock pb = dao.getIndexBlock(Integer.parseInt(hash));
        if(hash.equals(pb.getHash().toString()) && host.equals(pb.getHost()) && index.equals(pb.getIndex()) && mid.equals(pb.getMid()) && qid.equals(pb.getQid()) && ip.equals(pb.getIp()) && res.equals(pb.getRes())){
            response.setStatus(200);
        }else{
            response.setStatus(201);
        }

        return;

    }
}

