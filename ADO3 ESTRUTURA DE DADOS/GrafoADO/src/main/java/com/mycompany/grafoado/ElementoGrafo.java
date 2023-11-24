/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafoado;

/**
 *
 * @author alexs
 */
abstract class ElementoGrafo {

    private static int contadorId = 0;
    protected int id;

    public ElementoGrafo() {
        this.id = contadorId++;
    }

    public int getId() {
        return id;
    }
}
