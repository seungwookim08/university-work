// Initializing. 
obj = {balance:500, bankCharge: 0.5};
// This javascript has withdrawAmount() Function. 
function validateAmount() {	
	// global variable (Object)
	

	// another global variable. 
	x = parseFloat(document.getElementById("input1").value);

	// It makes sure entered input is number or not. If not, alert a message “Please enter numeric value” otherwise.
	if (isNaN(x)){	    		
		alert("Please enter numeric value");	    		
	} else {
		withdrawAmount();
	}
	// return false to use same cache (not refreshing)
	return false;
}
