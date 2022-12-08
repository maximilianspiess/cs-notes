# Snailsweeper

## Spielablauf

1. Spiele wählt eins der bedeckten Felder (per Textinput oder mit der Maus)
2. Wenn das Feld keine Schnecke enthält, wird es freigegeben und die Anzahl umliegende Schnecken werden angezeigt.
3. Der Spieler kann dann weiterspielen, bis er entweder eine Schnecke aufdeckt oder alle nicht-Schnecken-Felder aufgedeckt hat
4. Die anderen Zwei Möglichkeiten bei einem Zug sind, dass er ein Feld mit einer Flagge markiert, oder dass er eine Schnecke aufdeckt.
   1. Beim ersten passiert nichts ausser, dass ein Feld als markiert gesetzt wird
   2. Beim letzten verliert der Spieler das Spiel

## Spielablauf im Hintergrund

1. Das Board muss aktualisiert angezeigt werden.
2. Der Input vom Spieler muss aufgenommen werden.
3. Wenn der Input eine Markierung war, wird das Feld markiert (oder unmarkiert, wenn es schon markiert war)
4. Wenn der Input ein Feld freigeben war, wird geschaut, was im Feld steckt
   1. Wenn im Feld eine Schnecke ist, dann wird das Spiel gestoppt
   2. Wenn im Feld keine Schnecke ist, dann wird das Feld augedeckt
      1. Wenn es aufgedeckt wird, müssen alle umliegende Felder auf Schnecken durchgesucht werden. Für jede Schnecke geht der Zähler eine Stelle hoch
      2. Schlussendlich wird der Zähler in das Feld reingeschrieben.
         1. Ist das Feld von keinen Schnecken umrundet, dann werden alle umliegende Felder auch aufgedeckt und für jedes die Anzahl an umliegende Schnecken berechnet und angezeigt.

## Aufgabenanforderungen

### Vom Spiel selber

1. Das Brett ist *n* breit und *m* hoch. Diese Zahlen sind variabel.
2. Das Brett ist von einem Rand umrundet.
3. Jede Zelle kann eins von vier **states** haben:
   1. L: living snail
   2. C: crushed snail
   3. E: Empty (no snail)
   4. Solid (not pickable)
4. Jede Zelle hat auch eine **visibility**:
   1. H: Hidden
   2. V: Visible
   3. F: Flagged
5. Im Feld können **S** Zellen frei verteilt werden.
6. Am Anfang sind alle Zellen, die nicht **S** sind, versteckt.
7. Beim Laden werden Schnecken mit einer 0.1 (10%) Wahrscheinlichkeit *random* auf das Feld gesetzt. Natürlich nur da, wo keine **S** Felder sind.
8. Eine Zelle kann nur vom Zustand **L** ins **C** wechseln. Das Markieren von Zellen hat auf den Zustand keinen Einfluss.
9. Ein Spieler kann bei einem Zug Felder nur (un)markieren und aufdecken.
10. Wird ein freies Feld maufgedeckt, dann werden alle Felder um diesen Feld auch aufgedeckt.

### Von der Programmierungsseite

1. Eine `Grid` Klasse, um das Feld zu repräsentieren
2. Eine `GridSerializer` Klasse. Diese Klasse muss die methoden `String serialize(Grid grid)` und `Grid deserialize(String str)` implementieren.
3. Bei der GUI muss ein Mausclick das Feld aufdecken und ein Ctrl+click das Feld markieren.
4. Die ConsoleApp wird in der Klasse `ConsoleApp` implementiert und die GUI App in der Klasse `JavaFxApp`. Beide Klassen kommen in ein Package `app`.
5. **Alle gegebene Tests müssen bestanden werden**

## Mögliche Implementation

1. Die Game loops laufen in den jeweiligen App-Klassen.
2. Beim Starten erstellt die `Grid` Klasse ein Board
   1. Ein Enum `Type` definiert den Typ des Feldes. Genauso gibt es ein enum `State`.
   2. Um das Board zu erstellen wird ein 2-dimensionales array erstellt. Alle Felder mit den Positionen [0, x], [y, 0], [y, n] und [m, x] werden auf `Type.SOLID` gestellt. So wird die Wand dargestellt.
   3. Dann werden die Steine platziert. Hierfür wird eine zufällige Anzahl definiert und zufällige Positionen zwischen n und m definiert.
   4. Danach werden Schnecken platziert. Da die Wahrscheinlichkeit 10% ist, wird n * m * 0.1 gerechnet, um die korrekte Anzahl zu finden. Dann werden zufällige Nummern für n und m generiert. Bevor aber eine Schnecke platziert wird, muss überprüft werden, ob ein Feld schon einen `Type.SOLID` enthält. Wenn nicht, wird dieser Feld auf `Type.SNAILALIVE`gesetzt, sonst werden zwei neue n und m generiert. So, bis alle Schnecken gesetzt wurden.
   5. Wenn alle Felder erfüllt sind, fängt das Spiel an.
   6. Ein Input vom Spieler wird gelesen.
      1. Dieser Input wird auf korrektheit überprüft (in der ConsoleApp).
         1. Ein korrekter Input besteht aus zwei kleine Buchstaben und eine Nummer. (Regex: `^[a-z]{2}[0-9]{1,2}`)
      2. Wenn der Input nicht korrekt ist, wird wieder für ein Input gefragt.
   7. Mit dem Input wird in das `Grid` geschaut, was an der Position ist, die eingegeben wurde. Dafür muss zuerst das kleine Buchstabe für *n* in eine Zahl umgewandelt werden.
      1. Dies wird am besten mit einem Hashmap gemacht, wo Zahlen und Buchstaben verbunden sind.
   8. Mit umgewanelten Input kann die Position im Array geprüft werden.
      1. Ist die Position auserhalb des Grids, wird nach eine neue Position gefragt.
      2. Ist die Position schon offen, wird für eine neue Position gefragt.
      3. Ist die Position ein `Type.SOLID`, wird für eine neue Position gefragt.
      4. Wenn das Input `flag` war:
         1. Auf `State.UNFLAGGED` setzen, wenn es `State.FLAGGED` war
         2. Auf `State.FLAGGED` setzen, wenn es `State.UNFLAGGED` war
      5. Wenn das Input `uncover` war:
         1. Wenn das Feld `Type.SNAILALIVE` ist:
            1. Feld öffnen, auf `Type.SNAILDEAD` und `State.UNCOVERED` setzen und end-screen anzeigen.
         2. Wenn das Feld `Type.EMPTY` ist:
            1. Ausrechnen, wie viele umliegende Felder `Type.SNAILALIVE` sind;
               1. Felder zu überprüfen:
                  1. Links: [inputX - 1, inputY]
                  2. Links oben: [inputX - 1, inputY - 1]
                  3. Oben: [inputX, inputY - 1]
                  4. Rechts oben: [inputX + 1, inputY - 1]
                  5. Rechts: [inputX + 1, inputY]
                  6. Rechts unten: [inputX + 1, inputY + 1]
                  7. Unten: [inputX, inputY + 1]
                  8. Links unten: [inputX - 1, inputY + 1]

HIER AUFGEHÖRT. BEIM SCHNECKEN ZÄHLEN.
