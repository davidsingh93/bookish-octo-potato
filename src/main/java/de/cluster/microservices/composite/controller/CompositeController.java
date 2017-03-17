package de.cluster.microservices.composite.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.cluster.microservices.composite.model.CompositeEvent;
import de.cluster.microservices.composite.model.Event;
//import de.cluster.microservices.composite.model.Location;
//import de.cluster.microservices.composite.model.Ticket;
import de.cluster.microservices.composite.service.CompositeIntegration;
import de.cluster.microservices.composite.service.Util;

@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@RestController
public class CompositeController {

	private static final Logger LOG = LoggerFactory.getLogger(CompositeController.class);

    @Autowired
    CompositeIntegration integration;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public ResponseEntity<CompositeEvent[]> getCompositeEvents() {
    	return integration.getCompositeEvents();
    }
    
    @RequestMapping(value = "/events/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<CompositeEvent[]> getCompositeEventsByName(@PathVariable String name) {
    	return integration.getCompositeEventsByName(name);
    }
    
    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public ResponseEntity<String> createEvent(@RequestBody Event e) {
    	LOG.info("CREATE EVENT CONTROLLER");
    	integration.createEvent(e);
    	return new ResponseEntity<>("{}",HttpStatus.OK);
    }

    @RequestMapping(value = "/events", method = RequestMethod.PUT)
    public ResponseEntity<CompositeEvent[]> modifyCompositeEvent(@RequestBody CompositeEvent compositeEvent) {
    	return null;
    }
    
}