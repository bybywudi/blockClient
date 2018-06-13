package Controller;

import Dao.UserDaoImpl;
import Domain.ProblemBlock;
import Utils.XmlUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.net.*;
import java.util.Enumeration;

@WebServlet("/BlockUpdateServlet")
public class BlockUpdateServlet extends javax.servlet.http.HttpServlet {


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String index = request.getParameter("index");
        String result = request.getParameter("result");
        String ip = request.getParameter("ip");
        String qid = request.getParameter("qid");
        String mid = request.getParameter("mid");
        String host = request.getParameter("host");

        UserDaoImpl dao = new UserDaoImpl();

        Document document = null;
        try {
            document = XmlUtils.getResBlocksDocument();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Element e = (Element) root.selectSingleNode("nowid");
        Attribute attr = e.attribute("id");
        int nowId = Integer.parseInt(attr.getValue()) + 1;

        ProblemBlock pb = new ProblemBlock();
        pb.setHash(dao.blockHash(nowId));
        pb.setIndex(index);
        pb.setIp(ip);
        pb.setRes(result);
        pb.setQid(qid);
        pb.setMid(mid);
        pb.setHost(host);
        pb.setTime(System.currentTimeMillis());
        dao.addNewResBolck(pb,nowId);
        return;

    }
}

