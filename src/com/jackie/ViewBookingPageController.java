/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jackie;

/**
 *
 * @author waltersiu
 */
public class ViewBookingPageController {
    ViewBookingPageModel viewBookingModel;
    ViewBookingPageView viewBookingView;
    
    public ViewBookingPageController(ViewBookingPageModel viewBookingModel, ViewBookingPageView viewBookingView){
        this.viewBookingModel = viewBookingModel;
        this.viewBookingView = viewBookingView;
        viewBookingModel.addObserver(viewBookingView);
        viewBookingView.update(viewBookingModel, null);
    }
    
}
