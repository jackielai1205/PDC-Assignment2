/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jackie;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author jacki
 */
public class MovieDetailPageView extends View{

    /**
     * Creates new form MovieDetailPageView
     */
    public MovieDetailPageView(View parent) {
        super(parent);
        initComponents();
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

        movieName = new javax.swing.JLabel();
        movieLength = new javax.swing.JLabel();
        casting = new javax.swing.JLabel();
        showTime = new javax.swing.JButton();
        back = new javax.swing.JButton();
        description = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        movieName.setText("jLabel1");
        movieName.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        movieLength.setText("jLabel2");
        movieLength.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        casting.setText("jLabel3");
        casting.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        showTime.setText("Enter ShowTime Page");
        showTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTimeActionPerformed(evt);
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        description.setText("jLabel1");
        description.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("jLabel1");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(showTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(description, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                    .addComponent(movieLength, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(casting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(movieName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back))
            .addGroup(layout.createSequentialGroup()
                .addComponent(movieName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(movieLength, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(casting, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showTimeActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed

    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel casting;
    private javax.swing.JLabel description;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel movieLength;
    private javax.swing.JLabel movieName;
    private javax.swing.JButton showTime;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void update(Observable o, Object arg) {
        showMovieDetail(((MovieDetailPageModel)o));
    }
    
    public void showMovieDetail(MovieDetailPageModel model){
        String allCasting = "";
        for(String casting: model.movie.getCastings()){
            allCasting+=casting+" ";
        }
        this.casting.setText("<html>Casting:<br>"+allCasting+"</html>");
        this.movieLength.setText("<html>Length:<br>"+String.valueOf(model.movie.getLength())+"</html>");
        this.description.setText( "<html><p style=\"width:350px\">Description:<br>"+model.movie.getDescription()+"</p></html>");
        this.movieName.setText("<html>Movie name:<br>" + model.movie.getName()+ "</html>");
        String imagePath = "/com/jackie/"+model.movie.getName().replaceAll("\\s","")+".jpg";
        this.jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagePath))); // NOI18N
        this.showTime.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AllShowTimePageView allShowTimePageView = new AllShowTimePageView(MovieDetailPageView.this);
                AllShowTimePageModel allShowTimePageModel = new AllShowTimePageModel(model.movie);
                AllShowTimePageController allShowTimePageController =  new AllShowTimePageController(allShowTimePageView, allShowTimePageModel);
                MovieDetailPageView.this.setEnabled(false);
            }
        });
    }
    
    public void addController(MovieDetailPageController controller){
        back.addActionListener(controller);
    }
}
