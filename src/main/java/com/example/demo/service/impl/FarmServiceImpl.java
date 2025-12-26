package com.example.demo;

public class FarmServiceImpl
        extends com.example.demo.service.impl.FarmServiceImpl {

    public FarmServiceImpl(
            com.example.demo.repository.FarmRepository farmRepository,
            com.example.demo.repository.UserRepository userRepository
    ) {
        super(farmRepository, userRepository);
    }
}
