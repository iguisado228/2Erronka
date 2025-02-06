<?php

function konexioaSortu()
{
    $servername = "localhost";
    $username = "root";
<<<<<<< HEAD
    $password = "1MG2024";
    $dbname = "2erronka";
=======
    $password = "1mg3@2024";
    $dbname = "2.erronka";
>>>>>>> 2648d2332af5d7b4ef7b4fed47752ef56696df91
    
    $conn = new mysqli($servername, $username, $password, $dbname);
    
    if ($conn->connect_error) {
        die("Konexioan hurrengo errorea gertatu da: " . $conn->connect_error);
    }

    return $conn;
}
?>
