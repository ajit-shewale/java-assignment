package com.springWeb2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springWeb2.entity.IssueRequestDao;
import com.springWeb2.repository.IssueRequestRepository;

@Service
public class IssueRequestServiceImpl {

    @Autowired
    IssueRequestRepository IssueRequestRepo;

    public List<IssueRequestDao> findAllRequests() {
        return IssueRequestRepo.findAll();
    }

    
    public void saveRequest(IssueRequestDao request) {
        IssueRequestRepo.save(request);
    }

    public void deleteRequest(int id) {
        IssueRequestRepo.deleteById(id);        
    }


    public IssueRequestDao getRequestById(int id) {
        return IssueRequestRepo.findById(id).get();
    }

//    public List<IssuedBookDao> findAllIssuedBooksIssuedBy(String userName) {
//        return IssueRequestRepo.findByissuedFor(userName);
//    }
}
