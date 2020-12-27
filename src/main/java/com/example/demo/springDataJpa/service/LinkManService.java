package com.example.demo.springDataJpa.service;

import com.example.demo.springDataJpa.entity.LinkMan;
import sun.awt.image.ImageWatched;

public interface LinkManService {
    void save(LinkMan linkMan);
    LinkMan getOne(long id);
}
