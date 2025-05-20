package com.example.taskmate.service;

import java.util.List;

import com.example.taskmate.entity.StatusRecord;

public interface StatusService {
	
	public List<StatusRecord> findAll();
	
	public StatusRecord findByCode(String statusCode);

}
