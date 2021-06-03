package com.jackie;


import java.util.HashMap;
import java.util.Observable;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jacki
 */
public class MoviePageView extends Page{

    /**
     * Creates new form MoviePage
     */
    public MoviePageView(Page parent) {
        super(parent);
        initComponents();
        boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
        this.setVisible(true);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        movieList = new javax.swing.JLabel();
        moviePanel = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Movie Booking System");
        setResizable(false);

        movieList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        movieList.setText("Movie List");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        moviePanel.setViewportView(panel);

        back.setText("Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moviePanel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(movieList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movieList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(moviePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel movieList;
    private javax.swing.JScrollPane moviePanel;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

    private javax.swing.BoxLayout boxLayout;
    
    
    @Override
    public void update(Observable o, Object arg) {
        printMovie((MoviePageModel)o);
    }
    
    public void printMovie(MoviePageModel model){
        HashMap<Integer, Movie> movies = model.getMovies();
        
        for(Movie movie: movies.values()){
            MoviePageController controller = new MoviePageController(movie);
            MovieListItem movieListItem = new MovieListItem(controller.getModel(),controller.getView(), movie.getName());
            panel.add(movieListItem);
            movieListItem.addController(controller);
        }
    }

    public JButton getBack() {
        return back;
    }

    public void setBack(JButton back) {
        this.back = back;
    }

    public JLabel getMovieList() {
        return movieList;
    }

    public void setMovieList(JLabel movieList) {
        this.movieList = movieList;
    }

    public JScrollPane getMoviePanel() {
        return moviePanel;
    }

    public void setMoviePanel(JScrollPane moviePanel) {
        this.moviePanel = moviePanel;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public BoxLayout getBoxLayout() {
        return boxLayout;
    }

    public void setBoxLayout(BoxLayout boxLayout) {
        this.boxLayout = boxLayout;
    }
    
    
}
