package com.jackie;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jacki
 */
public class MoviePageView extends View{

    /**
     * Creates new form MoviePage
     */
    public MoviePageView(View parent) {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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

        jScrollPane1.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(movieList)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movieList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel movieList;
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
            MovieListItem movieListItem = new MovieListItem(movie.getName());
            panel.add(movieListItem);
            movieListItem.getjButton1().addActionListener(
                    new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            MovieDetailPageModel movieDetailPageModel = new MovieDetailPageModel(movie);
                            MovieDetailPageView movieDetailPageView = new MovieDetailPageView(MoviePageView.this);
                            MovieDetailPageController movieDetailPageController = new MovieDetailPageController(movieDetailPageView, movieDetailPageModel);
                            movieDetailPageView.addController(movieDetailPageController);
                            MoviePageView.this.setEnabled(false);  
                        };
                    }
            );
        }
    }
    
    public void addController(MoviePageController controller){
       
    }

}
