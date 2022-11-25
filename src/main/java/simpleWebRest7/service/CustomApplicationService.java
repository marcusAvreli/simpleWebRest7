package simpleWebRest7.service;

import java.util.List;
import java.util.Optional;

import simpleWebRest7.data.model.CustomApplication;

public interface CustomApplicationService {

    Optional<CustomApplication> findById(int uid);


    List<CustomApplication> findAll();
}

