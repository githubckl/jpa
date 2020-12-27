package com.example.demo.springDataJpa.service.impl;

import com.example.demo.springDataJpa.dao.LinkManRepository;
import com.example.demo.springDataJpa.entity.LinkMan;
import com.example.demo.springDataJpa.service.LinkManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkManImpl implements LinkManService {
    @Autowired
    private  LinkManRepository linkManRepository;
    @Override
    public void save(LinkMan linkMan) {
        linkManRepository.save(linkMan);
    }

    @Override
    public LinkMan getOne(long id) {
        return linkManRepository.getOne(id);
    }
}
