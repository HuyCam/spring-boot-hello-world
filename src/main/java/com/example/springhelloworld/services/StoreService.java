package com.example.springhelloworld.services;

import com.example.springhelloworld.entity.Address;
import com.example.springhelloworld.entity.Store;
import com.example.springhelloworld.repository.AddressRepository;
import com.example.springhelloworld.repository.StoreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class StoreService {
    @Autowired
    StoreRepository storeRepository;

    @Autowired
    AddressRepository addressRepository;

    public Store createStore(String name, boolean isTest, Address address) throws Exception {
        if (isTest) {
            throw new Exception("Test exception");
        } else {
            Store store = new Store();
            address = addressRepository.save(address);
            store.setAddress(address);
            store.setName(name);
            return store;
        }
    }


    public boolean storeOperation() throws Exception {
        Address address = new Address();
        address.setAddress("123 Some street");
        Store store1 = createStore("test-working", false, address);
        storeRepository.save(store1);
        return true;
    }




}
