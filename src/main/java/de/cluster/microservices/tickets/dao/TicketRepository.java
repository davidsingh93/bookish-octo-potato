package de.cluster.microservices.tickets.dao;

import de.cluster.microservices.tickets.model.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, String> {
	
}
