package com.machinecoding.ticketbooking.controller;

import com.machinecoding.ticketbooking.service.BookingService;
import com.machinecoding.ticketbooking.service.PaymentService;
import lombok.NonNull;

public class PaymentController {
    private final PaymentService paymentService;
    private final BookingService bookingService;

    public PaymentController(PaymentService paymentsService, BookingService bookingService) {
        this.paymentService = paymentsService;
        this.bookingService = bookingService;
    }

    public void paymentFailed(@NonNull final String bookingId, @NonNull final String user) {
        paymentService.processPaymentFailed(bookingService.getBooking(bookingId), user);
    }

    public void paymentSuccess(@NonNull final  String bookingId, @NonNull final String user) {
        bookingService.confirmBooking(bookingService.getBooking(bookingId), user);
    }
}
