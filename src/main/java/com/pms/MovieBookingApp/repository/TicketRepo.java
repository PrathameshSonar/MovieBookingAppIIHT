package com.pms.MovieBookingApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pms.MovieBookingApp.model.Ticket;

public interface TicketRepo extends MongoRepository<Ticket, Integer> {

}
