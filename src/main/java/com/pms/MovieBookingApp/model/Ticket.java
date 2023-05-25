package com.pms.MovieBookingApp.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "ticket_details")
public class Ticket {
	
	@Id
	private String ticketId;
	private String movieName;
	private String theaterName;
	private int noOfTickets;
	private List<String> seats;

}
