package com.versus.versus.domain.dao.impl;

import com.versus.util.DBUtil;
import com.versus.versus.domain.dao.SnackVersusDAO;
import com.versus.versus.domain.entity.Snack;
import com.versus.versus.domain.entity.SnackVersus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class SnackVersusDAOImpl implements SnackVersusDAO {
    @Autowired //스프링 컨테이너에 등록된 객체들중 일치하는 자료형을 통해 Injection
    DBUtil dbUtil;

    @Override
    public SnackVersus findByVersusId(Integer versusId) throws SQLException {
        Connection conn = dbUtil.getConnection();

        String sql = """
            SELECT sv.versus_id, sv.snack_id as snack_id, s.name as snack_name, s.image_url as img
            FROM snack_versus sv JOIN snack s ON sv.snack_id = s.id 
            WHERE sv.versus_id = ?
        """;
        PreparedStatement pstmt = conn.prepareStatement(sql);//DB서버에 sql문을 먼저 전송

        //물음표 수만큼의 데이터 설정!!
		//pstmt.setString(param인덱스번호,설정데이터);
        pstmt.setInt(1, versusId);

        ResultSet rs = pstmt.executeQuery();//DB서버에게 sql문 실행요청 (실행시점)
        //rs사용법==>1.행 얻어오기  2.행안의 열데이터 얻어오기

        SnackVersus snackVersus = new SnackVersus();
        snackVersus.setVersusId(versusId);
        snackVersus.setSnacks(new ArrayList<Snack>());

        while(rs.next()) {   //얻어올 행이 존재한다면 => 1.
            Snack snack = new Snack(
                    rs.getInt("snack_id"),
                    rs.getString("snack_name"),
                    rs.getString("img")
            );
            snackVersus.addSnack(snack);
        }
        return snackVersus;
    }

    @Override
    public void insert(Integer VersusId, Integer SnackId, Integer userId) throws SQLException {
        Connection conn = dbUtil.getConnection();
        String sql = "INSERT INTO snack_versus_vote (versus_id, snack_id, user_id) VALUES (?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, VersusId);
            pstmt.setInt(2, SnackId);
            pstmt.setInt(3, userId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
