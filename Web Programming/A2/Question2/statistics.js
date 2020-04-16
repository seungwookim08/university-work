stats();
// stats Function code. 
function stats(){
	text = "You have entered  below mentioned numbers <br>";

	// prompt boxes for user input
	var prom = prompt("Enter the value that you wish to enter! enter -1 to quit", -1);
	evenCount = 0;
	oddCount = 0;

	// it will keep prompting to user until user enter -1. 
	while (prom != -1){
		var intX = parseInt(prom);

		// input validation. isNaN is a graceful way to check if input is number or not.
		if (!isNaN(intX)){
			text += intX + "<br>";
			if (intX%2 == 0)
				evenCount++;
			else
				oddCount++;
			var prom = prompt("Previous input was recorded \nEnter the value that you wish to enter! enter -1 to quit", -1)
		}

		// if it is NaN it means that it contains string or empty (note that empty input is also NaN)
		else {
			var prom = prompt("Previous input contained String, it was not recorded.\nEnter the value that you wish to enter! enter -1 to quit", -1)
		}
					
	}

	text += "You have entered " + evenCount + " even number(s) and " + oddCount + " odd number(s).";
	
	// displaying the result.
	document.getElementById("statsOut").innerHTML = text;
}
