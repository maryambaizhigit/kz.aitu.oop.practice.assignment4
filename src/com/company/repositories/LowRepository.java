package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Low;
import com.company.repositories.interfaces.ILowRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * LowRepository inherits from ILowRepository interface
 */
public class LowRepository implements ILowRepository {
    private final IDB db;
    /**
     * Overloaded constructor with default parameter values
     */
    public LowRepository(IDB db) {
        this.db = db;
    }

    /**
     * Overridden createLow method with default parameter values
     * @return boolean value
     */
    @Override
    public boolean createLow(Low low) {
        Connection con = null;
        try {
            con = db.getConnection();
            //here we insert some values into low table
            String sql = "INSERT INTO low(name,surname,gender, position) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, low.getName());
            st.setString(2, low.getSurname());
            st.setBoolean(3, low.getGender());
            st.setString(4, low.getPosition());
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
     * Overridden getLow method with default parameter values
     * @return integer value
     */
    @Override
    public Low getLow(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            //select values from the low table by searching id
            String sql = "SELECT id,name,surname,gender,position FROM low WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Low low = new Low(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getString("position"));

                return low;
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
     * Overridden getAllLows method with default parameter values
     * @return integer value
     */
    @Override
    public List<Low> getAllLows() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender,position FROM low";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Low> lows = new ArrayList<>();
            while (rs.next()) {
                Low low = new Low(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getString("position"));

                lows.add(low);
            }

            return lows;
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