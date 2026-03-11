<?php

$filename = "Opg1.txt";
$handle = fopen($filename, "r"); // Open for reading
if ($handle) {
    $content = fread($handle, filesize($filename)); // Read entire file
    echo $content;
    fclose($handle); // Close the file
} else {
    echo "Error: Could not open file.";
}