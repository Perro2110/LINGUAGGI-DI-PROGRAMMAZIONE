from Veicoli import Veicoli

class Furgone(Veicoli):
    def __init__(self, codice, tipo, targa, modello, marca, costoGiornaliero,categoria,numPosti,vanoDiCarico):
        super().__init__(codice, tipo, targa, modello, marca, costoGiornaliero)
        self.categoria = categoria
        self.numPosti  = numPosti
        self.vanoDiCarico = vanoDiCarico
    

    "tipo, targa, codice, modello, marca, costo giornaliero,cilindrata, bagagliaio, categoria, numero di posti, vano di carico"
    def __str__(self) -> str:
        return self.tipo+"\t"+self.targa+"\t"+str(self.codice)+"\t"+self.modello+"\t"+self.marca+"\t"+str(self.costoGiornaliero)+"\t-"+"\t-"+self.categoria+"\t"+str(self.numPosti)+"\t"+str(self.vanoDiCarico)