# Progetto Programmazione ad Oggetti di Abbruzzetti Matteo & Murtezi Adrian

Questo repository contiene il progetto per l'esame di Programmazione ad Oggetti (A.A. 2019-2020) del corso di Laurea in Ingegneria Informatica e dell'Automazione presso l'Università Politecnica delle Marche.

## Introduzione

Il progetto è stato sviluppato utilizzando SpringBoot Application tramite l'IDE Eclipse.<br>
L'obiettivo del progetto è quello di creare un sito per scommettere sull'andamento delle valute. In particolare sarà possibile scommettere se una determinata valuta andrà ad aumentare o diminuire il proprio valore nel giorno successivo. Per questo motivo il sito offrirà al cliente due quote di scommessa per ogni valuta, generate tramite un semplice algoritmo, basato sulla media della valuta calcolata nelle ultime due settimane. Per calcolare questa media, i valori delle valute vengono presi dal sito di www.currencylayer.com.

## Funzionamento dell'applicazione

L'applicazione crea un server locale all'indirizzo:
**http://localhost:8080**

A tale indirizzo il cliente può fare delle richieste **GET** e **POST** per effettuare diverse operazioni:
1. restituzione di tutti i possibili cambi di valute da USD, che è la moneta di default per il piano gratuito di CurrencyLayer, a qualsiasi altra moneta.
2. restituzione dei **metadati**, ovvero l'elenco degli attributi e del tipo.
3. restituzione delle **quote** di scommessa per ogni valuta. Ogni quota viene calcolata mediante un algoritmo, basato sull'andamento della valuta nelle ultime due settimane; ovviamente, la quota non potrà mai essere inferiore ad 1.01.
4. creazione di una scommessa e visualizzazione dell'elenco di tutte le scommesse effettuate. Nell'elenco vengono visualizzati l'id della scommessa, la valuta su cui ha scommesso, il segno scelto, la quota di scommessa, l'importo che ha giocato, la potenziale vincita e la data in cui è stata effettuata.
5. restituzione dei tassi di cambio del dollaro in un determinato periodo.
6. restituzione di un elenco ordinato delle valute in base alla quantità scommessa. Le valute vengono ordinate in modo decrescente in base alla somma dei vari importi delle scommesse su quella valuta.
7. restituzione delle statistiche richieste sulle valute: i valori di cambio, la media, la varianza e la deviazione standard in un determinato periodo di tempo. Inoltre viene stampato un messaggio che informa l'utente se la quotazione attuale della valuta è maggiore o minore della media mensile.

La seguente tabella spiega nel dettaglio come effettuare le diverse richieste all'interno di Postman:

| **Rotta** | **Metodo** | **Parametri** | **Descrizione**|
| --- | --- | --- | --- |
| /valute | GET | Non richiesti | Restituisce tutti i possibili cambi |
| /metadati | GET | Non richiesti | Restituisce i metadati |
| /quotes | GET | currency | Restituisce le quote di scommessa per una valuta scelta |
| /bet | POST | Non richiesti | Effettua una scommessa |
| /bet | GET | Non richiesti | Restituisce tutte le scommesse |
| /valoristorici | GET | from,to,currencies | Restituisce i valori storici di una o più valute |
| /classifiche | GET | Non richiesti | Restituisce una classifica delle valute più scommesse |
| /currencies/statistics | GET | from,to,currencies | Restituisce le statistiche di una o più valute |
<br>

Per quanto riguarda la richiesta POST della rotta /bet è necessario inserire un body in formato Json dove vengono specificati: 
- la valuta su cui l'utente vuole scommettere;
- il segno scelto (1 se prevede che il valore della valuta salirà, 2 se prevede che il valore della valuta scenderà);
- l'importo che l'utente vuole puntare.<br>

Di seguito un esempio per capire meglio come viene effettuata la scommessa: 

![alt text](https://github.com/abbru-matte/OOPproj/blob/master/Screenshots/RichiestaPOSTdiBet.png)

Nel caso in cui l'utente inserisca un importo minore o uguale a zero, verrà restituito un messaggio d'errore e la scommessa non verrà piazzata.
Il messaggio di errore verrà visualizzato in questo modo: [Esempio](https://github.com/abbru-matte/OOPproj/blob/master/Screenshots/ImportoErrato.png).

## Parametri

Nella rotta "/quotes" nel parametro **currency** l'utente specifica la valuta di cui vuole conoscerne le quote di scommessa.<br>
Nelle rotte "/valoristorici" e "/currencies/statistics" i parametri **from** e **to** indicano rispettivamente le date d'inizio e di fine del periodo che l'utente vuole analizzare, i quali devono essere inseriti nel formato "yyyy-MM-dd"; nel parametro **currencies** l'utente può specificare le valute delle quali desidera visualizzare i valori storici e le statistiche. Se questo parametro viene lasciato vuoto verranno visualizzati i dati per tutte le valute.

Nel caso in cui l'utente inserisca nel parametro **to** una data antecedente a quella inserita nel parametro from, verrà visualizzato un messaggio di errore.<br>
Il messaggio di errore verrà visualizzato in questo modo: [Esempio](https://github.com/abbru-matte/OOPproj/blob/master/Screenshots/DataErrata.png)

## Diagrammi UML
### Diagramma dei casi d'uso 
![alt text](https://github.com/abbru-matte/OOPproj/blob/master/UML/UseCaseDiagram.png)

### Diagrammi delle classi
**package com.ProgettoEsameScommesse:**<br>
![alt text](https://github.com/abbru-matte/OOPproj/blob/master/UML/ClassDiagramApplication.png)

**package controller:**<br>
![alt text](https://github.com/abbru-matte/OOPproj/blob/master/UML/ClassDiagramController.png)

**package service:**<br>
![alt text](https://github.com/abbru-matte/OOPproj/blob/master/UML/ClassDiagramService.png)

**package database:**<br>
![alt text](https://github.com/abbru-matte/OOPproj/blob/master/UML/ClassDiagramDatabase.png)

**package Exceptions:**<br>
![alt text](https://github.com/abbru-matte/OOPproj/blob/master/UML/ClassDiagramExceptions.png)

**package model:**<br>
![alt text](https://github.com/abbru-matte/OOPproj/blob/master/UML/ClassDiagramModel.png)

**package Statistiche:**<br>
![alt text](https://github.com/abbru-matte/OOPproj/blob/master/UML/ClassDiagramStatistiche.png)

### Diagrammi delle sequenze
**getValute**<br>

![alt text](https://github.com/abbru-matte/OOPproj/blob/master/UML/getValute.png)

**getMetadati**<br>

![alt text](https://github.com/abbru-matte/OOPproj/blob/master/UML/getMetadati.png)

**getBetQuotes**<br>

![alt text](https://github.com/abbru-matte/OOPproj/blob/master/UML/getBetQuotes.png)

**postBet**<br>

![alt text](https://github.com/abbru-matte/OOPproj/blob/master/UML/postBet.png)

**getBet**<br>

![alt text](https://github.com/abbru-matte/OOPproj/blob/master/UML/getBet.png)

**getValoriStorici**<br>

![alt text](https://github.com/abbru-matte/OOPproj/blob/master/UML/getValoriStorici.png)

**getClassificheScommesse**<br>

![alt text](https://github.com/abbru-matte/OOPproj/blob/master/UML/getClassificheScommesse.png)

**getStatistics**<br>

![alt text](https://github.com/abbru-matte/OOPproj/blob/master/UML/getStatistics.png)

