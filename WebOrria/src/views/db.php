<?php

function konexioaSortu()
{
    $servername = "172.16.237.150";
    $username = "administratzailea";
    $password = "1234";
    $dbname = "2erronka";
    
    $conn = new mysqli($servername, $username, $password, $dbname);
    
    if ($conn->connect_error) {
        die("Konexioan hurrengo errorea gertatu da: " . $conn->connect_error);
    }

    return $conn;
}
?>
