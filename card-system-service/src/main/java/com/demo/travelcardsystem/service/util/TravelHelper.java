package com.demo.travelcardsystem.service.util;

import com.demo.travelcardsystem.constant.TransportType;
import com.demo.travelcardsystem.entity.TravelCard;
import com.demo.travelcardsystem.model.request.SwipeRequest;
import com.demo.travelcardsystem.repository.InMemoryCardTransactionRepository;
import org.springframework.stereotype.Component;

@Component
public class TravelHelper {

    private final InMemoryCardTransactionRepository inMemoryCardTransactionRepository;

    public TravelHelper(InMemoryCardTransactionRepository inMemoryCardTransactionRepository) {
        this.inMemoryCardTransactionRepository = inMemoryCardTransactionRepository;
    }

    public SwipeRequest prepareSwipeRequest(String cardNumber, String stationName, TransportType transportType) {
        SwipeRequest swipeRequest = new SwipeRequest();
        swipeRequest.setCardNumber(cardNumber);
        swipeRequest.setStationName(stationName);
        swipeRequest.setTransportType(transportType);

        return swipeRequest;
    }


    public TravelCard directUserRegistration(String cardNumber, double amount) {
        TravelCard travelCard = new TravelCard();
        travelCard.setCardNumber(cardNumber);
        travelCard.setBalance(amount);

        return inMemoryCardTransactionRepository.registerNewCard(travelCard);
    }
}
