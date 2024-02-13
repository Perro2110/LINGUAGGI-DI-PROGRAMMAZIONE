from Veicoli import Veicoli

class Auto(Veicoli):
    def __init__(self, codice, tipo, targa, modello, marca, costoGiornaliero,cilindrata,capienza):
        super().__init__(codice, tipo, targa, modello, marca, costoGiornaliero)
        self.cilindrata = cilindrata
        self.capienza =capienza

    "tipo, targa, codice, modello, marca, costo giornaliero,cilindrata, bagagliaio, categoria, numero di posti, vano di carico"
    def __str__(self) -> str:
        return self.tipo+"\t"+self.targa+"\t"+str(self.codice)+"\t"+self.modello+"\t"+self.marca+"\t"+str(self.costoGiornaliero)+"\t"+str(self.cilindrata)+"\t"+str(self.capienza)+"\t-"+"\t-"+"\t-"
    