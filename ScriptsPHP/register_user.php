<?php
    //call connectionDB file
    include("connectionDB.php");

    //Get XML input values
    $email = $_POST['email'];

    //Create SQL INSERT
    $sql = "INSERT INTO users (email) VALUES('$email')";

    //Execute SQL and validate operation
    if($conn->query($sql) === TRUE){
        echo "user has been registered into data base";
    }{
        die("The error es".$conn->error);
    }

?>