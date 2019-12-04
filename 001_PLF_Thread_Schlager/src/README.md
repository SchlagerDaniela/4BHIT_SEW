# Anforderungen / Beurteilung (3,5 / 17,5%)

## Klassenhierarchie (4 / 0)
- [ ] Erweiterung um neue Produkte leicht und ohne Code-Änderungen
    - keine Klassenhierarchie, Erweiterung nur mit massiven Codeänderungen 
- [ ] Unterscheidung durch Text-Attribut oder instanceof
    - es war nicht gemeint eine eigene Klasse "Klassenhierarchie" zu erstellen

## Produzenten (8 / 2,5)
- [x] 2 für Leberkäse/Bosna
- [ ] produzieren  Tresen voll (40 Produkte)
    - Schwerer Fehler: String Vergleich mit equals!!! 
    - Schwerer Fehler: Collection Größe mit .size()
- [x] Produktion Leberkässemmel 10ms, Bosnas 20ms
- [ ] Waren beliebige Reihenfolge ausgegeben
    - funktioniert nicht: remove() ohne Parameter entfernt nichts!
- [x] keine Concurrent-Klassen

## Konsumenten (8 / 1)
- [x] 4 (je 2 für Leberkässemmerl/Bosnas)
- [ ] Konsument überlegt zw. 5 und 50ms
    - keine Berechnung
- [ ] Verdauungspause 5ms
    - fehlt
- [ ] anschließend neue Nahrung „organisieren“
    - funktioniert nicht: remove() ohne Parameter entfernt nichts!
    - Schwerer Fehler: String Vergleich mit equals!!! 
    - Schwerer Fehler: Collection Größe mit .size()

## Sonstiges
- Angabe missverstanden -> Klassenhierarchie != main
- nicht kompilierbar!
