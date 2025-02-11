<?php
require_once("../db.php");

$conn = konexioaSortu();

if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $idErabiltzailea = intval($_POST["idErabiltzailea"]);

    if (isset($_POST["eguneraketa"]) && $_POST["eguneraketa"] === "fetch") {
        $sql = "SELECT e.idEskaera, e.egoera, p.izena, p.prezioa, p.irudia 
                FROM eskaera e 
                JOIN produktua p ON e.produktua_idProduktua = p.idProduktua 
                WHERE e.bezeroa_idBezeroa = ?";
    } else {
        $sql = "SELECT idEskaera, egoera FROM eskaera WHERE bezeroa_idBezeroa = ?";
    }

    $stmt = $conn->prepare($sql);
    $stmt->bind_param("i", $idErabiltzailea);
    $stmt->execute();
    $result = $stmt->get_result();

    if ($result->num_rows === 0) {
        echo json_encode(["success" => false, "message" => "Ez dago eskaerarik."]);
        exit;
    }

    $egoeraAldatuak = [];

    while ($row = $result->fetch_assoc()) {
        if (!isset($_POST["eguneraketa"])) {
            $egoeraBerria = "Ordaindua";
            $updateSql = "UPDATE eskaera SET egoera = ? WHERE idEskaera = ?";
            $updateStmt = $conn->prepare($updateSql);
            $updateStmt->bind_param("si", $egoeraBerria, $row["idEskaera"]);
            $updateStmt->execute();
            $row["egoera"] = $egoeraBerria;
        }

        $egoeraAldatuak[] = [
            "idEskaera" => $row["idEskaera"],
            "egoeraAldatua" => $row["egoera"],
            "izena" => $row["izena"] ?? "",
            "prezioa" => $row["prezioa"] ?? 0,
            "irudia" => $row["irudia"] ?? "",
            "kopurua" => 1
        ];
    }

    echo json_encode(["success" => true, "egoerak" => $egoeraAldatuak]);

    $stmt->close();
    $conn->close();
}
?>