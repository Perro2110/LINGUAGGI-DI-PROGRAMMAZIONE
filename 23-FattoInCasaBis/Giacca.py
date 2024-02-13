from Articoli import Articoli
class Giacca(Articoli):
    def __init__(self, cod, tipo, marca, taglia, modello, costo, scontoInPercentuale,peso) -> None:
        super().__init__(cod, tipo, marca, taglia, modello, costo, scontoInPercentuale)
        self.peso = peso

    def __str__(self) -> str:
        return self.tipo+"\t"+str(self.cod)+"\t"+self.marca+"\t"+self.modello+"\t"+self.taglia+"\t"+"-"+"\t"+str(self.peso)+"\t"+str(self.costo)+"\t"+str(self.scontoInPercentuale)