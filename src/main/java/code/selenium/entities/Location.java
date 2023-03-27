package code.selenium.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

	String city;
	String address;
	String ph_no;
	String Loc_type;
	String Loc_hrs;
}

