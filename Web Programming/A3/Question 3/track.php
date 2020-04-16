<?php
    ob_start();
?>
<!DOCTYPE html>
<html>
<head>
	<title>Tracking number of times of page views</title>
</head>
<body>
	<?php 	
		date_default_timezone_set('US/Eastern');
		$Months = 60 * 60 * 24 * 60 + time();
		if (!isset($_COOKIE['count'])){
	    	echo "Welcome! You are a new custmer here"; 
	        $record = 1;
	        setcookie("count", $record);	        
			setcookie('lastVisit', date('g:ia \o\n l jS F Y'), $Months);
    	}
    	else {
	        $record = ++$_COOKIE['count'];
	        $lastVisitTime = $_COOKIE['lastVisit'];
	        setcookie("count", $record);
	        setcookie('lastVisit', date('g:ia \o\n l jS F Y'), $Months);
			echo "Hello, this is your ".$_COOKIE['count']." times here"."<br>"; 
			echo "Your last visited date and time was ".$lastVisitTime;
		}
	?> 

</body>
</html>
<?php
    ob_end_flush(); 
?>