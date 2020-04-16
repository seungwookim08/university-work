<!DOCTYPE html>
<html>
<head>
	<title>Question 1, Seungwoo Kim </title>
	<style type="text/css">
	table,td,tr{
	    border: 1px solid black;
    	border-collapse: collapse;
	}	
	</style>
</head>
<body>
	<h3> Test computefactorial function! </h3>
	<?php
		echo "The input is 5, the answer is ".computefactorial(5)."<br>";
		echo "The input is -3, the answer is ".var_export(computefactorial(-3),true)."<br>";
		echo "The input is 2.5, the answer is ".var_export(computefactorial(2.5),true)."<br>";	

		function computefactorial($int1){
			if ($int1<=0 || !is_int($int1)){
				return false;
			}
			else {
				$temp = 1;
				for ($i = 1;$i<=$int1;$i++){
					$temp *=$i;
				}
				return $temp;
			}
		}		
	?>
	<h3> Test findMostFrequent function! </h3>
	<?php
		$arr = array("Apple","apple","APPle","aPPle","B","C","D","Hello","Hi","1","B");
		echo "Currently array is ";
		print_r($arr);
		echo "<br>The most frequent string is : ".findMostFrequent($arr);

		function findMostFrequent($strArr){
			$temp = $strArr;
			$strArr = array_map("strtolower", $strArr);
			$strArr = array_count_values($strArr);
			arsort($strArr);
			$keys = array_keys($strArr);
			foreach ($temp as $i) {
				if (strtolower($i) == $keys[0])
				return $i;
			}
		}
	?>
	<h3> Test toUppercaseFirst function! </h3>
	<?php
		echo "The string \"hello world, this is Seungwoo Kim\" will be tested<br>";
		echo "The result is : ".toUppercaseFirst("hello world, this is Seungwoo Kim");

		function toUppercaseFirst($str){
			$str = strtolower($str);
			return ucwords($str);
		}
	?>
	<h3> Test splitCapitalizeSort function! </h3>
	<?php
		echo "The string \"hello world, this is seungwoo kim\" will be tested<br>";
		echo "The result is : ";
		print_r(splitCapitalizeSort("hello world, this is seungwoo kim"));
		echo "<br>Another test, The string \"tomato zoo apple banna melon array\" will be tested<br>";
		echo "The result is : ";
		print_r(splitCapitalizeSort("tomato zoo apple banna melon array"));

		function splitCapitalizeSort($str){
			$arr = preg_split("/[\s]+/",toUppercaseFirst($str));
			for ($i = 0;$i<sizeof($arr);$i++){
				for ($j = $i;$j<sizeof($arr);$j++){
					if (strcmp($arr[$i],$arr[$j])>0){
						$temp = $arr[$i];
						$arr[$i] = $arr[$j];
						$arr[$j] = $temp;
					}
				}
			}
			return $arr;
		}
	?>
	<h3> test dayofNextFriday function!</h3>
	<?php
		echo "Format of DD/MM/YYYY : ".dayofNextFriday();

		function dayofNextFriday(){
			$dateSec = strtotime('next Friday');
			return date('d/m/Y', $dateSec);
		}
	?>
	<h3> test findUniqueandSort function!</h3>
	<?php
		$arr = array(1,3,4,2,4,3,4,2,1,4,5);
		echo "Current array is ";
		print_r($arr);
		echo "<br>and after calling function array is ";
		print_r(findUniqueandSort($arr));

		function findUniqueandSort($arrInt){
			$noDup = array_unique($arrInt);
			sort($noDup);
			return $noDup;
		}
	?>
	<h3> test sortHash1 function!</h3>
	<?php 
		$arr = array("Seungwoo Kim" => 80000,"Jack Nicoles" => 44000,"Sophia Godin" => 21000, "Patel Ramesh" => 40000,
			"Javad Sadri" => 150000, "Anne-Julie Leblanc" => 55000);
		echo "Current array is ";
		print_r($arr);
		echo "<br>and after calling function showing in table format";
		echo(sortHash1($arr));

		function sortHash1($assoArr){
			asort($assoArr);
			print("<table>");
			foreach ($assoArr as $key => $value){
				print("<tr><td>".$key."</td><td>$".$value."</tr>");
			}
			print("</table>");
		}
	?>
	<h3> test sortHash2 function! </h3>
	<?php 
		$arr = array("Jack"=>"55", "Anita"=>"30","Ramesh"=>"40","Sophia"=>"21","Nastran"=>"41","William"=>"39","David"=>"5");
		echo "Current array is ";
		print_r($arr);
		echo "<br><h4>testing code 1</h4>";
		echo sortHash2($arr,1)."<br>";
		echo "<h4>testing code 2</h4>";
		echo sortHash2($arr,2)."<br>";
		echo "<h4>testing code 3</h4>";
		echo sortHash2($arr,3)."<br>";
		echo "<h4>testing code 4</h4>";
		echo sortHash2($arr,4)."<br>";
		echo "<h4>testing code 5</h4>";
		echo sortHash2($arr,5)."<br>";

		function sortHash2($assoArr,$code){
			if ($code == 1 || $code == 2 ||$code == 3||$code == 4){
				if ($code == 1){
					asort($assoArr);
				}
				else if ($code == 2){
					ksort($assoArr);
				}
				else if ($code == 3){
					arsort($assoArr);
				}
				else if ($code == 4){
					krsort($assoArr);
				}
				print("<table>");
				foreach ($assoArr as $key => $value){
					print("<tr><td>".$key."</td><td>".$value."</tr>");
				}
				print("</table>");
			}
			else
				print("Wrong code!");
		}

	?>
	<h3> test averageTemp function!</h3>
	<?php 
		// Please note that expected output in question sheet is wrong because there is no value of 81.
		// so list of four highest temperatures must be different from expected outputs.
		$arr = array(78, 60, 62, 68, 71, -17, 52, 68, 73, 85, 66, 64, 76, 
			65, 76, 73, 68, 62, 73, -10, 72, 65, 80, 74, 62, 62, 65, 64, 0, 68, 73, 75, 79,
			73, 77);
		echo "Recorded temperatuers are [";
		for ($i = 0;$i<sizeof($arr)-1;$i++){
			echo $arr[$i].",";
		}
		echo $arr[sizeof($arr)-1]."]"."<br>";
		averageTemp($arr);

		function averageTemp($tempArr){
			sort($tempArr);
			$aver = array_sum($tempArr) / count($tempArr);
			$length = count($tempArr);
			printf ("Average temperature is : %.2f (note that only 2 decimal points showing) <br>",$aver);
			print ("List of four lowest temperatures : ".$tempArr[0].",".$tempArr[1].",".$tempArr[2].",".$tempArr[3]."<br>");
			print ("List of four highest temperatures : ".$tempArr[$length-4].",".$tempArr[$length-3].",".$tempArr[$length-2].",".$tempArr[$length-1]."<br>");
		}
	?>
	<h3> test findatStartorEnd function!</h3>
	<?php
		echo "\"I love PHP\", \"PHP\" --> function returns : ".var_export(findatStartorEnd("I love PHP","PHP"),true)."<br>";
		echo "\"I love PHP and C++\", \"PHP\" --> function returns : ".var_export(findatStartorEnd("I love PHP and C++","PHP"),true)."<br>";
		
		function findatStartorEnd($str,$word){
			$arr = preg_split("/[\s]+/",$str);
			if ($arr[0] == $word || $arr[sizeof($arr)-1]==$word)
				return true;
			else
				return false;
		}	
	?>
</body>
</html>