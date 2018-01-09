/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Juniel
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.gov.pi.ati.agendacultural.acessoApp.CategoriaEventoResource.class);
        resources.add(br.gov.pi.ati.agendacultural.acessoApp.EventoResource.class);
        resources.add(br.gov.pi.ati.agendacultural.acessoApp.PortfolioResource.class);
        resources.add(br.gov.pi.ati.agendacultural.acessoApp.TipoLocalResource.class);
    }
    
}
