<?php
    //Connection variables - MYSQL credenciales
    $servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "market";
    $port = "3306";

    $conn = new mysqli(
        $servername,
        $username,
        $password,
        $dbname
    );
    //che connection

    if ($conn->connect_error){
        die("Connection failed:".$conn->connect_error);
    }{
        echo "Conneciton sucessfully";
    }

?>