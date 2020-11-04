package com.springtest2.beans;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmployeeList {
	
	 @JsonProperty("list")
	private List<Employee>employees=new ArrayList<>(); 
}
