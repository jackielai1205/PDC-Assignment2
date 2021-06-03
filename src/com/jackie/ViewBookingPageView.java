/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jackie;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
 *
 * @author waltersiu
 */
public class ViewBookingPageView extends Page{
    private ViewBookingPageView viewBookingView = this;

    /**
     * Creates new form ViewBookingPageView
     */
    public ViewBookingPageView(Page parent) {
        super(parent);
        this.setVisible(true);
        initComponents();
        parent.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bookingListPanel = new javax.swing.JScrollPane();
        list = new javax.swing.JPanel();
        message = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Movie Booking System");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout listLayout = new javax.swing.GroupLayout(list);
        list.setLayout(listLayout);
        listLayout.setHorizontalGroup(
            listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        listLayout.setVerticalGroup(
            listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );

        bookingListPanel.setViewportView(list);

        getContentPane().add(bookingListPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 40, 400, -1));

        message.setFont(new java.awt.Font("新細明體", 1, 18)); // NOI18N
        message.setText("Your Booking:");
        getContentPane().add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, 30));

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 264, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.back();
    }//GEN-LAST:event_backButtonActionPerformed
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewBookingPageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBookingPageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBookingPageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBookingPageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBookingPageView(null).setVisible(true);
            }
        });
    }

    @Override
    public void update(Observable model, Object arg) {
        // get result from model and add Jpanel
        ViewBookingPageModel viewBookingModel = (ViewBookingPageModel)model;
        this.list.setLayout(new GridLayout(viewBookingModel.getCurrentUserBooking().size(), 1));
        if(viewBookingModel.getCurrentUserBooking() != null){
            for(int index = 0; index < viewBookingModel.getCurrentUserBooking().size(); index++){
                BookingListPanel panel = new BookingListPanel();
                panel.movieName.setText(viewBookingModel.getCurrentMoiveName().get(index) + " " + viewBookingModel.getCurrentUserShowTime().get(index).getDate());
                final Booking currentBooking = viewBookingModel.getCurrentUserBooking().get(index);
                panel.viewButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent al){
                        BookingDetailPageModel bookingDetailModel = new BookingDetailPageModel(viewBookingModel.dbm, currentBooking);
                        BookingDetailPageView bookingDetailView = new BookingDetailPageView(viewBookingView);
                        BookingDetailPageController bookingDetailController = new BookingDetailPageController(bookingDetailModel, bookingDetailView);
                    }
                });
                this.list.add(panel);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane bookingListPanel;
    private javax.swing.JPanel list;
    private javax.swing.JLabel message;
    // End of variables declaration//GEN-END:variables
}
