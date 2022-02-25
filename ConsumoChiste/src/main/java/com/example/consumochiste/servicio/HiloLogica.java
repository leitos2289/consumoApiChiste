package com.example.consumochiste.servicio;

import com.example.consumochiste.model.Chiste;

import java.util.HashSet;
import java.util.concurrent.*;

public class HiloLogica {
    HashSet<Chiste> listaFinal = new HashSet<>();

    public void addChiste(Chiste ch) {

        if(!listaFinal.contains(ch) && listaFinal.size()<15){
            listaFinal.add(ch);

        }
    }
    public HashSet<Chiste> crearHilos(){

        ExecutorService executorService;
        while(listaFinal.size()<15){
            executorService = Executors.newFixedThreadPool(5);
            for(int i=0;i<15;i++){
                executorService.execute(new Hilo(this));
            }
            executorService.shutdown();
            do{}while(!executorService.isTerminated() && listaFinal.size()<15);
        }
        return listaFinal;
    }
}
