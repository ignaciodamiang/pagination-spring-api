package com.pagination.countries.controller;

import com.pagination.countries.entity.Country;
import com.pagination.countries.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/countries")
    public ResponseEntity<Page<Country>> pages(
            @RequestParam(defaultValue= "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String order,
            @RequestParam(defaultValue = "true") boolean asc
    ){

        Page<Country> countries = countryService.pages(PageRequest.of(
                page, size, Sort.by(order)));
        if(!asc)
            countries = countryService.pages(PageRequest.of(
                    page, size, Sort.by(order).descending()));
            return new ResponseEntity<Page<Country>>(countries, HttpStatus.OK);
    }
}
