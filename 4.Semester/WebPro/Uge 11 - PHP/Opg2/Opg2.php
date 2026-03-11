<?php
// Iterate through all query string parameters
foreach ($_GET as $key => $value) {
    echo "$key: $value<br>\n";
}

// Check if parameter 'a' exists and print its value
if (isset($_GET['a'])) {
    echo "<br>\nVærdien af parameter 'a' er: " . $_GET['a'];
}
?>
