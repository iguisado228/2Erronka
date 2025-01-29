<!DOCTYPE html>
<html lang="es">

<head>
    <link rel="stylesheet" href="css_m.css">
    <style>
        body#SaioaHasi {
            margin: 0;
            padding: 0;
            background: linear-gradient(150deg, darkblue, lightblue);
            height: 100vh;
        }

        #saioHasiera {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 400px;
            background-color: white;
            border-radius: 10px;
        }

        #saioHasiera h1 {
            text-align: center;
            padding: 0 0 20px 0;
            border-bottom: 1px solid silver;
            padding-top: 10px;
        }

        #saioHasiera form {
            padding: 0 40px;
            box-sizing: border-box;
        }

        .erabiltzailea,
        .pasahitza {
            position: relative;
            border-bottom: 2px solid #adadad;
            margin: 30px 0;
        }

        .erabiltzailea input,
        .pasahitza input {
            width: 100%;
            padding: 0 5px;
            height: 40px;
            font-size: 16px;
            border: none;
            background: none;
            outline: none;
        }

        .erabiltzailea label,
        .pasahitza label {
            position: absolute;
            top: 50%;
            left: 5px;
            color: #adadad;
            transform: translateY(-50%);
            font-size: 16px;
            pointer-events: none;
            transition: .5s;
        }

        .erabiltzailea input:focus~label,
        .pasahitza input:focus~label {
            top: -5px;
            color: purple;
        }

        .erabiltzailea input:focus~span::before,
        .pasahitza input:focus~span::before {
            width: 100%;
        }

        .erabiltzailea span::before,
        .pasahitza span::before {
            content: '';
            position: absolute;
            top: 40px;
            left: 0;
            width: 100%;
            height: 2px;
            background-color: purple;
            transition: .5s;
        }

        .pasahitzaBerrezarri {
            margin: -5px 0 20px 5px;
            color: blue;
            cursor: pointer;
        }

        .pasahitzaBerrezarri:hover {
            text-decoration: underline;
        }

        input[type="submit"] {
            width: 100%;
            height: 50px;
            border: 1px solid;
            background: purple;
            border-radius: 25px;
            font-size: 18px;
            color: white;
            cursor: pointer;
            outline: none;
        }

        input[type="submit"]:hover {
            border-color: purple;
            transition: .5s;
        }

        .erregistratu {
            margin: 30px 0;
            text-align: center;
            font-size: 16px;
            color: black;
        }

        .erregistratu a {
            color: blue;
            text-decoration: none;
        }

        .erregistratu a:hover {
            text-decoration: underline;
        }

        /**/

        div .active {
            background-color: #272D65;
        }

        .btnAbrirlehioa {
            padding: 10px 20px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            font-size: 16px;
        }

        .btnAbrirlehioa:hover {
            background-color: #0056b3;
        }

        .lehioa {
            display: none;
            position: fixed;
            z-index: 3;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            align-items: center;
            justify-content: center;
            z-index: 2000;
        }

        .lehioa:target {
            display: flex;
        }

        .lehioa-contenido {
            position: relative;
            background-color: #272D65;
            color: white;
            padding: 20px;
            border-radius: 10px;
            width: 30%;
            height: 20%;
            text-align: center;
            padding: 80px;
        }

        .sesioHasiera {
            width: 100%;
        }

        .itxi {
            position: absolute;
            top: 10px;
            right: 20px;
            text-decoration: none;
            font-size: 30px;
            color: white;
        }
    </style>
</head>
<body>
<div class="lehioa-contenido">
    <a href="#" class="itxi">&times;</a>
    <h1>Saio Hasiera</h1>
    <form method="POST">
        <div class="erabiltzailea">
            <input class="sesioHasiera" type="text" id="erabiltzailea" name="erabiltzailea" required />
            <label for="erabiltzailea">Erabiltzailea</label>
        </div>
        <div class="pasahitza">
            <input class="sesioHasiera" type="password" id="pasahitza" name="pasahitza" required />
            <label for="pasahitza">Pasahitza</label>
        </div>
        <input type="submit" value="Saioa Hasi">
        <div class="erregistratu">
            <a href="erabiltzaileaErregistratu.php">Erregistratu</a> egin nahi dut.
        </div>
    </form>
</div>
<?php

?>
</body>