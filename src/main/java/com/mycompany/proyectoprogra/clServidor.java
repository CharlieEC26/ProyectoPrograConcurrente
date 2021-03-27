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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class clServidor {

    public static void main(String[] args) {
        final int PUERTO = 5000;
        byte[] buffer = new byte[1024];
        try {
            System.out.println("-----Iniciando servidor del UDP-----");
            DatagramSocket sUDP = new DatagramSocket(PUERTO);
            while (true) {
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
                sUDP.receive(peticion);
                System.out.println("-----El servidor recibió la información del lado del cliente-----");
                String mensaje = new String(peticion.getData());
                System.out.println("-----Mensaje recibido por el servidor, mostrando mensaje: \n" + mensaje);
                int puertoCliente = peticion.getPort();
                InetAddress direccion = peticion.getAddress();
                System.out.printf("-----Direccion del cliente %s el puerto del %d"
                        + " \n" + " Bienvenidos al restaurante: Do pharabal, do chuid cách", direccion.toString(),
                         puertoCliente);
                mensaje = String.format("Procesando debido registro: %s\n"
                        , direccion.toString());
                buffer = mensaje.getBytes();
                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
                sUDP.send(respuesta);
                System.out.println("-----Paquete enviado-----");
            }
        } catch (SocketException ex) {
            Logger.getLogger(clServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(clServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
