/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jackie;

import com.jackie.JDBC.H01_DBManager;
import com.jackie.JDBC.H02_DBOperations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.HashMap;


/**
 *
 * @author jacki
 */
public class DatabaseOperation {
    /*
 * The programs are designed for PDC paper
 */ 
/**
 *
 * @author Quan Bai and Weihua Li
 * @Note Database Operation Component
 */

    private Database dbManager;

    public DatabaseOperation() { 
        dbManager = new Database();
    }

    public void createTable() {
        try {
            DatabaseMetaData dbm = this.dbManager.conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "MOVIE", null);
            Statement statement = dbManager.getConnection().createStatement();
            String movieTable = "Movie";
            String showTimeTable = "ShowTime";
            String seatTable = "Seat";
            if(!tables.next()){
                //Create Movie table
                String sqlCreate = "create table " + movieTable + " ("
                        + "Movie_id int PRIMARY KEY,"
                        + "Name varchar(30), Length int, Castings varchar(100),"
                        + "Director varchar(20), Category varchar(20), Rating double,"
                        + "Type varchar(20), Description varchar(1000), Image varchar(50))";
                statement.executeUpdate(sqlCreate);
                
                //Create ShowTime table
                sqlCreate = "create table " + showTimeTable + " (ShowTime_id int not null PRIMARY KEY,"
                        + "Date varchar(20), Time varchar(20), Price int,"
                        + "Movie_id int,"
                        + "FOREIGN KEY (Movie_id) REFERENCES Movie(Movie_id))";
                statement.executeUpdate(sqlCreate);
                
                //Create Seat table
                sqlCreate = "create table " + seatTable + " (Seat_id int not null PRIMARY KEY,"
                        + "Column1 int, Row int, Available boolean, ShowTime_id int,"
                        + "FOREIGN KEY (ShowTime_id) REFERENCES " + showTimeTable + "(ShowTime_id))";
                statement.executeUpdate(sqlCreate);
                
                //insert a movie to movie table
                String sqlInsert = "insert into " + movieTable + " values("
                    + "1,'Godzilla vs Kong', 113, 'Alexander Skarsgard, Rebecca Hall, Millie Bobby Brown',"
                    + "'Adam Wingard','G',4.5,'Action',"
                    + "'Legends collide in Godzilla vs. Kong as these mythic adversaries meet in a spectacular battle for the ages, with the fate of the world hanging in the balance. Kong and his protectors undertake a perilous journey to find his true home, and with them is Jia, a young orphaned girl with whom he has formed a unique and powerful bond. But they unexpectedly find themselves in the path of an enraged Godzilla, cutting a swath of destruction across the globe. The epic clash between the two titans—instigated by unseen forces—is only the beginning of the mystery that lies deep within the core of the Earth.',"
                    + "'/com/jackie/GodzillaVsKong.jpg')";
                statement.executeUpdate(sqlInsert); 

                
                //insert a showtime to showtime table
                sqlInsert = "insert into " + showTimeTable + " values("
                    + "1, '18/06', '08:00', 15, 1)";
                statement.executeUpdate(sqlInsert); 
                
                //insert a Seat to showtime table
                int id = 1;
                for(int y = 1; y < 5; y++){        
                    for(int x = 1; x < 5; x++){
                        sqlInsert = "insert into " + seatTable + " values("
                            + id + ", " + x + ", " + y + ", true, 1)";
                        statement.executeUpdate(sqlInsert); 
                        id++;
                    }
                }
            }



//            String sqlUpdateTable = "update " + newTableName + " set price=15000 "
//                    + "where brand='Toyota' and model='camry'";
//            statement.executeUpdate(sqlUpdateTable);

            //statement.close();
            System.out.println("Table created");

        } catch (SQLException ex) {
            Logger.getLogger(H02_DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public HashMap getAllMovieQuery() {
        HashMap<Integer, Movie> allMovie = new HashMap<>();
        ResultSet rs = null;

        try {

            System.out.println(" getting query....");
            Statement statement = dbManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sqlQuery = "select * from Movie";

            rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            while (rs.next()) {
                int movieid = rs.getInt("Movie_Id");
                String name = rs.getString("Name");
                int length = rs.getInt("Length");
                String castings = rs.getString("Castings");
                String director = rs.getString("Director");
                String category = rs.getString("Category");
                double rating = rs.getDouble("Rating");
                String type = rs.getString("Type");
                String description = rs.getString("Description");
                String image = rs.getString("Image");
                allMovie.put(movieid, new Movie(name, length, castings, director, category, rating, type, description, image));
            }
        } catch (SQLException ex) {
            Logger.getLogger(H02_DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
         return allMovie;
    }
}