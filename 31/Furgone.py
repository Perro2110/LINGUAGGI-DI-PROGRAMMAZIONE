from Veicoli import Veicoli 
class Furgone(Veicoli):
    def __init__(self, codice, tipo, targa, modello, marca, costoGiornaliero,rimorchio,numPosti,vanoCarico) -> None:
        super().__init__(codice, tipo, targa, modello, marca, costoGiornaliero)
        self.rimorchio = rimorchio
        self.numPosti = numPosti
        self.vanoCarico = vanoCarico

    print("tipo, targa, codice, modello, marca, costo giornaliero,bagagliaio, cilindrata, categoria, rimorchio, numero di posti,vano di carico")
        
    def __str__(self) -> str:
        return self.tipo+"\t"+self.targa+"\t"+str(self.codice)+"\t"+self.modello+"\t"+self.marca+"\t"+str(self.costoGiornaliero)+"\t"+"\t-"+"\t-"+"\t-"+self.rimorchio+"\t"+str(self.numPosti)+"\t"+self.vanoCarico