SELECT 
o.OrdreID, 
k.Kundenavn, 
o.TotalPris, 
o.LeveringsStatus 
FROM Ordre o 
JOIN Kunde k ON o.KundeID = k.KundeID;
