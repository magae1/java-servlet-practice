package com.demo.util;

import jakarta.servlet.ServletContext;

import java.util.ArrayList;
import java.util.List;


public class MemberDAO extends JDBConnect {

    public MemberDAO(ServletContext application) {
        super(application);
    }

    public List<Members> getList() {
        List<Members> list = new ArrayList<Members>();
        String sql = "SELECT * FROM MEMBERS";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Members member = new Members();
                member.setUserId(rs.getString("userid"));
                member.setUserPwd(rs.getString("userpwd"));
                member.setUserName(rs.getString("username"));
                member.setPhoneNo(rs.getString("phoneno"));
                member.setAddress(rs.getString("address"));
                member.setEmail(rs.getString("email"));
                member.setRegDate(rs.getString("regdate"));
                list.add(member);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public Members getMember(String id) {
        Members member = new Members();
        String sql = String.format("SELECT * FROM MEMBERS WHERE userid = '%s'", id);
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            member.setUserId(rs.getString("userid"));
            member.setUserPwd(rs.getString("userpwd"));
            member.setUserName(rs.getString("username"));
            member.setPhoneNo(rs.getString("phoneno"));
            member.setAddress(rs.getString("address"));
            member.setEmail(rs.getString("email"));
            member.setRegDate(rs.getString("regdate"));
            }
        } catch (Exception e) {}
        return member;
    }

    public void insert(Members member) {
        String sql = "INSERT INTO MEMBERS (userid, userpwd, username, email, regdate) values (?, ?, ?, ?, sysdate())";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getUserId());
            pstmt.setString(2, member.getUserPwd());
            pstmt.setString(3, member.getUserName());
            pstmt.setString(4, member.getEmail());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {}
    }

    public void update(Members member) {
        String sql = "UPDATE MEMBERS " +
                "SET userid=?, userpwd=?, username=?, email=? " +
                "WHERE userid='"+member.getUserId()+"'";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getUserId());
            pstmt.setString(2, member.getUserPwd());
            pstmt.setString(3, member.getUserName());
            pstmt.setString(4, member.getEmail());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {}
    }

    public void delete(String id) {
        String sql = "DELETE FROM MEMBERS WHERE userid='"+id+"'";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {}
    }
}
