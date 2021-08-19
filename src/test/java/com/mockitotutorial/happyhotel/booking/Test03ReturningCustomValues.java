package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

public class Test03ReturningCustomValues {

    private BookingService bookingService;
    private PaymentService paymentServiceMock;
    private RoomService roomServiceMock;
    private BookingDAO bookingDAOMock;
    private MailSender mailSenderMock;

    @BeforeEach
    void setup(){
        this.paymentServiceMock = mock(PaymentService.class);
        this.roomServiceMock = mock(RoomService.class);
        this.bookingDAOMock = mock(BookingDAO.class);
        this.mailSenderMock = mock(MailSender.class);
        this.bookingService = new BookingService(paymentServiceMock, roomServiceMock, bookingDAOMock, mailSenderMock);


    }

    @Test
    void should_CountAvailablePlaces_When_OneRoomAvailable(){
        //given
        when(this.roomServiceMock.getAvailableRooms())
                .thenReturn(Collections.singletonList(new Room("Room 1", 5)));
        int expected = 5;
        //when
        int actual = bookingService.getAvailablePlaceCount();
        //then
        assertEquals(expected, actual);
    }

    @Test
    void should_CountAvailablePlaces_When_MultipleRoomsAvailable(){
        //given
        List<Room> rooms = Arrays.asList(new Room("Room 1", 2), new Room("Room 2", 5));
        when(this.roomServiceMock.getAvailableRooms()).thenReturn(rooms);
        int expected = 7;
        //when
        int actual = bookingService.getAvailablePlaceCount();
        //then
        assertEquals(expected, actual);
    }

}
