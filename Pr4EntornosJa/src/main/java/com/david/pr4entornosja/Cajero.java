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

    private String name;
    private int ticketsEmitidos;
    private double totalDia;
    private ArrayList<Producto> productos;

    public Cajero(String n) {
        this.name = n;
        this.ticketsEmitidos = 0;
        this.totalDia = 0;
        this.productos = new ArrayList<>();
    }

    public void ANADIRPRODUCTO(Producto p) {
        getProductos().add(p);
    }

    public void eliminarProDUCTO(Producto p) {
        getProductos().remove(p);
    }

    public void cobrar() {
        double subt = 0;
        subt = calcularPrecio(subt);
        double iva = subt * constante;
        double tot = subt + iva;

        souts(subt, iva, tot);

        setTicketsEmitidos(getTicketsEmitidos() + 1);
        setTotalDia(getTotalDia() + tot);
        getProductos().clear();
    }

    private double calcularPrecio(double subt) {
        for (Producto p : getProductos()) {
            subt = subt + p.calcularImporte();
        }
        return subt;
    }

    private void souts(double subtotal, double iva, double total) {
        System.out.println("===== TICKET =====");
        System.out.println("Cajero: " + getName());
        forech();
        System.out.println("------------------");
        System.out.println("Subtotal: " + String.format("%.2f", subtotal) + " EUR");
        System.out.println("IVA (21%): " + String.format("%.2f", iva) + " EUR");
        System.out.println("TOTAL: " + String.format("%.2f", total) + " EUR");
        System.out.println("==================");
    }

    private void forech() {
        for (Producto p : getProductos()) {
            System.out.println(p.getNombre() + " x" + p.getCantidad()
                    + " = " + String.format("%.2f", p.calcularImporte()) + " EUR");
        }
    }
    private static final double constante = 0.21;

    public void cierreCaja() {
        double ivaRec = getTotalDia() - (getTotalDia() / (1 + constante));

        System.out.println("===== CIERRE DE CAJA =====");
        System.out.println("Cajero: " + getName());
        System.out.println("--------------------------");
        System.out.println("Tickets emitidos: " + getTicketsEmitidos());
        System.out.println("Total facturado:  " + String.format("%.2f", getTotalDia()) + " EUR");
        System.out.println("IVA recaudado:    " + String.format("%.2f", ivaRec) + " EUR");
        System.out.println("==========================");
    }

    public boolean ticketVacio() {
        return getProductos().isEmpty();
    }

    public int getTicketsEmitidos() {
        return ticketsEmitidos;
    }

    public double getTotalDia() {
        return totalDia;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param ticketsEmitidos the ticketsEmitidos to set
     */
    public void setTicketsEmitidos(int ticketsEmitidos) {
        this.ticketsEmitidos = ticketsEmitidos;
    }

    /**
     * @param totalDia the totalDia to set
     */
    public void setTotalDia(double totalDia) {
        this.totalDia = totalDia;
    }

    /**
     * @return the productos
     */
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
}
