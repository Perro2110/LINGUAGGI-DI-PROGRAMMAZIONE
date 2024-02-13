from Articoli import Articoli
class Pantaloni(Articoli):
    def __init__(self, cod, tipo, marca, taglia, modello, costo, scontoInPercentuale,numTasche) -> None:
        super().__init__(cod, tipo, marca, taglia, modello, costo, scontoInPercentuale)
        self.numTasche = numTasche

    def __str__(self) -> str:
        return self.tipo+"\t"+str(self.cod)+"\t"+self.marca+"\t"+self.modello+"\t"+self.taglia+"\t"+str(self.numTasche)+"\t"+"-"+"\t"+str(self.costo)+"\t"+str(self.scontoInPercentuale)