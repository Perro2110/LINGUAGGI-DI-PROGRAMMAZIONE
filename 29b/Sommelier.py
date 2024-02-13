from Impiegati import Impiegati 
class Sommelier (Impiegati):
    def __init__(self, cod, tipo, nomeDipendete, costoorario,oreSettimanali,specialita) -> None:
        super().__init__(cod, tipo, nomeDipendete, costoorario)
        self.oreSettimanali = oreSettimanali
        self.specialita     = specialita
    
    def __str__(self) -> str:
        return self.nomeDipendete+"\t"+str(self.cod)+"\t"+self.tipo+"\t"+str(self.oreSettimanali)+"\t"+self.specialita+"\t-"+"\t-"+"\t-\t"+str(self.costoorario)


    