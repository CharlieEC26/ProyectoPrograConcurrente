/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoprogra;

import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class clOps {

    int personasMesa = 0;
    String[] nombres = {"ccotoa443", "ulacit.ed.cr", "fio332Ulacit"};
    String[] contrass = {"1111", "piniata123", "Dpcas89d2"};

    public boolean inicioSesion(String nombre, String contrasenia) {
        boolean bandera = false;
        for(int c = 0; c >= nombres.length; c++){
            if((nombre == null ? nombres[c] == null : nombre.equals(nombres[c])) && contrasenia == contrass[c]){
                bandera = true;
            }
            else{
                bandera = false;
            }
        }
        return bandera;
    }

    public void menusMesas(int numMesa) {
        if(numMesa == 1){
            JOptionPane.showMessageDialog(null, "El menu 1: El sabroso, pescados"
                    + "y mariscos acompañados con perejil pescado y arroz integral");
        }
        if(numMesa == 2){
            JOptionPane.showMessageDialog(null, "El menu 2: La hogaza, pimientos"
                    + "rellenos en salmon yt cangrejo, acompañado de nuestra"
                    + " salsa agridulce de coco con carne picada ");
        }
        if(numMesa == 3){
            JOptionPane.showMessageDialog(null, "El menu 3: AlbondiBon"
                    + "nuestras ricas albondigas veganaz con garbanzos "
                    + "brocoli vegetarianas con nuestra salsa de carne en "
                    + "salsa de cebolla, acompañado con patatas fritas");
        }
    }

    public boolean reservacionesMesas(int cantPersonas) {
        if (cantPersonas == 2 || cantPersonas == 4 || cantPersonas == 6
                || cantPersonas == 8) {
            personasMesa += cantPersonas;
            return true;
        } else {
            return false;
        }
    }
    //no disponible
    public void cierreDeCajas() {  
        
    }
}
