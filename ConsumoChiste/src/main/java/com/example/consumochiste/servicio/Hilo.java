package com.example.consumochiste.servicio;

import com.example.consumochiste.model.Chiste;
import org.json.*;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.core.Response;


public class Hilo extends Thread {
    HiloLogica hlogica;

    Hilo(HiloLogica hlogica) {
        this.hlogica = hlogica;
    }

    public void cosumeApi() {
        String url = "https://api.chucknorris.io/jokes/random";
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(url);
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        JSONObject jsonpObject = new JSONObject(value);
        Chiste ch = new Chiste();
        ch.setId(jsonpObject.getString("id"));
        ch.setUrl(jsonpObject.getString("url"));
        ch.setValor(jsonpObject.getString("value"));
        hlogica.addChiste(ch);
        response.close();
    }

    public void run() {
        cosumeApi();
    }
}
