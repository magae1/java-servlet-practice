package com.demo;

import com.demo.util.MemberDAO;
import com.demo.util.Members;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("*.action")
public class MemberController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println("uri : " + uri);
        String contextPath = request.getContextPath();
        System.out.println("contextPath : " + contextPath);
        String cmd = uri.substring(contextPath.length());
        System.out.println("cmd : " + cmd);
        if (cmd.equals("/member/login.action")) {
            login(request, response);
            System.out.println("login");
            System.out.println("==================");
        } else if (cmd.equals("/member/join.action")) {
            insert(request, response);
            System.out.println("join");
            System.out.println("==================");
        } else if (cmd.equals("/member/read.action")) {
            getMember(request, response);
            System.out.println("read");
            System.out.println("==================");
        } else if (cmd.equals("/member/update.action")) {
            update(request, response);
            System.out.println("update");
            System.out.println("==================");
        } else if (cmd.equals("/member/delete.action")) {
            delete(request, response);
            System.out.println("delete");
            System.out.println("==================");
        } else if (cmd.equals("/member/list.action")) {
            list(request, response);
            System.out.println("list");
            System.out.println("==================");
        }
    }


    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();
        MemberDAO dao = new MemberDAO(application);
        List<Members> mList = dao.getList();
        dao.close();
        request.setAttribute("mList", mList);
        request.getRequestDispatcher("/member/memberList.jsp").forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext application = request.getServletContext();
        MemberDAO dao = new MemberDAO(application);
        Members member = dao.getMember(request.getParameter("id"));
        dao.close();
        if (member.getUserId() == null) {
            response.sendRedirect(request.getContextPath() + "/member/loginForm.jsp");
            return;
        }
        HttpSession session = request.getSession();
        session.setAttribute("loginId", member.getUserId());
        response.sendRedirect(request.getContextPath() + "/member/list.action");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext application = request.getServletContext();
        HttpSession session = request.getSession();
        Object loginId = session.getAttribute("loginId");
        if (loginId == null) {
            response.sendRedirect(request.getContextPath() + "/member/loginForm.jsp");
            return;
        }
        MemberDAO dao = new MemberDAO(application);
        Members member = dao.getMember(loginId.toString());
        if (member.getUserId() == null) {
            response.sendRedirect(request.getContextPath() + "/member/loginForm.jsp");
            return;
        }
        dao.delete(member.getUserId());
        session.invalidate();
        response.sendRedirect(request.getContextPath() + "/member/list.action");
    }

    private void getMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();
        MemberDAO dao = new MemberDAO(application);
        Members member = dao.getMember(request.getParameter("id"));
        dao.close();
        request.setAttribute("member", member);
        request.getRequestDispatcher("/member/read.jsp").forward(request, response);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();
        MemberDAO dao = new MemberDAO(application);
        Members member = new Members();
        member.setUserId(request.getParameter("id"));
        member.setUserPwd(request.getParameter("pwd"));
        member.setUserName(request.getParameter("name"));
        member.setEmail(request.getParameter("email"));
        member.setPhoneNo(null);
        member.setAddress(null);
        member.setRegDate(null);
        dao.insert(member);
        request.getRequestDispatcher("/member/list.action").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();
        HttpSession session = request.getSession();
        Object loginId = session.getAttribute("loginId");
        if (loginId == null) {
            response.sendRedirect(request.getContextPath() + "/member/updateForm.jsp");
            return;
        }

        MemberDAO dao = new MemberDAO(application);
        Members member = dao.getMember(loginId.toString());
        if (member.getUserId() == null) {
            response.sendRedirect(request.getContextPath() + "/member/updateForm.jsp");
            return;
        }
        member.setUserPwd(request.getParameter("pwd"));
        member.setUserName(request.getParameter("name"));
        member.setEmail(request.getParameter("email"));
        member.setPhoneNo(request.getParameter("phoneno"));
        dao.update(member);
        dao.close();
        response.sendRedirect(request.getContextPath() + "/member/list.action");
    }
}
