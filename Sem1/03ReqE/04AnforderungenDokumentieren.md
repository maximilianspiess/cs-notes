# Anforderungen Dokumentieren

## Natürlich Sprachlich

Die wichtigsten Problemen dabei:

1. Unvollständig beschrieben
2. Unspezifische Substantive
3. Unvollständig spezifizierte Bedingungen
4. Unvollständige Vergleiche
5. Universalquantoren
6. Nominalisierung

## Unvollständig beschrieben

"Übertragen Sie die Daten von die Entwicklungs- in die Produktionsumgebung"

- Weche Daten genau?

Typische Fragen: Was, von wo, wohin?

Tipp:

1. Passiv-Formulierungen vermeiden: "Zur Anmeldung des Benutzers werden die Login-Daten eingegeben"
   1. Wer gibt die Daten ein, wo gibt er sie ein, usw...
   2. Aktive Formulierung: "Das System soll dem Benutzer ermöglichen, seinen User-Namen und sein Passwort über die Tastatur am Terminal einzugeben"

## Unspezifische Substantive

"Die Daten sollen dem Benutzer auf dem Terminal angezeigt werden"

- Welche Daten, welcher Benutzer, auf welchen Terminal?

Besser: "Das System soll dem registrierten Benutzer seine Rechnungsdaten auf dem Terminal, an dem er angemeldet ist, anzeigen"

## Unvollständig spezifizierte Bedingungen

Tipps:

1. bei komplexen Strukturen eine Entscheidungstabelle zur Erkennung nicht beschriebener Varianten einsetzen
2. Signalwörter für Bedingungen: "wenn...dann", "im Falle von", "abhängig von", usw.

Beispiel: "Das Restaurantsystem soll einem registrierten Gast bei einem Alter von über 17 Jahren alle im Lokal angebotenen Getränke anzeigen."

Fragen: Was, wenn er unter 17 ist, welche Getränke werden angezeigt, usw.

Besser:
Das Restaurantsystem soll einem registrierten Gast:

- Bei einem Alter von unter 16 Jahren ausschliesslich alkoholfreie Getränke anzeigen
- Bei einem Alter von 16-17 Jahren alkoholfreie und alkoholische Getränke ohne
Branntwein anzeigen
- Bei einem Alter von über 17 Jahren alle im Lokal angebotenen Getränke anzeigen

## Unvollständige Vergleiche

Problem: Adjektive sind nicht richtig spezifiziert.

„Die Daten sollen dem Benutzer schnell angezeigt werden."

Was heisst schnell?

Besser: "Das System soll die Daten sollen dem Benutzer innerhalb von max. 2 Sekunden anzeigen.."

## Universalquantoren

Problem: Mengen und Häufigkeiten sind unpräzise

Beispel: "Das System soll in jedem Untermenü alle Datensätze anzeigen."

Sicher in jedem Untermenü und tatsächlich alle Daten?

Tipp: auf Wörter wie *nie, immer, kein, jeder, alle, irgendeiner, nichts* schauen.

## Nominalisierung

Problem: Durch Nominalisierung wird ein längerer Prozess zu ein einziges Ereignis gemacht.

Beispiel: Bei einem Systemabsturz soll ein Neustart des
Systems erfolgen“on "übermitteln" wird "die Übermittlung".

Systemabsturz und Neustart sind Prozesse, die genauer angeschaut werden müssen. Was heisst Systemabsturz und wie ergolgt ein Neustart?

Tipp: Nominalisierungen prüfen, ob sie woanders im Detail erklärt wurden. Wenn nicht, eine weitere Anforderung schreiben.
