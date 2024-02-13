from Dipendenti import Dipendenti
class Trainer(Dipendenti):
    def __init__(self, cod, tipo, nome, costoOrario,oreSettimanali,specialita) -> None:
        super().__init__(cod, tipo, nome, costoOrario)
        self.oreSettimanali = oreSettimanali
        self.specialita     = specialita

    def __str__(self) -> str:
        return self.nome+"\t"+str(self.cod)+"\t"+self.tipo+"\t"+str(self.oreSettimanali)+"\t"+self.specialita+"\t"+"-"+"\t"+"-"+"\t"+"-\t"+str(self.costoOrario)


