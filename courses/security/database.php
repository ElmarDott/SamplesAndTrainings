<?php
$success = FALSE;
$user = $_POST['user'];
$pwd = $_POST['pwd'];
$UUID = 0;

$SQL = "SELECT * FROM sample_user WHERE name='" . $user . "' AND password='" . $pwd . "';";
$dbh = pg_connect("host=192.168.0.12 port=5432 dbname=together-test user=together password=together");

if (!$dbh) {
    die("Error in connection: " . pg_last_error());
}

$result = pg_query($dbh, $SQL);

while ($row = pg_fetch_array($result)) {
    echo "<p>Name: " . $row[1] . " - ";
    echo "PWD: " . $row[2] . "<p />";
    $UUID = $row[0];

    $success = TRUE;
}


echo "SQL Statement: <b>" . $SQL . "</b><br/>";
?>

<html>
    <head>
        <title>SQL INJECTION SAMPLE</title>
    </head>

    <body>
        <h1>SQL Injection Sample</h1>
        <form action="<? $PHP_SELF ?>" method="post">
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