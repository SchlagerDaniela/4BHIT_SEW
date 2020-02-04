# 901_Camera

Implementiere eine grafische Demo mittels libGDX, welche die Funktionalität der Orthographic Camera veranschaulicht.

Zeige die Map 'sc_map.png' an. Wähle eine passende Größe (Weltkoordinaten) 

## Aufgaben

## Tastenabfragen
Verwende folgenden Code für die Tastenabfragen, diese Methode wird in der Gameloop aufgerufen.

```
  private void handleInput() {
       if (Gdx.input.isKeyPressed(Input.Keys.A)) {
          ...
       }
       ...
  }
```

## Camera Steuerung
Der User steuert über Tasteneingaben folgende Funktionen
- [ ] Rein-/Rauszoomen
- [ ] Rotieren (im/gegen Uhrzeigersinn)
- [ ] Bewegen (rauf/runter/links/rechts)
