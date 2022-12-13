package com.csi.controller;

import com.csi.model.Customer;
import com.csi.service.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<Customer> saveData(@RequestBody Customer customer){
        log.info("####Saving Data For CUSTOMER"+customer.getCustName());
        return ResponseEntity.ok(customerServiceImpl.saveData(customer));
    }

    @GetMapping("/getdata/{custId}")
    public ResponseEntity<List<Customer>> getAllData(){
        log.info("####List Size : "+customerServiceImpl.getAllData().size());
        return ResponseEntity.ok(customerServiceImpl.getAllData());
    }

    @GetMapping("/updatedata/{custId}")
    public ResponseEntity<Customer>updateData(@PathVariable int custId, @RequestBody Customer customer){
        return ResponseEntity.ok(customerServiceImpl.updateData(customer));
    }

    @DeleteMapping("/deletedata/{custId}")
    public ResponseEntity<String>deleteData(@PathVariable int custId){
        customerServiceImpl.deleteData(custId);
        return ResponseEntity.ok("Data Deleted SuccessFully");
    }
}
