from Veicoli import Veicoli
class Caravan(Veicoli):
    def __init__(self, codice, tipo, marcaDelVeicolo, lunghezza, largezza, costoGiornaliero, postiLetto,potenza) -> None:
        super().__init__(codice, tipo, marcaDelVeicolo, lunghezza, largezza, costoGiornaliero, postiLetto)
        self.potenza = potenza
    
    def __str__(self) -> str:
        return self.tipo+"\t"+str(self.codice)+"\t"+self.marcaDelVeicolo+"\t"+str(self.largezza)+"\t"+str(self.lunghezza)+"\t"+str(self.postiLetto)+"\t-"+"\t-\t"+str(self.potenza)+"\t"+str(self.costoGiornaliero)
    
