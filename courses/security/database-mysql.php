<?php
$success = FALSE;
$UUID = 0;
$user = $_POST['user'];
$pwd = $_POST['pwd'];

$dbc = mysqli_connect("172.18.0.3", "root", "s3cr3t", "test");

if ($dbc->connect_error) {
  die("Connection failed: " . $dbc->connect_error);
}

// standard abfrage -------------------------------------------------------------------

$SQL = "SELECT * FROM sample_user WHERE name='" . $user . "' AND password='" . $pwd . "';";
echo "SQL Statement: <b>" . $SQL . "</b><br/>";

$result = $dbc->query($SQL);


// ------------------------------------------------------------------------------------

// parameterisierte abfrage
$stmt = mysqli_prepare($dbc, "SELECT * FROM sample_user WHERE name=? AND password=?;");

// bindet die parameter
mysqli_stmt_bind_param($stmt, 'ss', $user, $pwd);

// baut das fertig SQL zusammen
# $check = mysqli_stmt_execute($stmt);

if( $check ) {

    $result = mysqli_stmt_get_result($stmt);
    echo "<b>Parameteriesiertes SQL Statement accessed</b><br/>";

} else {

    echo "<b>ERROR in parameterisiertem SQL Statement: </b>" . $SQL . "<br/>";
}

while ($row = $result->fetch_assoc()) {
    echo "<p>Name: " . $row['name'] . " - ";
    echo "PWD: " . $row['password'] . "<p />";
    $UUID = $row['uuid'];

    $success = TRUE;
}

?>

<html>
    <head>
        <title>SQL INJECTION SAMPLE</title>
    </head>

    <body>
        <h1>SQL Injection Sample</h1>
        <form action="<?php $_SERVER['PHP_SELF'] ?>" method="post">
            User:<br/>
            <input type="text" name="user" value="<?php echo $user ?>" /><br />
            Passwort:<br/>
            <input type="text" name="pwd" value="<?php echo $pwd ?>" /> <br/><br />
            <input type="submit" value="Submit">
        </form>
    </body>
</html>

<?php
if ($success) {
    echo "<h1> Login success !</h1>";
    echo "<p>Welcome " . $UUID . "</p>";
}
?>