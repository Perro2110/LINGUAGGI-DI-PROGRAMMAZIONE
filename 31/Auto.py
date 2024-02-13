from Veicoli import Veicoli 
class Auto(Veicoli):
    def __init__(self, codice, tipo, targa, modello, marca, costoGiornaliero,capienzaBagagliaio,cilindrata,categoria) -> None:
        super().__init__(codice, tipo, targa, modello, marca, costoGiornaliero)
        self.capienzaBagagliaio = capienzaBagagliaio
        self.cilindrata = cilindrata
        self.categoria = categoria
       
    def __str__(self) -> str:
        return self.tipo+"\t"+self.targa+"\t"+str(self.codice)+"\t"+self.modello+"\t"+self.marca+"\t"+str(self.costoGiornaliero)+"\t"+str(self.capienzaBagagliaio)+"\t"+str(self.cilindrata)+"\t"+self.categoria+"\t-"+"\t-"+"\t-"