package com.versus.versus.domain.dao.impl;

import com.versus.util.DBUtil;
import com.versus.versus.domain.dao.SnackVersusVoteDAO;
import com.versus.versus.domain.entity.Snack;
import com.versus.versus.domain.entity.SnackStatistics;
import com.versus.versus.domain.entity.User;
import com.versus.versus.domain.valueObject.enums.BloodType;
import com.versus.versus.domain.valueObject.enums.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SnackVersusVoteDAOImpl implements SnackVersusVoteDAO {
    @Autowired
    DBUtil dbUtil;

    @Override
    public SnackStatistics select(Integer SnackId, Integer VersusId) throws SQLException {
        Connection connection = dbUtil.getConnection();

        String sql = """
            SELECT
                s.id,
                s.name,
                s.image_url,
                CASE
                    WHEN u.age < 20 THEN 10
                    WHEN u.age < 30 THEN 20
                    WHEN u.age < 40 THEN 30
                    ELSE 40
                END AS age,
                u.bloodType,
                u.gender,
                count(*) as count
            FROM SNACK_VERSUS_VOTE AS svv
            JOIN SNACK AS s ON svv.SNACK_ID = s.ID
            JOIN USER AS u ON svv.USER_ID = u.userId
            WHERE VERSUS_ID = ? AND s.id = ?
            GROUP BY
                s.id,
                s.name,
                s.image_url,
                CASE
                    WHEN u.age < 20 THEN 10
                    WHEN u.age < 30 THEN 20
                    WHEN u.age < 40 THEN 30
                    ELSE 40
                END,
                u.bloodType,
                u.gender
            ORDER BY age, bloodType, gender;
        """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, VersusId);
            preparedStatement.setInt(2, SnackId);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                SnackStatistics statistics = new SnackStatistics();
                boolean isFirstRow = true;

                while (rs.next()) {
                    if (isFirstRow) {
                        Snack snack = new Snack();
                        snack.setId(rs.getInt("id"));
                        snack.setName(rs.getString("name"));
                        snack.setImageUrl(rs.getString("image_url"));
                        statistics.setSnack(snack);
                        isFirstRow = false;
                    }

                    User user = new User();
                    user.setAge(rs.getInt("age"));
                    user.setBloodType(BloodType.valueOf(rs.getString("bloodType")));
                    user.setGender(Gender.valueOf(rs.getString("gender")));

                    int voteCount = rs.getInt("count");
                    statistics.setUser(user, voteCount);
                }
                return statistics;
            }
        } finally {
            connection.close();
        }
    }
}
