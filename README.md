# Progetto Programmazione ad Oggetti di Abbruzzetti Matteo & Murtezi Adrian

Questo repository contiene il progetto per l'esame di Programmazione ad Oggetti (A.A. 2019-2020) del corso di Laurea in Ingegneria Informatica e dell'Automazione presso l'Università Politecnica delle Marche.

## Introduzione

Il progetto è stato sviluppato utilizzando SpringBoot Application tramite l'IDE Eclipse.
L'obiettivo del progetto è quello di creare un sito per scommettere sull'andamento delle valute. In particolare sarà possibile scommettere se una determinata valuta andrà ad aumentare o diminuire il proprio valore nel giorno successivo. Per questo motivo il sito offrirà al cliente due quote di scommessa per ogni valuta, generate tramite un semplice algoritmo, basato sulla media della valuta calcolata nelle ultime due settimane. Per calcolare questa media, i valori delle valute vengono presi dal sito di www.currencylayer.com.

## Funzionamento dell'applicazione

L'applicazione crea un server locale all'indirizzo:
**http://localhost:8080**

A tale indirizzo il cliente può fare delle richieste **GET** e **POST** per effettuare diverse operazioni:
1. restituzione di tutti i possibili cambi di valute da USD a qualsiasi altra moneta.
2. restituzione dei **metadati**, ovvero l'elenco degli attributi e del tipo.
3. restituzione delle **quote** di scommessa per ogni valuta.
4. creazione di una scommessa e visualizzazione dell'elenco di tutte le scommesse effettuate.
5. restituzione dei tassi di cambio del dollaro in determinato periodo.
6. restituzione di un elenco ordinato delle valute in base alla quantità scommessa.
7. restituzione delle statistiche richieste sulle valute.

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
Il messaggio di errore verrà visualizzato [in questo modo](https://github.com/abbru-matte/OOPproj/blob/master/Screenshots/ImportoErrato.png).


