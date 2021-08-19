package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class Test08Spies {

    private BookingService bookingService;
    private PaymentService paymentServiceMock;
    private RoomService roomServiceMock;
    private BookingDAO bookingDAOSpy;
    private MailSender mailSenderMock;

    @BeforeEach
    void setup(){
        this.paymentServiceMock = mock(PaymentService.class);
        this.roomServiceMock = mock(RoomService.class);
        this.bookingDAOSpy = spy(BookingDAO.class);
        this.mailSenderMock = mock(MailSender.class);
        this.bookingService = new BookingService(paymentServiceMock, roomServiceMock, bookingDAOSpy, mailSenderMock);
    }

    //mock = dummy object with no real logic
    //spy = partial mock - real object with real logic that we can modify

    @Test
    void should_MakeBooking_When_InputOK(){
        //given
        BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2020, 01, 01)
                , LocalDate.of(2020, 01, 05), 2, true);

        //when
        String bookingId = bookingService.makeBooking(bookingRequest);

        //then
        verify(bookingDAOSpy).save(bookingRequest);
        System.out.println("bookingId = " + bookingId);

    }

    @Test
    void should_CancelBooking_When_InputOK(){
        //given
        BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2020, 01, 01)
                , LocalDate.of(2020, 01, 05), 2, true);
        bookingRequest.setRoomId("1.3");
        String bookingId = "1";

        //when
        doReturn(bookingRequest).when(bookingDAOSpy).get(bookingId); //change behaviour for spy
        bookingService.cancelBooking(bookingId);

        //then

    }




}
