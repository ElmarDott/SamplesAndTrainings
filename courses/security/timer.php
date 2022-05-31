<?php

$date = new DateTime();
$timestamp = $date->getTimestamp();
$timer = 30;

if( !isset($_COOKIE['sid']) ) {
    $hash = $timestamp . $_SERVER['REMOTE_ADDR'] . rand();
    $sid = hash('sha512', $hash);
    setcookie("sid", $sid, $timestamp + $timer);

} else {
    $sid = $_COOKIE['sid'];
}

session_id($sid);
session_start();
 
if( !isset($_SESSION['user']) && !isset($_SESSION['pwd']) ) {

    $_SESSION['user'] = $_GET['user'];
    $_SESSION['pwd'] = $_GET['pwd'];
}
    
if( $_SESSION['timestamp'] == 0 ) {

    $_SESSION['timestamp'] = $timestamp;
}

$diff = $timestamp - $_SESSION['timestamp'];

echo "<b>sid:</b> " . $sid . "<br />"; 
echo "TIMESTAMP: " . $timestamp . " IP Adress: " . $_SERVER['REMOTE_ADDR'] . "<br/>";
echo "<b>URL Parameter</b> - user: " . $_GET['user'] . " - pwd: " . $_GET['pwd'] ."<br/>";
echo "DIFF: " . $diff ." - TIMER: ". $timer . "<br/>";

if ($diff >= $timer) {
    echo "<b>SESSION TIME OUT - AUTO LOGOUT</b><br/>";
    session_unset();
    session_destroy();

} else {
    $_SESSION['timestamp'] = $timestamp;
}

echo "<pre>\n";
var_dump($_SESSION);
echo "</pre>\n\n";

?>