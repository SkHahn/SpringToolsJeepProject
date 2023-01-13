package com.promineotech.entity;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class OrderRequest {
	
	@NotNull
	@Size (max = 30)
	@Pattern(regexp = "[\\w\\s]*")
	private String customer;
	
	@NotNull
	private JeepModel model;
	
	@NotNull
	@Size (max = 30)
	@Pattern(regexp = "[\\w\\s]*") 
	private String trim;
	
	@Positive
	@Min(2)
	@Max(4)
	private int doors;
	
	@NotNull
	@Size (max = 30)
	@Pattern(regexp = "[\\w\\s]*") 
	private String color;
	
	@NotNull
	@Size (max = 30)
	@Pattern(regexp = "[\\w\\s]*") 
	private String engine;
	
	@NotNull
	@Size (max = 30)
	@Pattern(regexp = "[\\w\\s]*") 
	private String tire;

	
	private List<@Size(max = 30) @Pattern(regexp = "[A-Z0-9_]*") String> options;
  
  
  
}
