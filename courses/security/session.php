<?php

    #Browser 1:  http://localhost:8001/security/session_02.php?sid=1ab2c3&user=ich&pwd=123
    #Browser 2:  http://localhost:8001/security/session_02.php?sid=1ab2c3

    //start the session
    session_id($_REQUEST['sid']);
    session_start();
            
    echo "user: " . $_REQUEST['user'] . " - pwd: " .$_REQUEST['pwd'] ."<br/>";

    if($_SESSION == null) {
        $_SESSION['var_1'] = $_REQUEST['user'];
        $_SESSION['var_2'] = $_REQUEST['pwd'];
    }

    print_r($_SESSION);

    echo "<br /> sid: " . session_id();

#    session_destroy();
?>