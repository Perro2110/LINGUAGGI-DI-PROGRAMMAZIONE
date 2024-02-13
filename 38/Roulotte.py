from Veicoli import Veicoli
class Roulotte(Veicoli):
    def __init__(self, codice, tipo, marcaDelVeicolo, lunghezza, largezza, costoGiornaliero, postiLetto,peso,veranda) -> None:
        super().__init__(codice, tipo, marcaDelVeicolo, lunghezza, largezza, costoGiornaliero, postiLetto)
        self.peso = peso
        self.veranda = veranda

    def __str__(self) -> str:
        return self.tipo+"\t"+str(self.codice)+"\t"+self.marcaDelVeicolo+"\t"+str(self.largezza)+"\t"+str(self.lunghezza)+"\t"+str(self.postiLetto)+"\t"+str(self.peso)+"\t"+str(self.veranda)+"\t-\t"+str(self.costoGiornaliero)
    