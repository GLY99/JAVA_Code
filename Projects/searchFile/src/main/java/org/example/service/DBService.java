package org.example.service;

import org.example.dao.InitDAO;

public class DBService {
    private final InitDAO initDAO = new InitDAO();
    public void Init(){
        initDAO.init();
    }
}
