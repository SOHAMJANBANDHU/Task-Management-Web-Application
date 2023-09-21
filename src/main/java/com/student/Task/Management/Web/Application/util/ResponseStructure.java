package com.student.Task.Management.Web.Application.util;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResponseStructure {

	private String  message;
	private int statuscode;
	private ResponseStructure data;
	
	
}
