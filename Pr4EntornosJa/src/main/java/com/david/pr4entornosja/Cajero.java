/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.david.pr4entornosja;

import java.util.ArrayList;

/**
 *
 * @author loren
 */
public class Cajero {

    /**
     * Nombre del cajero
     */
    String n;
    /**
     * Contador de tickets
     */
    int c;
    /**
     * Total de dinero recaudado
     */
    double t;
    /**
     * Lista de productos que aparecen en el ticket
     */
    ArrayList<Producto> ps;
    
    /**
     * Constructor de la clase Cajero
     * Inicializa los contadores a 0 y crea la lista de productos
     * @param n nombre del cajero
     */
    
    public Cajero(String n) {
        this.n = n;
        this.c = 0;
        this.t = 0;
        this.ps = new ArrayList<>();
    }
    
    /**
     * Añade un producto a la lista del ticket
     * @param p Objeto producto que se va a añadir
     */
    public void ANADIRPRODUCTO(Producto p) {
        ps.add(p);
    }
    
    /**
     * Elimina un producto de la lista del ticket
     * @param p Objeto producto a eliminar del ticket
     */
    public void eliminarProDUCTO(Producto p) {
        ps.remove(p);
    }
    
    /**
     * Procesa el cobro de todos los productos que aparecen en la lista
     * Calcula el total, el IVA e imprime el ticket
     * Actualiza los contadores
     * Vacia la lista para el siguiente cliente
     */
    public void cobrar() {
        double subt = 0;
        for (Producto p : ps) {
            subt = subt + p.calcularImporte();
        }
        double iva = subt * 0.21;
        double tot = subt + iva;

        System.out.println("===== TICKET =====");
        System.out.println("Cajero: " + n);
        for (Producto p : ps) {
            System.out.println(p.getNombre() + " x" + p.getCantidad()
                    + " = " + String.format("%.2f", p.calcularImporte()) + " EUR");
        }
        System.out.println("------------------");
        System.out.println("Subtotal: " + String.format("%.2f", subt) + " EUR");
        System.out.println("IVA (21%): " + String.format("%.2f", iva) + " EUR");
        System.out.println("TOTAL: " + String.format("%.2f", tot) + " EUR");
        System.out.println("==================");

        c = c + 1;
        t = t + tot;
        ps.clear();
    }

    /**
     * Realiza el cierre de caja del dia
     * Calcula el IVA total recaudado y el total facturado
     * Muestra el numero de tickets del dia
     */
    public void cierreCaja() {
        double ivaRec = t - (t / (1 + 0.21));

        System.out.println("===== CIERRE DE CAJA =====");
        System.out.println("Cajero: " + n);
        System.out.println("--------------------------");
        System.out.println("Tickets emitidos: " + c);
        System.out.println("Total facturado:  " + String.format("%.2f", t) + " EUR");
        System.out.println("IVA recaudado:    " + String.format("%.2f", ivaRec) + " EUR");
        System.out.println("==========================");
    }
    
    /**
     * Comprueba si el ticket actual esta vacio
     * @return devuelve True si no existe el ticket y false si existe
     */
    public boolean ticketVacio() {
        return ps.isEmpty();
    }

    /**
     * Devuelve el total de tickets del dia
     * @return El numero de tickets hasta el momento
     */
    public int getTicketsEmitidos() {
        return c;
    }

    /**
     * Devuelve el total de dinero recaudado en el dia
     * @return importe total facturado
     */
    public double getTotalDia() {
        return t;
    }
}
