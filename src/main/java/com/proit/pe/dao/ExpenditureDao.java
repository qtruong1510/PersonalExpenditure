package com.proit.pe.dao;

import com.proit.pe.entity.Expenditure;
import com.proit.pe.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExpenditureDao {
    public Expenditure insert(Expenditure entity) throws Exception{
        String sql = "insert into Expenditures(name, amount, note, expenditureDate, type) "
                + " values(?, ?, ?, ?, ?) ";
        
        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt= con.prepareStatement(sql, 
                    PreparedStatement.RETURN_GENERATED_KEYS);) {

            pstmt.setString(1, entity.getName());
            pstmt.setDouble(2, entity.getAmount());
            pstmt.setString(3, entity.getNote());
            java.sql.Date date = new Date(entity.getExpenditureDate().getTime());
            pstmt.setDate(4, date);
            pstmt.setInt(5, entity.getType());
                        
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if (rs.next()){
                entity.setId(rs.getInt(1));
            }
            
            return entity;
        } 
    }
    
    public boolean update(Expenditure entity) throws Exception{
        String sql = "update Expenditures set "
                + " name = ?, amount = ?, note = ?, expenditureDate = ?, type = ? "
                + " where id = ? ";
        
        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt= con.prepareStatement(sql);) {

            pstmt.setString(1, entity.getName());
            pstmt.setDouble(2, entity.getAmount());
            pstmt.setString(3, entity.getNote());
            java.sql.Date date = new Date(entity.getExpenditureDate().getTime());
            pstmt.setDate(4, date);
            pstmt.setInt(5, entity.getType());
            
            pstmt.setInt(6, entity.getId());
            
            return pstmt.executeUpdate() > 0;
        } 
    }
    
    public boolean delete(int id) throws Exception{
        String sql = " delete from expenditures where id = ? ";
        
        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt= con.prepareStatement(sql);) {
            
            pstmt.setInt(1, id);
            
            return pstmt.executeUpdate() > 0;
        } 
    }
    
    public List<Expenditure> findAll() throws Exception{
        String sql = "select * from Expenditures ";
        
        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt= con.prepareStatement(sql);) {

            List<Expenditure> list = new ArrayList<>();
            
            try(ResultSet rs = pstmt.executeQuery();){
                while (rs.next()){
                    Expenditure entity = new Expenditure();
                    entity.setId(rs.getInt("id"));
                    entity.setName(rs.getString("name"));
                    entity.setAmount(rs.getDouble("amount"));
                    entity.setExpenditureDate(rs.getDate("expenditureDate"));
                    entity.setNote(rs.getString("note"));
                    entity.setType(rs.getInt("type"));
                    
                    list.add(entity);
                }
            }
            return list;
        } 
    }
    
    public Expenditure findById(int id) throws Exception{
        String sql = "select * from Expenditures where id = ?";
        
        try(Connection con = DatabaseUtil.getConnection();
            PreparedStatement pstmt= con.prepareStatement(sql);) {

            pstmt.setInt(1, id);
            
            try(ResultSet rs = pstmt.executeQuery();){
                if (rs.next()){
                    Expenditure entity = new Expenditure();
                    entity.setId(rs.getInt("id"));
                    entity.setName(rs.getString("name"));
                    entity.setAmount(rs.getDouble("amount"));
                    entity.setExpenditureDate(rs.getDate("expenditureDate"));
                    entity.setNote(rs.getString("note"));
                    entity.setType(rs.getInt("type"));
                    
                    return entity;
                }
            }
            return null;
        } 
    }
}
