/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoprogra;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class clCliente {

    public static void main(String[] args) {
        final int puertoServidor = 5000;
        byte[] buffer = new byte[1024];
        try {
            InetAddress direccionServidor = InetAddress.getByName("localhost");
            DatagramSocket sUDP = new DatagramSocket();
            System.out.println("-----Entrando al cliente-----");
            String mensaje = "-----este es el cliente, restaurante ejemplo-----";
            buffer = mensaje.getBytes();
            DatagramPacket envio = new DatagramPacket(buffer, buffer.length, 
                    direccionServidor, puertoServidor);
            System.out.println("-----Enviando orden al servidor-----");
            sUDP.send(envio);
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
            System.out.println("-----Se recibió la orden del restaurante");
            sUDP.receive(respuesta);
            mensaje = new String(respuesta.getData());
            sUDP.close();
            System.out.println("");
        } catch (UnknownHostException ex) {
            Logger.getLogger(clCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(clCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(clCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
