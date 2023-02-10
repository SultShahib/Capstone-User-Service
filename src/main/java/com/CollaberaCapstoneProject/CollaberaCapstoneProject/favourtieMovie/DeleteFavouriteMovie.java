package com.CollaberaCapstoneProject.CollaberaCapstoneProject.favourtieMovie;


import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeleteFavouriteMovie {
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@oracle-aziz.cilyihqptvjt.us-east-1.rds.amazonaws.com:1521:ORCL";
    static final String USER = "adminaziz";
    static final String PASS = "sMArt123_x";

    public void deleteFavouriteMovie(String movieid, String userid) {
        List<String> similarIDs = new ArrayList<>();
        List<String> similarTitle = new ArrayList<>();
        List<String> similarTitle2 = new ArrayList<>();
        List<String> movieNames = new ArrayList<>();
        List<String> movieIDs = new ArrayList<>();
        List<String> movieID = new ArrayList<>();
        List<String> movieTitle = new ArrayList<>();

                RunQuery("DELETE FROM shahib_favourite_movie WHERE userid = " + userid + " AND movieid =" + movieid);

    }

    static void RunQuery(String myQuery) {
        Connection conn = null;
        Statement stmt = null;
        List<String> result = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = myQuery;
            ResultSet rs = stmt.executeQuery(sql);

//            while (rs.next()) {
//                result.add(rs.getString(myColumn));
//            }
            rs.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

//        return result;
    }
}





