package simpleWebRest7.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import simpleWebRest7.data.model.CustomApplication;
import simpleWebRest7.repositories.CustomApplicationRepository;
import simpleWebRest7.service.CustomApplicationService;

public class CustomApplicationServiceImpl  implements CustomApplicationService {
    private CustomApplicationRepository streamRepository;

    @Inject
    public CustomApplicationServiceImpl(CustomApplicationRepository streamRepository) {
        this.streamRepository = streamRepository;
    }

    public Optional<CustomApplication> findById(int uid) {
        return streamRepository.findById(uid);
    }


  
    public List<CustomApplication> findAll() {
        return streamRepository.findAll();
    }
}

