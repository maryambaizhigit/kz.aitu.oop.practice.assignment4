package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Cost;
import com.company.repositories.interfaces.ICostRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * CostRepository inherits from ICostRepository interface
 */
public class CostRepository implements ICostRepository {
        private final IDB db;

    /**
     * Overloaded constructor with default parameter values
     * @param db
     */
    public CostRepository(IDB db) {
            this.db = db;
        }

    /**
     * Overloaded method with default parameter values
     * @param cost
     * @return boolean value
     */
    @Override
        public boolean createCost(Cost cost) {
            Connection con = null;
            try {
                con = db.getConnection();
                //here we insert one value into our database
                String sql = "INSERT INTO cost(total) VALUES (?)";
                PreparedStatement st = con.prepareStatement(sql);
                st.setInt(1, cost.getTotal());
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
     * Overloaded method with default parameter values
     * @param total
     * @return integer value
     */
        @Override
        public Cost getCost(int total) {
            Connection con = null;
            try {
                con = db.getConnection();
                String sql = "SELECT total FROM cost";
                PreparedStatement st = con.prepareStatement(sql);

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    Cost cost = new Cost(rs.getInt("total"));

                    return cost;
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
     * Overridden getAllCosts method
     */
    public List<Cost> getAllCosts() {
            Connection con = null;
            try {
                con = db.getConnection();
                //select a value from the database
                String sql = "SELECT total FROM cost";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                List<Cost> costs = new ArrayList<>();
                while (rs.next()) {
                    Cost cost = new Cost(rs.getInt("total"));

                    costs.add(cost);
                }
                return costs;
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
