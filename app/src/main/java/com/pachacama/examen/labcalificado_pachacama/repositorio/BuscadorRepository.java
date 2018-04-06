package com.pachacama.examen.labcalificado_pachacama.repositorio;

import java.util.ArrayList;
import java.util.List;
 import com.pachacama.examen.labcalificado_pachacama.modelo.Buscador;

public class BuscadorRepository {

    private static List<Buscador> buscadores = new ArrayList<>();

    static {
        buscadores.add(new Buscador( 100, "Jovenes", "Tecsup", "Santa Anita", "7532649", "tecsup.edu.pe", "http://tecsup.com","img","Intituto Privado"));
        buscadores.add(new Buscador( 200, "Comida", "KFC", "Lima", "8524695", "kfc@gmail.com", "http://kfc.com","img","Restaurant de Comida rápida "));
        buscadores.add(new Buscador( 300, "Deporte", "Cantolao", "Chorrillos", "2583451", "cantolao@gmail.com", "hhtp://cantolao.com","img","Academia de futbol"));
        buscadores.add(new Buscador( 400, "Maquillaje", "Shepora", "Lima", "2034867", "shepora.@gmail.com", "hhhtp://sheporaperu.com","img","Tienda de Maquillaje"));
        buscadores.add(new Buscador( 500, "Television", "Samsung", "Miraflores", "7534621", "samsung@gmail.com", "http://samsung","img","Tienda de televisores"));
        buscadores.add(new Buscador( 600, "Mascotas", "PanchoCavero", "Barranco", "85213647", "caveterinaria@gmail.com", "http://caveropancho.com","img","Veterinaria"));
        buscadores.add(new Buscador( 700, "Radio", "OndaCero", "Surco", "7534201", "ondacero@gmail.com", "http://ondacero.com","img","Radio juvenil local"));
        buscadores.add(new Buscador( 800, "Educacion", "I. E. Santa Rosa", "Chorrillos", "1234567", "santarosa@gmail.com", "http://santarosa.com","img","Colegio Inicial-Primaria"));
        buscadores.add(new Buscador( 900, "Ninhos", "ConeyPark", "Surco", "7531598", "conypark@gmail.com", "http://coney.com","img","Lugar de diversiones"));
        buscadores.add(new Buscador( 110, "Madres", "Tottus", "SJM", "2648951", "tottus@gmail.com", "http://tottus.com","img","Supermercado"));

    }

    public static List<Buscador> getList(){
        return buscadores;
    }

}