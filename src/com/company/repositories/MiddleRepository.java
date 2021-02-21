package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Middle;
import com.company.repositories.interfaces.IMiddleRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * MiddleRepository inherits from IMiddleRepository interface
 */
public class MiddleRepository implements IMiddleRepository {
    private final IDB db;
    public MiddleRepository(IDB db) {
        this.db = db;
    }

    /**
     * Overloaded method with default parameter values
     * @param mid
     * @return boolean value
     */
    @Override
    public boolean createMiddle(Middle mid) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO middle(name,surname,gender, position) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, mid.getName());
            st.setString(2, mid.getSurname());
            st.setBoolean(3, mid.getGender());
            st.setString(4, mid.getPosition());

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
     * Overridden getMiddle method with default parameter values
     * @return integer value
     */
    @Override
    public Middle getMiddle(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            //select values from the low table by searching id
            String sql = "SELECT id,name,surname,gender,position FROM middle WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Middle mid = new Middle(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getString("position"));

                return mid;
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
     * Overridden getAllMiddles method with default parameter values
     * @return integer value
     */
    @Override
    public List<Middle> getAllMiddles() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender,position FROM middle";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Middle> mids = new ArrayList<>();
            while (rs.next()) {
                Middle mid = new Middle(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getString("position"));

                mids.add(mid);
            }

            return mids;
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