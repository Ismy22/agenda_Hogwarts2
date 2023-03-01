/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agenda.agenda_v1;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Ismael
 */
public class lanzarGifHilo implements Runnable {

    public void abrirGif(String casa, int tam1, int tam2) {
        try {

            Window win = App.getScene().getWindow();
            win.setWidth(tam1);
            win.setHeight(tam2);
            App.setRoot(casa);

        } catch (Exception e) {
        }
    }

    @Override
    public void run() {

        try {
            int tam1, tam2;
            tam1 = 913;
            tam2 = 511;
            String casa = "panelGifCasas";
            abrirGif(casa, tam1, tam2);
            wait(7000);
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } catch (InterruptedException ex) {
            Logger.getLogger(lanzarGifHilo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
