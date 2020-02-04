# PLF "Distributed Calculator"

Entwickle eine Simulation eines parallelisierten Taschenrechners in Form eines Producer-Consumer Beispiels.
Für die Simulation werden von den Produzenten unendlich viele Rechnungen erzeugt, welche von den Consumenten gelöst werden. 
Es werden nur einfache Grundrechnungsarten erzeugt.

Es dürfen keine Concurrent-Collections verwendet werden. Das Programm ist mittels Warten/Benachrichtigen zu lösen.

## Klassenhierarchie (6 / 4)
- [x] die Klasse ```Calculation``` beinhaltet je 2 Operanden, sowie eine Methode ```calculate()```
- [x] ```calculate()``` liefert das Ergebnis der jeweiligen Rechenoperation
- [x] je Rechenoperation gibt es genau eine abgeleitete Klasse
- [ ] die Operanden werden zufällig erzeugt, wobei diese Werte zwischen -1000 und +1000 annehmen können. 
Ausnahme ist die Division, da muss der 2. Operand zusätzlich positiv sein!
- [x] die Rechenoperationen benötigen Zeit, daher wird in der Simulation zusätzlich zur tatsächlichen Rechenzeit für 
Strichrechnungen 10ms und für Punktrechnungen 20ms gewartet

## Produzenten (6 / 3)
- [ ] erstelle 2 Produzenten, welche zufällig eine der 4 Rechnungsarten erzeugen
- [x] eine einmal erstellte Rechnung muss in eine FIFO Queue gestellt und darf nicht verworfen werden
- [x] die Produktionsdauer einer Rechnung wird mit einer zufälligen Zeit zw. 10 und 20ms simuliert 
- [ ] die Produktion ist in der Konsole zu dokumentieren

## Konsumenten (6 / 5)
- [x] erstelle 2 Konsumenten, welche nach dem FIFO Prinzip Rechnungen abarbeiten
- [ ] die Berechnung, sowie das Ergebnis sind in der Konsole auszugeben
- [x] die Berechnungsdauer ist in der Simulation einzuhalten
- [x] sobald eine Rechnung erledigt ist, versucht der Konsument die nächste Aufgabe zu erlangen und diese zu lösen

## Erweiterung (2 /0)
- [ ] Erweitere das Programm die Rechenart "Exponieren", der erste Operand ist die Basis, der zweite Operand der Exponent
- [ ] die Rechenzeit für Exponieren liegt bei 30ms
- [ ] in Consumer und Producer darf nichts geändert werden!  

## Beurteilung:
- Klassenhierarchie:
   - calculate sollte abstrakt definiert werden
   - Rechenzeichen zur Ausgabe wäre gut
   - Fehler in Berechnung der Operanden: Bereich: -1000 - 0
   
- Produzenten:
   - Produzent erzeugt immer nur Calculation anstatt konkrete Berechnungen. Was soll Calculation schon berechnen?
   - Dokumentation in der Konsole unvollständig - es werden nur die Operatoren angezeigt (nicht nachvollziehbar)
   
- Konsumenten:
    - funktionert nicht, weil keine korrekten Calculations erstellt wurden
    - Ausgabe nicht vollständig - Rechnenoperation fehlt
    
- Erweiterung:
    - fehlt
    
- Sonstiges:
  - Programm läuft nicht richtig
  - in Main werden konkrete Rechenoperationen an Konsument/Produzent übergeben
  
Sonstige Abzüge: Programm nicht lauffähig, Deadlocks, Abstürze, kein Warten/Benachrichtigen,...

Aufgabe                                 | Punkte
----------------------------------------|-------------------------------------
Klassenhierarchie                       | 4 / 6
Produzent                               | 3 / 6
Konsument                               | 5 / 6
Erweiterung                             | 0 / 2
Sonstige Abzüge                         |  -0     
__Gesamt__                              | __12/20__