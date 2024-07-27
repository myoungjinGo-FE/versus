package com.versus.versus.domain.service.impl;

import com.versus.versus.domain.dao.SnackVersusDAO;
import com.versus.versus.domain.entity.SnackVersus;
import com.versus.versus.domain.service.SnackVersusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class SnackVersusServiceImpl implements SnackVersusService {
    @Autowired
    SnackVersusDAO snackVersusDAO;

    @Override
    public SnackVersus getSnackVersus(Integer VersusId) throws SQLException {
        return snackVersusDAO.findByVersusId(VersusId);
    }

    @Override
    public void voteForSnack(Integer VersusId, Integer SnackId, Integer userId) throws SQLException {
        snackVersusDAO.insert(VersusId, SnackId, userId);
    }
}
