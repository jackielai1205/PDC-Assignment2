/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jackie;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author jacki
 */
public class DatabaseOperation {
/**
 *
 * @author jackie
 * @Note Database Operation Component
 */

    private final Database dbManager;

    public DatabaseOperation() { 
        dbManager = new Database();
    }

    //Initalize the database and insert record for demonstration
    public void createTable() {
        try {
            DatabaseMetaData dbm = this.dbManager.conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "MOVIE", null);
            Statement statement = dbManager.getConnection().createStatement();
            String movieTable = "Movie";
            String showTimeTable = "ShowTime";
            String seatTable = "Seat";
            String customerTable = "Customer";
            String bookingTable = "Booking";
            if(!tables.next()){
                //Create Movie table
                String sqlCreate = "create table " + movieTable + " ("
                        + "Movie_id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY " 
                        + "(START WITH 1, INCREMENT BY 1),"
                        + "Name varchar(30), Length int, Castings varchar(100),"
                        + "Director varchar(50), Category varchar(20), Rating double,"
                        + "Type varchar(20), Description varchar(1000), Image varchar(50))";
                statement.executeUpdate(sqlCreate);
                
                //Create ShowTime table
                sqlCreate = "create table " + showTimeTable + " (ShowTime_id int not null PRIMARY KEY GENERATED ALWAYS AS IDENTITY"
                        + "(START WITH 1, INCREMENT BY 1),"
                        + "Date varchar(20), Time varchar(20), Price int,"
                        + "Movie_id int,"
                        + "FOREIGN KEY (Movie_id) REFERENCES Movie(Movie_id))";
                statement.executeUpdate(sqlCreate);
                
                //Create Seat table
                sqlCreate = "create table " + seatTable + " (Seat_id int not null PRIMARY KEY GENERATED ALWAYS AS IDENTITY "
                        + "(START WITH 1, INCREMENT BY 1),"
                        + "Column1 int, Row int, Available boolean, ShowTime_id int,"
                        + "FOREIGN KEY (ShowTime_id) REFERENCES " + showTimeTable + "(ShowTime_id))";
                statement.executeUpdate(sqlCreate);
                
                //Create User table
                sqlCreate = "create table " + customerTable + " (User_id varchar(255) not null PRIMARY KEY,"
                        + "User_name varchar(255), User_password varchar(255))";
                statement.executeUpdate(sqlCreate);
                
                
                //Create Booking table
                sqlCreate = "create table " + bookingTable + "  (Booking_id int not null PRIMARY KEY GENERATED ALWAYS AS IDENTITY"
                        + "(START WITH 1, INCREMENT BY 1),"
                        + "ShowTime_id int, Seat_id int, User_id varchar(255), "
                        + "FOREIGN KEY (ShowTime_id) REFERENCES " + showTimeTable + "(ShowTime_id), "
                        + "FOREIGN KEY (Seat_id) REFERENCES " + seatTable + "(Seat_id), "
                        + "FOREIGN KEY (User_id) REFERENCES " + customerTable + "(User_id))";
                statement.executeUpdate(sqlCreate);
                
                //insert a movie to movie table
                String sqlInsert = "insert into " + movieTable + " (Name, Length, Castings, Director, Category, Rating, Type, Description, Image) values("
                    + "'Godzilla vs Kong', 113, 'Alexander Skarsgard, Rebecca Hall, Millie Bobby Brown',"
                    + "'Adam Wingard','G',4.5,'Action',"
                    + "'Legends collide in Godzilla vs. Kong as these mythic adversaries meet in a spectacular battle for the ages, with the fate of the world hanging in the balance. Kong and his protectors undertake a perilous journey to find his true home, and with them is Jia, a young orphaned girl with whom he has formed a unique and powerful bond. But they unexpectedly find themselves in the path of an enraged Godzilla, cutting a swath of destruction across the globe. The epic clash between the two titans—instigated by unseen forces—is only the beginning of the mystery that lies deep within the core of the Earth.',"
                    + "'/com/jackie/GodzillaVsKong.jpg')";
                statement.executeUpdate(sqlInsert); 
                
                //insert a movie to movie table
                sqlInsert = "insert into " + movieTable + " (Name, Length, Castings, Director, Category, Rating, Type, Description, Image) values("
                    + "'Mortal Kombat', 110, 'Lewis Tan, Jessica McNamee, Josh Lawson',"
                    + "'Simon McQuoid','M',3.5,'Action',"
                    + "'Mortal Kombat is a 2021 American martial arts fantasy film based on the video game franchise of the same name and a reboot of the Mortal Kombat film series.',"
                    + "'/com/jackie/MortalKombat.jpg')";
                statement.executeUpdate(sqlInsert); 
                
                //insert a movie to movie table
                sqlInsert = "insert into " + movieTable + " (Name, Length, Castings, Director, Category, Rating, Type, Description, Image) values("
                    + "'Avengers: Endgame', 181, 'Robert Downey Jr., Chris Evans, Mark Ruffalo',"
                    + "'Anthony Russo, Joseph Russo','M',4.0,'Action',"
                    + "'Avengers: Endgame is a 2019 American superhero film based on the Marvel Comics superhero team the Avengers. Produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures, it is the direct sequel to Avengers: Infinity War (2018) and the 22nd film in the Marvel Cinematic Universe (MCU).',"
                    + "'/com/jackie/AvengersEndgame.jpg')";
                statement.executeUpdate(sqlInsert); 

                
                //insert a showtime to showtime table
                sqlInsert = "insert into " + showTimeTable + "(Date, Time, Price, Movie_id) values("
                + "'18/06', '08:00', 15, 1)";
                statement.executeUpdate(sqlInsert); 

                sqlInsert = "insert into " + showTimeTable + " (Date, Time, Price, Movie_id) values("
                + "'18/06', '12:00', 15, 1)";
                statement.executeUpdate(sqlInsert); 

                sqlInsert = "insert into " + showTimeTable + " (Date, Time, Price, Movie_id) values("
                + "'22/06', '12:00', 15, 1)";
                statement.executeUpdate(sqlInsert); 

                sqlInsert = "insert into " + showTimeTable + " (Date, Time, Price, Movie_id) values("
                + "'18/06', '08:00', 15, 2)";
                statement.executeUpdate(sqlInsert); 

                sqlInsert = "insert into " + showTimeTable + " (Date, Time, Price, Movie_id) values("
                + "'18/06', '12:00', 15, 2)";
                statement.executeUpdate(sqlInsert); 
                
                sqlInsert = "insert into " + showTimeTable + " (Date, Time, Price, Movie_id) values("
                + "'22/06', '12:00', 15, 2)";
                statement.executeUpdate(sqlInsert); 
                
                sqlInsert = "insert into " + showTimeTable + " (Date, Time, Price, Movie_id) values("
                + "'25/06', '14:00', 30, 2)";
                statement.executeUpdate(sqlInsert); 
                
                sqlInsert = "insert into " + showTimeTable + " (Date, Time, Price, Movie_id) values("
                + "'21/06', '10:00', 30, 3)";
                statement.executeUpdate(sqlInsert);
                
                sqlInsert = "insert into " + showTimeTable + " (Date, Time, Price, Movie_id) values("
                + "'21/06', '12:00', 45, 3)";
                statement.executeUpdate(sqlInsert); 
                
                sqlInsert = "insert into " + showTimeTable + " (Date, Time, Price, Movie_id) values("
                + "'24/06', '13:00', 30, 3)";
                statement.executeUpdate(sqlInsert); 

                
                
                //insert Seats to showtime table
                for(int x = 1; x <= 10; x++){
                    this.addSeatTable(x);
                }

                
                
                               
            }

            //statement.close();  
            System.out.println("Table created");

        } catch (SQLException ex) {
            System.out.println("You encountered an exception. Please try again");
            System.out.println(ex);
        }
    }

    //Get movie data from database and retunr as a HashMap
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
                allMovie.put(movieid, new Movie(movieid, name, length, castings, director, category, rating, type, description, image));
            }
        } catch (SQLException ex) {
            System.out.println("You encountered an exception. Please try again");
            System.out.println(ex);
        }
         return allMovie;
    }
    
    //Get the showtime info from database
    public ArrayList getAllShowTimeQuery(int movieid) {
        ArrayList<ShowTime> showTimes = new ArrayList<>();
        ResultSet rs = null;

        try {

            System.out.println(" getting query....");
            Statement statement = dbManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sqlQuery = "select * from ShowTime where MOVIE_ID =" + movieid;

            rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            while (rs.next()) {
                int showtimeid = rs.getInt("Showtime_ID");
                String date = rs.getString("date");
                String time = rs.getString("Time");
                int price = rs.getInt("Price");
  
                showTimes.add(new ShowTime(date, time, price, showtimeid));
            }
            System.out.println(movieid);
            System.out.println(showTimes.get(0).getKey());
        } catch (SQLException ex) {
            System.out.println("You encountered an exception. Please try again");
            System.out.println(ex);
        }
         return showTimes;
    }
    
    //Get the seat info from database
    public ArrayList getSeatQuery(int showtimeid) {
        ArrayList<Seat> seats = new ArrayList<>();
        ResultSet rs = null;

        try {
            System.out.println(" getting query....");
            Statement statement = dbManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sqlQuery = "select * from SEAT where showtime_id =" + showtimeid;

            rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            while (rs.next()) {
                int seatid = rs.getInt("SEAT_ID");
                int column = rs.getInt("Column1");
                int row = rs.getInt("Row");
                boolean available = rs.getBoolean("Available");
  
                seats.add(new Seat(seatid, available, column, row));
            }
        } catch (SQLException ex) {
            System.out.println("You encountered an exception. Please try again");
            System.out.println(ex);
        }
        
         return seats;
    }
    
    //Update the seat status when customer made booking
    public void updateSeat(int seatid){
        ResultSet rs = null;

        try {
            System.out.println(" getting query....");
            Statement statement = dbManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            System.out.println(seatid);

            String sqlUpdateTable = "update SEAT set available = false"
                    + " where SEAT_ID = " + seatid;
            statement.executeUpdate(sqlUpdateTable);

        } catch (SQLException ex) {
            System.out.println("You encountered an exception. Please try again");
            System.out.println(ex);
        }
    }
    
    //Update booking info after customer made booking
    public void InsertBooking(String userid, int showtimeid, int seatid){
        ResultSet rs = null;
        
            System.out.println(userid);
            System.out.println(showtimeid);
            System.out.println(seatid);

        try {
            
            System.out.println(" getting query....");
            Statement statement = dbManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            System.out.println(userid);

            PreparedStatement sqlInsertStatement = dbManager.getConnection().prepareStatement("insert into Booking (ShowTime_id, Seat_id, User_id) values(?,?,?)"); 
            sqlInsertStatement.setInt(1, showtimeid);
            sqlInsertStatement.setInt(2, seatid);
            sqlInsertStatement.setString(3, userid);
            sqlInsertStatement.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    //Update new customer info to database after register
    public void updateUserAfterRegister(User user){
        ResultSet rs = null;
        
        try{
            System.out.println(" getting query....");
            Statement statement = dbManager.getConnection().createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY);
            
            String sqlInsert = "insert into Customer (User_id, User_name, User_password) values (?, ?, ?)";
            PreparedStatement stmp;
            Connection conn = dbManager.getConnection();
            stmp = conn.prepareStatement(sqlInsert);
            stmp.setString(1, user.getEmail());
            stmp.setString(2, user.getName());
            stmp.setString(3, user.getPassword());
            stmp.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    //Get all user data from database
    public ArrayList getUser(){
        ArrayList<User> user = new ArrayList<>();
        ResultSet rs = null;
        
        try{
            System.out.println(" getting query....");
            Statement statement = dbManager.getConnection().createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY);
            
            String sqlSelect = "select * from Customer";
            rs = statement.executeQuery(sqlSelect);
            if(rs != null){
                rs.beforeFirst();
                while (rs.next()) {
                String userId = rs.getString("User_id");
                String userName = rs.getString("User_name");
                String userPassword = rs.getString("User_password");
                user.add(new User(userId, userName, userPassword));
                }
            }
        } catch (SQLException ex) {
            System.out.println("You encountered an exception. Please try again");
            System.out.println(ex);
        }
        return user;
    }
    
    //Use user_id to seach all booking data under this user 
    public ArrayList<Booking> getUserBookingFromBooking(String userId){
        ArrayList<Booking> booking = new ArrayList<>();
        ResultSet rs = null;
        
        try{
            System.out.println(" getting query....");
            String sqlSelect = "select * from Booking where User_id = ?";
            PreparedStatement stmp;
            Connection conn = dbManager.getConnection();
            stmp = conn.prepareStatement(sqlSelect, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmp.setString(1, userId);
            rs = stmp.executeQuery();
            if(rs != null){
                rs.beforeFirst();
                while (rs.next()) {
                    int booking_id = rs.getInt(1);
                    int showTime_id = rs.getInt(2);
                    int seat_id = rs.getInt(3);
                    booking.add(new Booking(booking_id, showTime_id, seat_id, userId));
                }
            }
        } catch (SQLException ex){
            System.out.println("You encountered an exception. Please try again");
            System.out.println(ex);
        }
        return booking;
    }
    
    //Use showTime_id to seach all showtime data under this showTime id
    public ShowTime getUserShowTimeInfo(int showTime_id){
        ShowTime showTime = null;
        ResultSet rs = null;
        try{
            System.out.println(" getting query....");
            
            String sqlSelect = "select * from ShowTime where ShowTime_id = ?";
            PreparedStatement stmp;
            Connection conn = dbManager.getConnection();
            stmp = conn.prepareStatement(sqlSelect, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmp.setInt(1, showTime_id);
            rs = stmp.executeQuery();
            if(rs != null){
                rs.beforeFirst();
                while (rs.next()) {
                    String date = rs.getString(2);
                    String time = rs.getString(3);
                    int price = rs.getInt(4);
                    int movie_id = rs.getInt(5);
                    showTime = new ShowTime(showTime_id, date, time, price, movie_id);
                }
            }
        } catch (SQLException ex){
            System.out.println("You encountered an exception. Please try again");
            System.out.println(ex);
        }
        return showTime;
    }
    
    //Use movie_id to search movie info
    public String getBookingMovieName(int movieid){
        String movieName = "";
        ResultSet rs = null;
        try{
            System.out.println(" getting query....");
            String sqlSelect = "select * from MOVIE where MOVIE_ID = ?";
            PreparedStatement stmp;
            Connection conn = dbManager.getConnection();
            stmp = conn.prepareStatement(sqlSelect, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmp.setInt(1, movieid);
            rs = stmp.executeQuery();
            if(rs != null){
                rs.beforeFirst();
                while (rs.next()) {
                    movieName = rs.getString(2);
                }
            }
        } catch(SQLException ex){
            System.out.println("You encountered an exception. Please try again");
            System.out.println(ex);
        }
        return movieName;
    }
    
    //Use booking_id to cancel booking for table BOOKING
    public void cancelBooking(int booking_id){
        try{
            System.out.println(" getting query....");
            String sqlCancel = "delete from BOOKING where BOOKING_ID = ?";
            PreparedStatement stmp;
            Connection conn = dbManager.getConnection();
            stmp = conn.prepareStatement(sqlCancel, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmp.setInt(1, booking_id);
            stmp.executeUpdate();
        } catch(SQLException ex){
            System.out.println("You encountered an exception. Please try again");
            System.out.println(ex);
        }
    }
    
    //Use seatid to cancel booking for Table SEAT
    public void updateSeatAfterCancelBooking(int seatid){
        ResultSet rs = null;

        try {
            System.out.println(" getting query....");
            Statement statement = dbManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            System.out.println(seatid);

            String sqlUpdateTable = "update SEAT set available = true"
                    + " where SEAT_ID = " + seatid;
            statement.executeUpdate(sqlUpdateTable);

        } catch (SQLException ex) {
            System.out.println("You encountered an exception. Please try again");
            System.out.println(ex);
        }
    }
    
    public void addSeatTable(int showTimeid) throws SQLException{
        
        DatabaseMetaData dbm = this.dbManager.conn.getMetaData();
        Statement statement = dbManager.getConnection().createStatement();
        for(int y = 1; y < 5; y++){        
            for(int x = 1; x < 5; x++){
                String sqlInsert = "insert into Seat (Column1, Row, Available, Showtime_id) values( "
                    + x + ", " + y + ", true, " + showTimeid + ")";
                statement.executeUpdate(sqlInsert); 
            }
        }
    }
    
    //Function that change seatid to seatNumber(From 1,2,3... to A1,A2,A3)
    public String getSeatNumber(int seatid){
        ResultSet rs = null;
        int column = 0;
        int row = 0;
        String result = "";
        try {
            System.out.println(" getting query....");
            System.out.println(seatid);
            String sqlSelect = "select * from SEAT where SEAT_ID = ?";
            PreparedStatement stmp;
            Connection conn = dbManager.getConnection();
            stmp = conn.prepareStatement(sqlSelect, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmp.setInt(1, seatid);
            rs = stmp.executeQuery();
            rs.beforeFirst();
            while (rs.next()) {
                column = rs.getInt("Column1");
                row = rs.getInt("Row"); 
            } 
            String resultRow = "";
            switch(row){
                case 1:
                    resultRow = "A";
                    break;
                case 2:
                    resultRow = "B";
                    break;
                case 3:
                    resultRow = "C";
                    break;
                case 4:
                    resultRow = "D";
                    break;
            }
            result += resultRow + String.valueOf(column);
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return result;
    }
        
    public String getUserNameByUserid(String userid){
        String userName = "";
        ResultSet rs = null;
        try {
            System.out.println(" getting query....");
            String sqlSelect = "select * from CUSTOMER where USER_ID = ?";
            PreparedStatement stmp;
            Connection conn = dbManager.getConnection();
            stmp = conn.prepareStatement(sqlSelect, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmp.setString(1, userid);
            rs = stmp.executeQuery();
            rs.beforeFirst();
            while (rs.next()) {
                userName = rs.getString(2);
                System.out.println(userName);
            }   
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return userName;
    }
}
