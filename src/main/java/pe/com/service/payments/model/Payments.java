package pe.com.service.payments.model;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Document(collection = "payments")
public class Payments {

	 @Id
	    private String id;
	    private String name;
	    private double amount;
	    private double commission;
	    private String description;
	    @DateTimeFormat(pattern = "yyyy-mm-dd")
	    private Date createDate;
	    private String statusDeuda;
	    private String creditId;
	 
	   
	    
	    

}

