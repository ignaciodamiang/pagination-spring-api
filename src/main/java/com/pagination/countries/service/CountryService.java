package com.pagination.countries.service;

import com.pagination.countries.entity.Country;
import com.pagination.countries.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public Page<Country> pages(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }
}
