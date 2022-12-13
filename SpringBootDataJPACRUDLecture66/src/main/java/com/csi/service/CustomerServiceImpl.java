package com.csi.service;

import com.csi.dao.CustomerDaoImpl;
import com.csi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl {
    @Autowired
    CustomerDaoImpl customerDaoImpl;

    public Customer saveData(Customer customer){
        return customerDaoImpl.saveData(customer);
    }

    public List<Customer> getAllData(){
        return customerDaoImpl.getAllData();
    }

    public Customer updateData(Customer customer)
    {
        return customerDaoImpl.updateData(customer);
    }

    public void deleteData(int custId){
        customerDaoImpl.deleteData(custId);
    }
}
