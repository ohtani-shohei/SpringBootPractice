package com.example.taskmate.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class TaskSummary {
	
	private Integer taskId;
	private String taskName;
	private Date limitDate;
	private StatusRecord status;
//	private String statusCode;
//	private String statusName;
	private Integer memoCnt;

}
