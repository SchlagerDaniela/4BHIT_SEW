# 301_MulServer

## Aufgabe:
Entwickle einen Client + Server für die Multiplikation von 2 int-Zahlen.
Verwende 2 Run-Configurations in einem Projekt.
Client und Server sollten genügend Konsolen-Output generieren, damit man den Ablauf nachvollziehen kann (und Fehler in der Kommunikation gegebenfalls schneller findet).

### Server
- wartet auf eine eingehende Verbindung auf Port 2000
- empfängt 2 int-Werte, multipliziert diese und schickt das Ergebnis retour
- nach dem Senden wird die Verbindung getrennt

### Client
- baut Verbindung zu Server auf Port 2000 Aufgabe
- schickt 2 zufällige int-Werte
- wartet auf Ergebnis und gibt dieses aus
