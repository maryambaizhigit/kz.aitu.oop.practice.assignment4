package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Top;
import com.company.repositories.interfaces.ITopRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TopRepository inherits from ITopRepository interface
 */
public class TopRepository implements ITopRepository {
    private final IDB db;
    public TopRepository(IDB db) {
        this.db = db;
    }

    /**
     * Overloaded method with default parameter values
     * @param top
     * @return boolean value
     */
    @Override
    public boolean createTop(Top top) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO tops(name,surname,gender, position) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, top.getName());
            st.setString(2, top.getSurname());
            st.setBoolean(3, top.getGender());
            st.setString(4, top.getPosition());

            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Overridden getTop method with default parameter values
     * @return integer value
     */
    @Override
    public Top getTop(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            //select values from the low table by searching id
            String sql = "SELECT id,name,surname,gender,position FROM tops WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Top top = new Top(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getString("position"));

                return top;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Overridden getAllTops method with default parameter values
     * @return integer value
     */
    @Override
    public List<Top> getAllTops() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender,position FROM tops";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Top> tops = new ArrayList<>();
            while (rs.next()) {
                Top top = new Top(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getString("position"));

                tops.add(top);
            }

            return tops;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}