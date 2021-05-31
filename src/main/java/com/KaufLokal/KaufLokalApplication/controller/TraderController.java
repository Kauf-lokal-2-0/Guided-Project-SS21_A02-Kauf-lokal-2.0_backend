package com.KaufLokal.KaufLokalApplication.controller;


import com.KaufLokal.KaufLokalApplication.model.Trader;
import com.KaufLokal.KaufLokalApplication.repository.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TraderController {

    @Autowired
    private TraderRepository traderRepository;

    @GetMapping("/traders")
    public List<Trader> getAllTraders() {

        return traderRepository.findAll();
    }
}
