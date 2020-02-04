# 210_SimpleService

## Aufgabe:
Erstelle einen Task, dem ein int-Parameter übergeben werden kann
- Die Aufgabe des Tasks ist das Zählen bis zu diesem Wert, wobei bei jeder Iteration 10ms gewartet werden muss
- Über `updateMessage()` wird ein String übergeben - je nach "Fortschritt" des Tasks. Dieser ist am Button als Text anzuzeigen
  - "Ready to count"
  - "Counting"
  - "READY"
- Während des Zählvorgangs ist der Fortschritt über `updateProgress()` zu aktualisieren
- Binde folgende Properties an den Fortschritt des Services
  - `opacityProperty`
  - `scaleXProperty`
  - `scaleYProperty`
  - `textProperty`
- Der Task ist in einem Service zu kapseln, welcher sofort bei Anwendungsbeginn startet
- Sobald der Service fertig ist, kann er durch Klick auf den Button erneut gestartet werden
