SELECT     
o.OrdreID,    k.KundeID,    k.Kundenavn,    k.Addresse,   k.Telefon,   od.OrdreDetaljeID,    m.PizzaID,    m.Navn AS PizzaNavn,    m.Pris AS PizzaPris,    od.Antal AS PizzaAntal,    
(m.Pris * od.Antal) AS PizzaSubtotal, -- Beregning af pizzaens subtotal    
IFNULL(SUM(oe.ExtraPris * oe.Antal), 0) AS ToppingPris, -- Beregning af topping-pris
(m.Pris * od.Antal + IFNULL(SUM(oe.ExtraPris * oe.Antal), 0)) AS TotalPris -- Totalpris inkl. Toppings
FROM     Ordre o
JOIN     Kunde k 
ON o.KundeID = k.KundeID
LEFT JOIN     OrdreDetalje od ON o.OrdreID = od.OrdreID
LEFT JOIN     Menu m ON od.PizzaID = m.PizzaID
LEFT JOIN     OrdreExtra oe ON od.OrdreDetaljeID = oe.OrdreDetaljeID
LEFT JOIN     Inventar i ON oe.InventarID = i.InventarID
WHERE     o.OrdreID = 1 
GROUP BY     od.OrdreDetaljeID;
