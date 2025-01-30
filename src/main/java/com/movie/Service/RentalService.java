package com.movie.Service;

import com.movie.entity.*;
import com.movie.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Transactional
    public void returnRentedMovie(Integer rentalId) {
        // Fetch the rental record
        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new RuntimeException("Rental not found"));

        // Check if the movie has already been returned
        if (rental.getReturnDate() != null) {
            throw new RuntimeException("Movie has already been returned");
        }

        // Set the return date and update the rental record
        rental.setReturnDate(new Timestamp(System.currentTimeMillis()));
        rental.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        rentalRepository.save(rental);
    }

    @Transactional
    public void rentMovie(Integer inventoryId, Integer customerId, Integer staffId, BigDecimal amount) {
        // Fetch the inventory record
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));

        // Check if the movie is available for rent
        Rental lastRental = rentalRepository.findTopByInventoryOrderByRentalDateDesc(inventory);
        if (lastRental != null && lastRental.getReturnDate() == null) {
            throw new RuntimeException("Movie is not available for rent");
        }

        // Fetch the customer and staff records
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Staff staff = staffRepository.findById(staffId)
                .orElseThrow(() -> new RuntimeException("Staff not found"));

        // Create a new rental record
        Rental rental = new Rental();
        rental.setInventory(inventory);
        rental.setCustomer(customer);
        rental.setStaff(staff);
        rental.setRentalDate(new Timestamp(System.currentTimeMillis()));
        rental.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        rentalRepository.save(rental);

        // Create a new payment record
        Payment payment = new Payment();
        payment.setCustomer(customer);
        payment.setStaff(staff);
        payment.setRental(rental);
        payment.setAmount(amount);
        payment.setPaymentDate(new Timestamp(System.currentTimeMillis()));
        payment.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        paymentRepository.save(payment);
    }
}