<?php 

// http://localhost:8001/security/parameter.php?name=FRANZ
// http://localhost:8001/security/parameter.php?<script type = "text/javascript">alert('hacked by XSS');</script>

	$variable = $_REQUEST['name'];
	echo "HALLO " . $variable . " !" ;
?>