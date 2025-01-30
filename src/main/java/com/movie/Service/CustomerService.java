package com.movie.Service;

import com.movie.entity.Address;
import com.movie.entity.City;
import com.movie.entity.Country;
import com.movie.entity.Customer;
import com.movie.repository.AddressRepository;
import com.movie.repository.CityRepository;
import com.movie.repository.CountryRepository;
import com.movie.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public void createCustomer(Customer customer, Address address, City city, Country country) {
        // Save dependent entities
        countryRepository.save(country);
        cityRepository.save(city);
        addressRepository.save(address);

        // Set the address for the customer
        customer.setAddress(address);
        customer.setCreateDate(new Timestamp(System.currentTimeMillis()));
        customer.setLastUpdate(new Timestamp(System.currentTimeMillis()));

        // Save the customer
        customerRepository.save(customer);
    }
}