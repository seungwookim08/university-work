// This javascript has validateAmount() Function. 
window.onload;
function withdrawAmount() {	
	// Note that x is from validateAmount.js 

	// 3 cases, 1) if it's not a multiple of 20, alert Incorrect withdrawal amount
	// 2) Insufficient funds
	// 3) and withdraw successful. 
	if ((x%20) != 0){			
		alert("Incorrect withdrwal amount");
	}
	else if (obj.balance < (x+obj.bankCharge)){				
		alert("Insufficient funcds");
	}
	else{
		obj.balance -= (x + obj.bankCharge);
		alert("Successful transaction! \n Current Balance is:" + obj.balance);
	}
	// return false to use same cache (not refreshing)
	return false;
}